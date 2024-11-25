import { ElectricBolt } from '@mui/icons-material'
import { Avatar } from '@mui/material'
import { teal } from '@mui/material/colors'
import React from 'react'

const OrderItem = () => {
  return (
    <div className='text-sm bg:white p-5 space-y-4 border rounded-md cursor-pointer'>
        <div className='flex items-center gap-5'>
            <div>
                <Avatar sizes='small' sx={{bgcolor:teal[500]}}><ElectricBolt></ElectricBolt></Avatar>

            </div>
            <div>
                <h1 className='font-bold text-primary'>PENDING</h1>
                <p>Arriving By MOn,15 Jul</p>

            </div>

        </div>

        <div className='p-5 bg-teal-50 flex gap-3'> 
            <div>
                <img 
                className='w-[70px]'
                src='https://media.gettyimages.com/id/172380146/photo/gold-watch.jpg?s=2048x2048&w=gi&k=20&c=HjkjL79rKuEFWYQRTVUHO8SLyyn7-v_y1dYQmDZTeXU=' alt=''></img>
            </div>
            <div className='w-full space-y-2'>
                <h1 className='font-bold'>Virani Clothing  </h1>
                <p>Cellecor RAY 1.43" AMOLED Dispaly | 700 NITS | AOD | BT-Calling | Ai VOICE | Split screen Samrtwath (black Strap,Free Size)</p>

                <p>
                    <strong>size : </strong>FREE
                </p>
            </div>

        </div>

    </div>
  )
}

export default OrderItem