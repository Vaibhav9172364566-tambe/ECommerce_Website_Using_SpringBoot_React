import React, { useState } from 'react'
import CardItem from './CardItem'
import { Close, LocalOffer } from '@mui/icons-material'
import teal from '@mui/material/colors/teal'
import { Button, IconButton, TextField } from '@mui/material'
import PricingCard from './PricingCard'
import { Navigate, useNavigate } from 'react-router-dom'

const Card = () => {
  const [couponCode,setCouponCode]=useState("")

  const handleChange =(e:any)=>{
           setCouponCode(e.target.value)
  }

  const navigate =useNavigate()


  return (
    <div className='pt-10 px-5 sm:px-10 md:px-60 min-h-screen'>

      <div className='grid grid-cols-1 lg:grid-cols-3 gap-5'>
        {/* all map the card  item*/}
        <div className='cartItemSection lg:col-span-2 space-y-3'>
          {[1, 1, 1, 1, 1, 1, 1].map((item) => <CardItem></CardItem>)}

        </div>

        {/* pricing part */}
        <div className='col-span-1 text-sm space-y-3  '>

          <div className='border rounded-md px-5 py-3 space-y-5 '>
            <div className='flex gap-3 text-sm items-center'>
              <div className='flex gap-3 text-sm items-center'>
                <LocalOffer sx={{ color: teal[600], fontSize: "17px" }}></LocalOffer>
              </div>
              <span>Apply Coupons</span>

            </div>
 
   {true ?
            <div className='flex justify-between'>
              <TextField 
              onChange={handleChange}
              id='outlined-basic' 
              placeholder='coupon code' size='small'
              variant='outlined'></TextField>
              <Button
              
              size='small'>Apply</Button>
            </div>

           :<div
           className='flex'>
            <div className='p-1 pl-5 pr-3 border rounded-md flex gap-2 items-center'>

              <span className=''> VAIBHAV Applied

              </span>
              <IconButton size='small'>
                <Close className='text-red-600'></Close>
              </IconButton>

            </div>
            </div>}

            

          </div>

            <div className='border rounded-sm'>
              <PricingCard></PricingCard>
              <div>
                <Button
                onClick={()=>navigate("/checkout")}
                className='p-5'
                fullWidth variant='contained' sx={{py:"11px"}}>Buy now</Button>
              </div>
            </div>

        </div>

      </div>
    </div>
  )
}

export default Card