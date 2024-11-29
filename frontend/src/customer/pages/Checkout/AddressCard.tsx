import { Radio } from '@mui/material'
import React from 'react'

const AddressCard = () => {

    const handleChange =(event:any)=>{
        console.log(event.target.checked);
        
    }

  return (
    <div className='p-5 border rounded-md flex'>
        <div>
            <Radio
            checked={true}
            onChange={handleChange}
            value=""
            name='radio-button'
            />

        </div>
        <div className='space-y-3 pt-3'>
            <h1>Vaibhav</h1>
            <p className='w-[320px]'>Wellness medical,Shivane,Pune ,Maharashtra - 431023</p>
             <p><strong> Mobile : </strong> 9172364566</p>
        </div>
    </div>
  )
}

export default AddressCard