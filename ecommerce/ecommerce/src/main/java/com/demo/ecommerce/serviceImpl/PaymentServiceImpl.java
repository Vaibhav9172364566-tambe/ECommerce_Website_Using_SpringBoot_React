package com.demo.ecommerce.serviceImpl;

import java.util.Set;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.demo.ecommerce.domain.PaymentOrderStatus;
import com.demo.ecommerce.domain.PaymentStatus;
import com.demo.ecommerce.modal.Order;
import com.demo.ecommerce.modal.PaymentOrder;
import com.demo.ecommerce.modal.User;
import com.demo.ecommerce.repositiory.OrderRepository;
import com.demo.ecommerce.repositiory.PaymentOrderRepository;
import com.demo.ecommerce.service.PaymentService;
import com.razorpay.Payment;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.billingportal.Session;
import com.stripe.Stripe;
import com.stripe.param.checkout.SessionCreateParams;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentOrderRepository paymentOrderRepository;
    private OrderRepository orderRepository;
    private String apiKey = "apikey";
    private String apiSecret = "apiSecret";
    private String stripeSecretKey = "stripesecretkey";

    @Override
    public PaymentOrder createOrder(User user, Set<Order> orders) {

        Long amount = orders.stream().mapToLong(Order::getTotalSellingPrice).sum();
        PaymentOrder paymentOrder = new PaymentOrder();
        paymentOrder.setAmount(amount);
        paymentOrder.setUser(user);
        paymentOrder.setOrders(orders);
        return paymentOrderRepository.save(paymentOrder);

    }

    @Override
    public PaymentOrder getPaymentOrderById(Long orderId) throws Exception {

        return paymentOrderRepository.findById(orderId).orElseThrow(() -> new Exception("payment order not found"));
    }

    @Override
    public PaymentOrder getPaymentOrderByPaymentId(String orderId) throws Exception {
        PaymentOrder paymentOrder = paymentOrderRepository.findBypaymentLinkId(orderId);
        if (paymentOrder == null) {
            throw new Exception("payment order not found with payment link id");
        }
        return paymentOrder;

    }

    @Override
    public Boolean ProceedPaymentOrder(PaymentOrder paymentOrder, String paymentId, String paymentLinkId)
            throws RazorpayException {

        if (paymentOrder.getStatus().equals(PaymentOrderStatus.PENDING)) {

            RazorpayClient rezorpay = new RazorpayClient(apiKey, apiSecret);
            Payment payment = rezorpay.payments.fetch(paymentId);

            String status = payment.get("status");
            if (status.equals("captured")) {
                Set<Order> orders = paymentOrder.getOrders();
                for (Order order : orders) {
                    order.setPaymentStatus(PaymentStatus.COMPLATED);
                    orderRepository.save(order);

                }
                paymentOrder.setStatus(PaymentOrderStatus.SUCCESS);
                paymentOrderRepository.save(paymentOrder);
                return true;
            }
            paymentOrder.setStatus(PaymentOrderStatus.FAILED);
            paymentOrderRepository.save(paymentOrder);
            return false;

        }
        return false;

    }

    @Override
    public PaymentLink createRazorpayPaymentLink(User user, Long amount, Long orderId) throws RazorpayException {

        amount = amount * 100;
        try {
            RazorpayClient rezorpay = new RazorpayClient(apiKey, apiSecret);

            JSONObject paymentLinkReqest = new JSONObject();
            paymentLinkReqest.put("amount", amount);
            paymentLinkReqest.put("currency", "INR");

            JSONObject customer = new JSONObject();
            customer.put("email", user.getEmail());
            customer.put("name", user.getFullName());
            paymentLinkReqest.put("customer", customer);

            JSONObject notify = new JSONObject();
            notify.put("email", true);
            paymentLinkReqest.put("notify", notify);

            // callback url
            paymentLinkReqest.put("callback_url", "http://localhost:8888/payment-success" + orderId);

            paymentLinkReqest.put("callback_method", "get");

            // payment link
            PaymentLink paymentLink = rezorpay.paymentLink.create(paymentLinkReqest);
            String paymentLinkUrl = paymentLink.get("short_url");
            String paymentLinkId = paymentLink.get("id");

            return paymentLink;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RazorpayException(e.getMessage());
        }

    }

    @Override
    public String createStripePaymentLink(User user, Long amount, Long orderId) throws StripeException {

        Stripe.apiKey = stripeSecretKey;
        com.stripe.param.checkout.SessionCreateParams params = com.stripe.param.checkout.SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://localhost:8888/payment-success/" + orderId)
                .setCancelUrl("http://localhost:8888/payment-cancel")
                .addLineItem(SessionCreateParams.LineItem.builder()
                        .setQuantity(1l)
                        .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
                                .setCurrency("usd")
                                .setUnitAmount(amount * 100)
                                .setProductData(
                                        SessionCreateParams.LineItem.PriceData.ProductData
                                                .builder().setName("Vaibhav Tambe bazar")
                                                .build()

                                ).build()).build()

                ).build();
        com.stripe.model.checkout.Session session = com.stripe.model.checkout.Session.create(params);

        return session.getUrl();

    }

}
