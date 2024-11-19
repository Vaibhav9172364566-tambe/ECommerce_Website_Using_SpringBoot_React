import React from 'react'
import StarIcon from '@mui/icons-material/Star'
import { teal } from '@mui/material/colors'
import { Button, Divider } from '@mui/material'
import { Add, AddShoppingCart, FavoriteBorder, LocalShipping, Remove, Shield, Wallet, WorkspacePremium } from '@mui/icons-material'

const ProductDetails = () => {

  const [quantity,setQuantity]=React.useState(1);

  return (
    <div className='px-5 lg:px-20 pt-20'>
      <div className='grid grid-cols-1 lg:grid-cols-2 gap-10'>
        <section className='flex flex-col lg:flex-row gap-5'>
          <div className='w-full lg:w-[15%] flex flex-wrap lg:flex-col gap-3'>
            {[1, 1, 1, 1].map((item, index) => (
              <img
                key={index}
                className='lg:w-full w-[50px] cursor-pointer rounded-md'
                src='https://www.lashkaraa.in/cdn/shop/products/Laskara09-10-233370.jpg?v=1704559930&width=1946'
                alt='Saree'
              />
            ))}
          </div>
          <div className='w-full lg:w-[85%]'>
            <img
              className='w-full rounded-md'
              src='https://www.lashkaraa.in/cdn/shop/products/Laskara09-10-233370.jpg?v=1704559930&width=1946'
              alt='Saree'
            />
          </div>
        </section>
        <section className='w-full'>
          <h1 className='font-bold text-lg text-primary'>Raam Clothing</h1>
          <p className='text-gray-500 font-semibold'>Men Black Shirt</p>
          <div className='flex justify-between items-center py-2 border w-[180px] px-3 mt-5'>
            <div className='flex gap-1 items-center'>
              <span>4</span>
              <StarIcon sx={{ color: teal[500], fontSize: '17px' }} />
            </div>
            <Divider orientation='vertical' flexItem />
            <span>234 Ratings</span>
          </div>

            <div>
              
          <div className='price flex items-center gap-3 mt-5 text-2xl'>
            <span className='font-sans text-gray-800'>₹ 400</span>
            <span className='line-through text-gray-400'>₹ 999</span>
            <span className='text-primary font-semibold'> 60%</span>
          </div>

          <p className='text-sm'>Inclusive of all taxex. Free Shipping above ₹1500.</p>
            </div>

            <div className='mt-7 space-y-3'>
              <div className='flex items-center gap-4'>
                <Shield sx={{color:teal[500]}}></Shield>
                <p>Authentic & Quality Assured</p>
              </div>

              <div className='flex items-center gap-4'>
                <WorkspacePremium sx={{color:teal[500]}}></WorkspacePremium>
                <p>100% money back guaranate</p>
              </div>

              <div className='flex items-center gap-4'>
                <LocalShipping sx={{color:teal[500]}}></LocalShipping>
                <p>Free Shipping & Returns</p>
              </div>

              <div className='flex items-center gap-4'>
                <Wallet sx={{color:teal[500]}}></Wallet>
                <p>Pay on delivery might be avaliable</p>
              </div>

            </div>

            <div className=' mt-7 space-y-2'>
              <h1>QUANTITY</h1>
              <div className='flex items-center gap-2 w-[140px] justify-between '>
                <Button 
                disabled={quantity==1}
                onClick={()=>setQuantity(quantity-1)}>
                  <Remove></Remove>
                </Button>
                <span>
                {quantity}


                </span>
                <Button onClick={()=>setQuantity(quantity+1)}>
                  <Add></Add>
                </Button>
              </div>

            </div>

            <div className='mt-12 flex items-center gap-5'>
              <Button 
              fullWidth
              variant='contained'
              startIcon={<AddShoppingCart></AddShoppingCart>}
              sx={{py:"1rem"}}>Add To Bag</Button>


             <Button 
             fullWidth
              variant='outlined'
              startIcon={<FavoriteBorder></FavoriteBorder>}
              sx={{py:"1rem"}}>whishlist</Button>

            </div>

            <div className='mt-5'>
              <p>The saree comes with an unstitched blouse piece HTe blouse worn by the model might be for modelling purpose only.Check image of the blouse piece to understand how the actual blouse piece looks like.</p>
            </div>

        </section>
      </div>
    </div>
  )
}

export default ProductDetails