import { Button, Step, StepLabel, Stepper } from '@mui/material'
import React, { useState } from 'react'


const steps=[
    "Tax Details & Mobile",
    "Pickup Address",
    "Bank Details",
    "Supplier Details",
]

const SellerAccountForm = () => {

    const [activeStep,setActiveStep]=useState(1)
    const handleStep=(value:number)=>()=>{


        (activeStep >steps.length-1 || activeStep>0 && value-1) &&          setActiveStep(activeStep+value);



         activeStep ==steps.length-1 && handleCreateAccount();
         
         console.log("active step",activeStep);
         
    }

    const handleCreateAccount =() =>{

        console.log("Create Account");
        

    }


  return (
    <div>
        <Stepper activeStep={activeStep} alternativeLabel>
            {steps.map((label,index)=>(
                <Step key={label}>
                    <StepLabel>{label}</StepLabel>

                </Step>
            ))}

        </Stepper>

        <section>

        </section>
        <div className='flex items-center justify-between'>
            <Button onClick={handleStep(-1)} variant='contained' disabled={activeStep==0}>Back</Button>

            <Button onClick={handleStep(1)} variant='contained'>
                {activeStep==(steps.length-1) ? "Create Account" :"continue"}</Button>


        </div>
    </div>
  )
}

export default SellerAccountForm