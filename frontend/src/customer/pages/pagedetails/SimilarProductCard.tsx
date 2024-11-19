import React from 'react'

const SimilarProductCard = () => {
  return (
    <div>
        <div className='group px-4 relative'>
            <div className='card'>

                <img className='card-media object-top'
                src={'https://www.lashkaraa.in/cdn/shop/products/Lashkaraa21May1150.jpg?v=1664275887&width=360'}
                alt='Saree'>
                </img>
            </div>
            <div className='details pt-3 space-y-3 group-hovor-effect rounded-md'>
                <div className='name'>
                    <h1>niky</h1>
                    <p>Blue Shirt</p>

                </div>

                <div className='price flex items-center gap-3'>
                    <span className='font-sans items-center gap-3'>₹ 40</span>
                    <span className='thin-line-through text-gray-400' >₹ 999</span>
                    <span className='text-primary font-semibold'>60%</span>
                     
                </div>

            </div>

        </div>
    </div>
  )
}

export default SimilarProductCard