import { AccountBalanceWallet, AccountBox, Add, Dashboard, Inventory, Logout, Receipt, ShoppingBag } from '@mui/icons-material'
import React from 'react'
import DrawerList from '../../../component/DrawerList';


const menu =[
    {
        name:"Dashboard",
        path:"/seller",
        icon:<Dashboard className='text-primary'></Dashboard>,
        activeIcon:<Dashboard className="text-white"></Dashboard>
    },


    {
        name:"Orders",
        path:"/seller/orders",
        icon:<ShoppingBag className='text-primary'></ShoppingBag>,
        activeIcon:<ShoppingBag className="text-white"></ShoppingBag>
    },

    {
        name:"Products",
        path:"/seller/products",
        icon:<Inventory className='text-primary'></Inventory>,
        activeIcon:<Inventory className="text-white"></Inventory>
    },
    {
        name:"Add Product",
        path:"/seller/add-product",
        icon:<Add className='text-primary'></Add>,
        activeIcon:<Add className="text-white"></Add>
    },{
        name:"Payment",
        path:"/seller/payment",
        icon:<AccountBalanceWallet className='text-primary'></AccountBalanceWallet>,
        activeIcon:<AccountBalanceWallet className="text-white"></AccountBalanceWallet>
    },

    {
        name:"Transaction",
        path:"/seller/transaction",
        icon:<Receipt className='text-primary'></Receipt>,
        activeIcon:<Receipt className="text-white"></Receipt>
    },
];

const menu2=[
    {
        name:"Account",
        path:"/seller/account",
        icon:<AccountBox className='text-primary'></AccountBox>,
        activeIcon:<AccountBox className="text-white"></AccountBox>
    },
    {
        name:"Logout",
        path:"/",
        icon:<Logout className='text-primary'></Logout>,
        activeIcon:<Logout className="text-white"></Logout>
    },
]


const SellerDrawerList = ({toggleDrawer} : {toggleDrawer :any}) => {
  return (
        <DrawerList menu={menu} menu2={menu2} toggleDrawer={toggleDrawer}></DrawerList>
  )
}

export default SellerDrawerList