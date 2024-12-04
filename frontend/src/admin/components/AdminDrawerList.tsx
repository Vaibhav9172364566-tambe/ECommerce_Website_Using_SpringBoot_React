import React from 'react'
import DrawerList from '../../component/DrawerList'
import { AccountBox, Add, Category, Dashboard, ElectricBolt, Home, IntegrationInstructions, LocalOffer, Logout } from '@mui/icons-material'


const menu=[

    {
        name:"Dashboard",
        path:"/admin",
        icon:<Dashboard className='text-primary'></Dashboard>,
        activeIcon:<Dashboard className='text-white'></Dashboard>


    },

    {
        name:"Coupons",
        path:"/admin/coupon",
        icon:<IntegrationInstructions className='text-primary'></IntegrationInstructions>,
        activeIcon:<IntegrationInstructions className='text-white'></IntegrationInstructions>


    },

    {
        name:"Add New Coupon",
        path:"/admin/add-coupon",
        icon:<Add className='text-primary'></Add>,
        activeIcon:<Add className='text-white'></Add>


    },

    {
        name:"Home Page",
        path:"/admin/home-grid",
        icon:<Home className='text-primary'></Home>,
        activeIcon:<Home className='text-white'></Home>


    },

    {
        name:"Electronics Category",
        path:"/admin/electronics-category",
        icon:<ElectricBolt className='text-primary'></ElectricBolt>,
        activeIcon:<ElectricBolt className='text-white'></ElectricBolt>


    },

    {
        name:"Shop By Category",
        path:"/admin/shop-by-category",
        icon:<Category className='text-primary'></Category>,
        activeIcon:<Category className='text-white'></Category>


    },

    {
        name:"Deals",
        path:"/admin/deals",
        icon:<LocalOffer className='text-primary'></LocalOffer>,
        activeIcon:<LocalOffer className='text-white'></LocalOffer>


    },

]

const menu2=[
    {
        name:"Account",
        path:"/seller/account",
        icon:<AccountBox className='text-primary'></AccountBox>,
        activeIcon:<AccountBox className='text-white'></AccountBox>


    },

    {
        name:"Logout",
        path:"/",
        icon:<Logout className='text-primary'></Logout>,
        activeIcon:<Logout className='text-white'></Logout>


    },
]


const AdminDrawerList = ({toggleDrawer}:any) => {
  return (
    <DrawerList menu={menu} menu2={menu2} toggleDrawer={toggleDrawer}></DrawerList>
  )
}

export default AdminDrawerList