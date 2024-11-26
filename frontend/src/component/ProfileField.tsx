import { Divider } from '@mui/material'
import React from 'react'

const ProfileField = ({keys,value}:{keys:string ,value:string}) => {
  return (
    <div className='p-5 flex items-center bg-slate-50'>
        <p className='w-20 lg:w-36 pr-5'>
             {keys}
        </p>
        <Divider orientation='vertical' flexItem></Divider>
        <p className='pl-4 lg:pl-10 font-semibold text-lg'>{value}</p>

    </div>
  )
}

export default ProfileField