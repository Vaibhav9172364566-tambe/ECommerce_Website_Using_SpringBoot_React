import React from 'react'
import  './ShopByCategory.css'
import ShopByCategory from './ShopByCategory';
const ShopByCategoryCard = () => {
  return (

    <div className='flex gap-3 flex-col justify-center items-center group cursor-pointer'>

   <div className='custome-border w-[150px] h-[150px] lg:w-[249px] lg:h-[249px] rounded-full bg-primary '>
    <img
    className=' rounded-full group-hover:scale-95 transition-transform transform-duration-700 object-top h-full w-full'


    src="https://imgs.search.brave.com/2xNmH2sF5Jp1glQGv4ix7r6jVf2qIA7NhUrqDF4HFcI/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9jZG4u/bW9zLmNtcy5mdXR1/cmVjZG4ubmV0L25C/MzdmTm44TTJTZFZS/ckFnb0JGTkMtMzIw/LTgwLmpwZw" alt=''></img>
   

   </div>
   <h1>Kitchen & Table</h1> 

    </div>
  )
}

export default ShopByCategoryCard