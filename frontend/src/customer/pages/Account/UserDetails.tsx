import React from 'react'
import ProfileField from '../../../component/ProfileField'
import { Divider } from '@mui/material'

const UserDetails = () => {
  return (
    <div className='flex justify-center py-10'>
        <div className='w-full lg:w-[70%]'>
            <div className='flex items-center pb-3 justify-between'>
                <h1 className='text-2xl font-bold text-gray-600'>Personal Details</h1>

            </div>
            <div className=''>
                <ProfileField keys='Name' value={'Zosh'}></ProfileField>
                <Divider></Divider>
                <ProfileField keys='Email' value={'vaibhavtambe9172@gmaul.com'}></ProfileField>
                <Divider></Divider>
                <ProfileField keys='Mobile' value={'9172364566'}></ProfileField>


            </div>

        </div>
        
    </div>
  )
}

export default UserDetails