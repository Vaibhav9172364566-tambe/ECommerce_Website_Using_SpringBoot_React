import CategoryGrid from './CategoryGrid/CategoryGrid'
import ElectricCategory from './ElectricCategory/ElectricCategory'

const Home = () => {
  return (
    <>
    <div className='space-y-5 lg:space-y-10 relative pb-20'>
      <ElectricCategory></ElectricCategory>
      <CategoryGrid></CategoryGrid>
      
        
 
    </div>
    </>

    
  )
}

export default Home