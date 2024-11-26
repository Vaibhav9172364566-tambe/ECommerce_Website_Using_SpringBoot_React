import { Box, Button, Divider } from '@mui/material'
import React from 'react'
import { useNavigate } from 'react-router-dom'
import OrderStepper from './OrderStepper';
import { Payments } from '@mui/icons-material';

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

           <div className='border p-5'>
             <h1 className='font-bold pb-3'>Delivery Address</h1>
             <div className='text-sm space-y-2'>
                <div className='flex gap-2 font-medium'>
                    <p>{"Vaibhav"}</p>
                    <Divider flexItem orientation='vertical'></Divider>
                     <p>{9172364566}</p>


                </div>
                <p>Kranti Chowuk, SambhajiNagar, Maharashtra - 411023</p>

             </div>

           </div>
                 


             <div className='border space-y-4'>
                <div className='flex justify-between text-sm pt-5 px-5'>
                <div className='space-y-1'>
                    <p className='font-bold'>Total Item Price</p>
                    <p>You saved <span className='text-green-500 font-medium text-xs'>₹ {699}.00</span>on this item</p>

                </div>

                <p className='font-medium'>₹{799}.00</p>

             </div>
             <div className='px-5'>
                <div className='bg-teal-50 px-5 py-2 text-xs font-medium flex items-center gap-3 '>
                    <Payments></Payments>
                    <p>Pay On Delivery</p>

                </div>

             </div>


                <Divider></Divider>
                <div className='px-5 pb-5'>
                    <p className='text-xs'><strong>Sold by : </strong>{"Virani Clothing"}</p>

                </div>

                <div className='p-10'>
                    <Button

                    disabled={false}

                    color='error' sx={{py :"0.7rem"}} className='' variant='outlined' fullWidth
                    >{true ? "Order cancled ":"Cancle Order"}</Button>

                </div>



                </div>
    </Box>
  )
}

export default OrderDetails