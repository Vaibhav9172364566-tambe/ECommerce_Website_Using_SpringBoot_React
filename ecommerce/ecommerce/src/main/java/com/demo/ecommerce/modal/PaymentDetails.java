package com.demo.ecommerce.modal;
 

import com.demo.ecommerce.domain.PaymentStatus;

import lombok.Data;

@Data
public class PaymentDetails {

    private String paymentId;
    private String vaibhavpayPaymentLinkId;
    private String vaibhavpayPaymentLinkReferenceId;
    private String vaibhavPaymentLinkStatus;
    private String vaibhavpayPaymentIdZWSP;
   private PaymentStatus status;
   


}
