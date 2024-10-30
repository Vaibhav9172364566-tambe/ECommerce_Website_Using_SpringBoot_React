import { Button } from '@mui/material'
import CategoryGrid from './CategoryGrid/CategoryGrid'
import Deal from './Deal/Deal'
import ElectricCategory from './ElectricCategory/ElectricCategory'
import ShopByCategory from './ShopByCategory/ShopByCategory'
import { Storefront } from '@mui/icons-material'

const Home = () => {
  return (
    <>
    <div className='space-y-5 lg:space-y-10 relative pb-20'>
      <ElectricCategory></ElectricCategory>
      <CategoryGrid></CategoryGrid>

      <div className='pt-20'>
        <h1 className='text-lg lg:text:4xl font-bold text-primary pb-10  lg:pb-20 text-center'> TODAY`S DEAl </h1>
        <Deal></Deal>

      </div>
      <section className='py-20'>
        <h1 className='text-lg lg:text:4xl font-bold text-primary pb-10 lg:pb-20 text-center'>SHOP BY CATEGORY</h1>
        <ShopByCategory></ShopByCategory>

      </section>

      <section className='lg:px-20 relative h-[200px] lg:h-[450px] object-cover'>
        <img
        className='w-full h-full'
        src='https://zosh-bazzar-zosh.vercel.app/seller_banner_image.jpg' alt=''></img>
        <div className='absolute top-1/2 left-4 lg:left-[12rem] transform-translate-y-1/2 font-semibold lg:text-4xl space-y-3'>

         
        <h1>Sell your Product</h1>

        <p className='text-lg md:text-2xl'>With <span className='logo'>Vaibhav Bazzar</span></p>
        <div className='pt-6 flex justify-center'>
         <Button startIcon={<Storefront></Storefront>} variant='contained' size='large'>Become Seller</Button>

        </div>


        
        
        </div>
      </section>

      
      
        
 
    </div>
    </>

    
  )
}

export default Home