import ElectricCategoryCart from './ElectricCategoryCart'

const ElectricCategory = () => {
  return (
    <>
    <div className='flex flex-wrap justify-between py-5 lg:px-20 border-b  '>
        {[1,1,1,1,1,1,1].map(()=><ElectricCategoryCart></ElectricCategoryCart>)}
        
    </div>
    </>
  )
}

export default ElectricCategory