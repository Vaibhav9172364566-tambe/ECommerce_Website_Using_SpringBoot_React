import React, { useEffect, useState } from 'react';
import { Box } from '@mui/material';
import { FiberManualRecord, CheckCircle } from '@mui/icons-material';

const steps = [
  { name: "Order Placed", description: "on Thu, 11 Jul", value: "PLACED" },
  { name: "Packed", description: "Item Packed in Dispatch Warehouse", value: "CONFIRM" },
  { name: "Shipped", description: "by Mon, 15 Jul", value: "SHIPPED" },
  { name: "Arriving", description: "by 16 Jul - 18 Jul", value: "ARRIVING" },
  { name: "Arrived", description: "by 16 Jul - 18 Jul", value: "DELIVERED" },
];

const canceledStep = [
  { name: "Order Placed", description: "on Thu, 11 Jul", value: "PLACED" },
  { name: "Order Canceled", description: "on Thu, 11 Jul", value: "CANCELLED" },
];

const currentStep = 3; // Update this dynamically based on your app logic

const OrderStepper = ({ orderStatus }: { orderStatus: string }) => {
  const [statusStep, setStatusStep] = useState(steps);

  useEffect(() => {
    if (orderStatus === 'CANCELLED') {
      setStatusStep(canceledStep);
    } else {
      setStatusStep(steps);
    }
  }, [orderStatus]);

  return (
    <Box className="my-10">
      {statusStep.map((step, index) => (
        <div key={index} className="flex px-4">
          <div className="flex flex-col items-center">
            <Box
              sx={{ zIndex: -1 }}
              className={`w-8 h-8 rounded-full flex items-center justify-center z-10 ${
                index <= currentStep
                  ? "bg-gray-200 text-teal-500"
                  : "bg-gray-300 text-gray-600"
              }`}
            >
              {step.value === orderStatus ? (
                <CheckCircle sx={{ color: 'green' }} />
              ) : (
                <FiberManualRecord sx={{ zIndex: -1 }} />
              )}
            </Box>

            {/* Show the connecting line between steps */}
            {index < statusStep.length - 1 && (
              <div
                className={`border h-20 w-[2px] ${
                  index < currentStep
                    ? "bg-teal-500"
                    : "bg-gray-300 text-gray-600"
                }`}
              ></div>
            )}
          </div>

          <div className="mi-2 w-full">
            <div
              className={`${
                step.value === orderStatus
                  ? "bg-teal-500 p-2 text-white font-medium rounded -translate-y-3"
                  : ""
              } ${orderStatus === "CANCELLED" && step.value === orderStatus ? "bg-red-500" : ""} w-full`}
            >
              <p>{step.name}</p>
              <p
                className={`${
                  step.value === orderStatus ? "text-gray-200" : "text-gray-500"
                } text-xs`}
              >
                {step.description}
              </p>
            </div>
          </div>
        </div>
      ))}
    </Box>
  );
};

export default OrderStepper;