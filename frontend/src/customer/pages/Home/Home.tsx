import CategoryGrid from './CategoryGrid/CategoryGrid'
import Deal from './Deal/Deal'
import ElectricCategory from './ElectricCategory/ElectricCategory'
import ShopByCategory from './ShopByCategory/ShopByCategory'

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
      <div className='pt-20'>
        <h1 className='text-lg lg:text:4xl font-bold text-primary pb-10 lg:pb-20 text-center'>SHOP BY CATEGORY</h1>
        <ShopByCategory></ShopByCategory>

      </div>

      
      
        
 
    </div>
    </>

    
  )
}

export default Home