import React from 'react'
import { Routes,Route } from 'react-router-dom'

import DashBoard from '../seller/pages/SellerdashBoard/DashBoard'
import Products from '../seller/pages/Products/Products'
import Orders from '../seller/pages/Order/Orders'
import Profile from '../seller/pages/Account/Profile'
import Transactions from '../seller/pages/Payment/Transactions'
import AddProducts from '../seller/pages/Products/AddProducts'
import Payments from '../seller/pages/Payment/Payments'

const SellerRoutes = () => {
  return (
    <div>
        <Routes>
              <Route path='/' element={<DashBoard></DashBoard>}></Route>
              <Route path='/products' element={<Products ></Products>}></Route>
              <Route path='/add-product' element={<AddProducts></AddProducts>}></Route>
              <Route path='/orders' element={<Orders></Orders>}></Route>
             <Route path='/account' element={<Profile></Profile>}></Route>
             <Route path='/payment' element={<Payments></Payments>}></Route>
             <Route path='/transaction' element={<Transactions></Transactions>}></Route>
          </Routes>
    </div>
  )
}

export default SellerRoutes