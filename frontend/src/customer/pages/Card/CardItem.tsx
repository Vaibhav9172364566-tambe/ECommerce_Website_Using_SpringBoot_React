import { Add, Close, Remove } from '@mui/icons-material'
import { Button, Divider, IconButton } from '@mui/material'
import React from 'react'

const CardItem = () => {
    const handleUpdateQuantity =()=>{
      //update cart item quantity



    }
  return (
    <div className='border rounded-md relative'>

        <div className='p-5 flex gap-3'>
            <div className=''>
                <img 
                className='w-[90px] rounded-sm'
                src='https://www.lashkaraa.in/cdn/shop/products/Lashkaraa21May1150.jpg?v=1664275887&width=360' alt=''></img>

            </div>

            <div className=' space-y-2'>
                <h1 className='font-semibold text-lg '>Virani Clothing</h1>
                <p className='text-gray-600 font-medium text-sm'> Blue Stonework Statin Design Saree </p>
                <p className='text-gray-400 text-xs'><strong>Sold by:</strong>Natural Lifestyle Products Private Limited</p>
                <p className='text-sm'>7 days replacement available</p>
                <p className='text-sm text-gray-500'><strong>quantity :</strong>5</p>

                </div>

            </div>
            <Divider></Divider>

            <div className='flex justify-between items-center'>
            <div className='px-5 py-2 flex justify-between items-center'>
                  <div className='flex items-center gap-2 w-[140px] justify-between'>
                  <Button onClick={handleUpdateQuantity}
                disabled={true}
                >
                  <Remove></Remove>
                </Button>
                <span>
                {5}


                </span>
                <Button onClick={handleUpdateQuantity}>
                  <Add></Add>
                </Button>


                  </div>
            </div>
            <div className='pr-5'>
              <p className='text-gray-700 font-medium'> ₹799</p>
             </div>
            </div>

            <div className='absolute top-1 right-1'>
              <IconButton  color='primary' >
                <Close></Close>
              </IconButton>

            </div>

    </div>
  )
}

export default CardItem