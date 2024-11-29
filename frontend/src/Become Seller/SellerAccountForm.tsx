import { Button, Step, StepLabel, Stepper } from '@mui/material';
import React, { useState } from 'react';
import BecomeSellerFormSteup1 from './BecomeSellerFormSteup1';
import { useFormik } from 'formik';
import BecomeSellerFormStep2 from './BecomeSellerFormStep2';

const steps = [
  "Tax Details & Mobile",
  "Pickup Address",
  "Bank Details",
  "Supplier Details",
];

const SellerAccountForm = () => {
  const [activeStep, setActiveStep] = useState(0); // Initialize step as 0
  const handleStep = (direction: number) => () => {
    // Update step only if within bounds
    if (activeStep + direction >= 0 && activeStep + direction < steps.length) {
      setActiveStep(prevStep => prevStep + direction);
    }
  };

  const handleCreateAccount = () => {
    console.log("Create Account");
  };

  const formik = useFormik({
    initialValues: {
      mobile: "",
      otp: "",
      gstin: "",
      pickupAddress: {
        name: "",
        mobile: "",
        pincode: "",
        address: "",
        locality: "",
        city: "",
        state: "",
      },
      bankDetails: {
        accountNumber: "",
        ifscCode: "",
        accountHolderName: "",
      },
      sellerName: "",
      email: "",
      businessDetails: {
        businessName: "",
        businessEmail: "",
        businessMobile: "",
        logo: "",
        banner: "",
        businessAddress: ""
      },
      password: ""
    },
    // Add validationSchema if needed

    onSubmit: (values) => {
      console.log(values, "Formik submitted");
    }
  });

  return (
    <div>
      <Stepper activeStep={activeStep} alternativeLabel>
        {steps.map((label, index) => (
          <Step key={label}>
            <StepLabel>{label}</StepLabel>
          </Step>
        ))}
      </Stepper>

      <section className='mt-20 space-y-10'>
  
       <div > 
       {activeStep === 0 ? 
          <BecomeSellerFormSteup1 formik={formik} /> :
          activeStep ==1 ? <BecomeSellerFormStep2 formik={formik}></BecomeSellerFormStep2>
         : ""}
       </div>

        

<div className='flex items-center justify-between'>
        <Button onClick={handleStep(-1)} variant='contained' disabled={activeStep === 0}>
          Back
        </Button>

        <Button
          onClick={handleStep(1)}
          variant='contained'
        >
          {activeStep === steps.length - 1 ? "Create Account" : "Continue"}
        </Button>
      </div>
        {/* Add other steps here */}
      </section>

     
    </div>
  );
};

export default SellerAccountForm;
