import { Button, Card, Divider } from '@mui/material'
import React from 'react'
import Transaction from './Transaction'

const Payments = () => {
  return (
    <div className='space-x-5'>
      <Card className='rounded-md space-y-4 p-5'>
        <h1 className='text-gray-600 font-medium'>Total Earing</ h1>
        <h1 className='font-bold text-xl pb-1'>₹11644</h1>
        <Divider></Divider>
        <p>Last Payment : <strong>₹0</strong></p>

      </Card>
      <div className='pt-20 space-y-3 '>
      <Button variant='contained'>
        Transaction
      </Button>
      <Transaction></Transaction>
      </div>

      
    </div>
  )
}

export default Payments