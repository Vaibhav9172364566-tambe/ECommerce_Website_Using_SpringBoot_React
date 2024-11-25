import { Box, Button } from '@mui/material'
import React from 'react'
import { useNavigate } from 'react-router-dom'
import OrderStepper from './OrderStepper';

const OrderDetails = () => {
 
   const navigate=useNavigate(); 

  return (
    <Box className='space-y-5'>
        <section className='flex flex-col gap-5 justify-center items-center'>
            <img className='w-[100px]' src={"https://media.gettyimages.com/id/172380146/photo/gold-watch.jpg?s=2048x2048&w=gi&k=20&c=HjkjL79rKuEFWYQRTVUHO8SLyyn7-v_y1dYQmDZTeXU="} alt='' ></img>
            <div className='text-sm space-y-1 text-center'>
                <h1 className='font-bold'>{"Virani Cloting"}</h1>
                <p>Cellecor RAY 1.43" AMOLED Dispaly | 700 NITS | AOD | BT-Calling | Ai VOICE | Split screen Samrtwath (black Strap,Free Size</p>
                <p><strong>Size : </strong>M</p>
            </div>
            <div>
                <Button onClick={()=>navigate(`/reviews/${5}/create`)}>Write Review

                </Button>
            </div>

        </section>

        <section className='border p-5'>
            <OrderStepper orderStatus={"SHIPPED"}></OrderStepper>

        </section>
        
    </Box>
  )
}

export default OrderDetails