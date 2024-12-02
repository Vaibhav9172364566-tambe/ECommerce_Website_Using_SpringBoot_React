import { Edit } from '@mui/icons-material'
import { Avatar, Box, Button, Divider, Modal, Typography } from '@mui/material'
import React, { useState } from 'react'
import ProfileField from '../../../component/ProfileField'
import { render } from '@testing-library/react';
import PersonalDetails from './PersonalDetails';
import PickupAddress from './PickupAddress';
import BankDetails from './BankDetails';
import BusinessDetails from './BusinessDetails';


const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  boxShadow: 24,
  p: 4,
};

const Profile = () => {

  const [open, setOpen] = React.useState(false);
  const handleOpen = (fornName:string) =>{ setOpen(true);
  setSelectedForm(fornName)
  }
  const handleClose = () => setOpen(false);

  const [selectedForm,setSelectedForm]=useState("persionalDetails")

  const renderSelectedForm=()=>{
    switch(selectedForm){
      case "persionalDetails":
        return <PersonalDetails></PersonalDetails>
      case "pickupAddress":
        return <PickupAddress></PickupAddress>  
      case "bankDetails":
        return <BankDetails></BankDetails>
      default:
        return <BusinessDetails></BusinessDetails>  
         
      }


  }
   

  return (
    <div className='lg:px-20 pt-3 pb-20 space-y-20'>
      <div className='w-full lg:w-[70%]'>
        <div className='flex items-center pb-3 justify-between'>
          <h1 className='text-2xl font-bold text-gray-600'>persional Details </h1>
          <div>
            <Button
            variant='contained'
            onClick={()=>handleOpen("persionalDetails")}
            size='small'
            sx={{borderRadius:"2.9rem"}}
            className='w-16 h-16'
            >
               <Edit></Edit>
            </Button>
          </div>

        </div>

        <div>
          <Avatar
          sx={{width:"10rem" ,height:"10rem"}}
          src='https://media.istockphoto.com/id/681388560/photo/bald-eagle-flying-over-icy-waters.jpg?s=612x612&w=0&k=20&c=aT1Kx-got-MelSxfYOFlXoj13OvDL1UaD3IvJifZGhc='
          >

          </Avatar>
          <div>
            <ProfileField keys='Seller Name'value={'Raam Virani'}></ProfileField>
            <Divider></Divider>
            <ProfileField keys='Seller Email'value={'vaibhavtambe9172@gmail.com'}></ProfileField>
            <Divider></Divider>
            <ProfileField keys='Seller Mobile'value={'9172364566'}></ProfileField>
            

          </div>
        </div>

      </div>



      <div className='w-full lg:w-[70%]'>
        <div className='flex items-center pb-3 justify-between'>
          <h1 className='text-2xl font-bold text-gray-600'>Business Details</h1>
          <div>
            <Button
                        onClick={()=>handleOpen("businessDetails")}

            variant='contained'
            size='small'
            sx={{borderRadius:"2.9rem"}}
            className='w-16 h-16'
            >
               <Edit></Edit>
            </Button>
          </div>

        </div>

        <div>
         
          <div>
            <ProfileField keys='Business Name/Brand Name'value={' Virani Cloths'}></ProfileField>
            <Divider></Divider>
            <ProfileField keys='GSTIN'value={'GSTIN52545586'}></ProfileField>
            <Divider></Divider>
            <ProfileField keys='Account Status'value={'PENDING'}></ProfileField>
            

          </div>
        </div>

      </div>


         <div className='mt-10 lg:w-[70%]'>

          <div className='flex items-center pb-3 justify-between'>
            <h1 className='text-2xl font-bold text-gray-600'>Pickup Address</h1>
            <div>
              <Button
            onClick={()=>handleOpen("pickupAddress")}
            size='small'
              sx={{borderRadius:"2.9rem"}}
              variant='contained'
              className='w- 16 h-16'

              >
                <Edit></Edit>

              </Button>
            </div>

          </div>

          <div className='space-y-5'>
            <div className=''>
              <ProfileField keys={'Address'} value={'Pune Shivne 431023'}></ProfileField>
              <Divider></Divider>

              <ProfileField keys={'City'} value={'Pune'}></ProfileField>
              <Divider></Divider>


              <ProfileField keys={'State'} value={'Maharashtra'}></ProfileField>
              <Divider></Divider>

              <ProfileField keys={'Mobile'} value={'9172364566'}></ProfileField>

            </div>

          </div>

         </div>

      <div className='w-full lg:w-[70%]'>
        <div className='flex items-center pb-3 justify-between'>
          <h1 className='text-2xl font-bold text-gray-600'>Bank Details</h1>
          <div>
            <Button
                        onClick={()=>handleOpen("bankDetails")}

            variant='contained'
            size='small'
            sx={{borderRadius:"2.9rem"}}
            className='w-16 h-16'
            >
               <Edit></Edit>
            </Button>
          </div>

        </div>

        <div>
          
          <div>
            <ProfileField keys='Account Holder 'value={'Raam Virani'}></ProfileField>
            <Divider></Divider>
            <ProfileField keys='Account Number'value={'52498656'}></ProfileField>
            <Divider></Divider>
            <ProfileField keys='IFSC CODE'value={'TES151'}></ProfileField>
            

          </div>
        </div>

      </div>




      <Modal
  open={open}
  onClose={handleClose}
  aria-labelledby="modal-modal-title"
  aria-describedby="modal-modal-description"
>
  <Box sx={style}>

    {renderSelectedForm()}
    

  </Box>
</Modal>
      
      
    </div>
  )
}

export default Profile