import React, { useState } from 'react'
import HomeCategoryTable from './HomeCategoryTable'
import { Button } from '@mui/material'
import DealTable from './DealTable'
import DealCategoryTable from './DealCategoryTable'
import CreateDealForm from './CreateDealForm'

const tabs = [
  "Deals",
  "Category",
  "Create Deal"

]

const Deal = () => {

  const [activeTab, setActiveTab] = useState("deals")
  return (
    <div>
      <div className='flex gap-4'>

        {tabs.map((item) => <Button
          onClick={() => setActiveTab(item)}
          variant={activeTab == item ? "contained" : "outlined"


          }>{item}</Button>)}
      </div>

      <div className='mt-5'>
        {activeTab == "Deals" ? <DealTable></DealTable> : activeTab == "Category" ? <DealCategoryTable></DealCategoryTable> : 
        
        <div className='mt-5 flex flex-col justify-center items-center h-[70vh] '>
          <CreateDealForm></CreateDealForm>

        </div>}

      </div>
    </div>
  )
}

export default Deal