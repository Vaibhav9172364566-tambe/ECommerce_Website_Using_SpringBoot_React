import React, { useState } from 'react'
import FilterSection from './FilterSection'
import ProductCart from './ProductCard'
import { Box, Divider, FormControl, IconButton, InputLabel, MenuItem, Select, useMediaQuery, useTheme } from '@mui/material'
import { FilterAlt } from '@mui/icons-material'

const Product = () => {

  const theme=useTheme()
  const isLarge=useMediaQuery(theme.breakpoints.up("lg"))
  const [sort,setSort]=useState()
  const handelSortChange=(event:any)=>{
    setSort(event.target.value)
  }


  
  return (
    <div className='-z-10 mt-10'>
      <div className=''>
        <h1 className='text-3xl text-center text-gray-700 font-bold pb-5 px-9 uppercase space-x-2'>women sarees</h1>

      </div>

      <div className='lg:flex'>
      <section className='filter_section hidden lg:block w-[20%]'>
        <FilterSection></FilterSection>
      </section>

      <div className='w-full lg:w-[80%] space-y-5'>
        <div className='flex justify-between items-center px-9 h-[40px]'>
          <div className='relative w-[50%]'> 
            {

            !isLarge && (<IconButton>
              <FilterAlt></FilterAlt>
              </IconButton>)
}
              {
                !isLarge && (<Box>
                  <FilterSection></FilterSection>
                  </Box>)
              }
          
          </div>

          <FormControl  size='small' sx={{width:"200px"}}>
            <InputLabel id="demo-simple-select-label">Sort</InputLabel>
            <Select
              labelId="demo-simple-select-label"
              id="demo-simple-select"
              value={sort}
              label="Age"
              onChange={handelSortChange}
              >
                <MenuItem value={"price_low"}>Price : Low  -High</MenuItem>
                <MenuItem value={"price_high"}>Price : High -Low</MenuItem>
            </Select>

          </FormControl>

        </div>

        <Divider></Divider>
      <section className='product_section  grid sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-y-5 px-5 justify-center'>
        {[1,1,1,1,1,1,1,1,1,1,1].map((item)=><ProductCart></ProductCart>)}
      </section>
      </div>


      </div>
    </div>
  )
}

export default Product