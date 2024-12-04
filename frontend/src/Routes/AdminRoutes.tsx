import React from 'react'
import { Routes,Route } from 'react-router-dom'
import SellerTable from '../admin/Pages/DashBoard/seller/SellerTable'
import AddNewCoupoun from '../admin/Pages/DashBoard/Coupoun/AddNewCoupon'
import GridTable from '../admin/Pages/HomePage/GridTable'
import Electronics from '../admin/Pages/HomePage/Electronics'
import ShopByCategoryTable from '../admin/Pages/HomePage/ShopByCategoryTable'
import Deal from '../admin/Pages/HomePage/Deal'
import Coupon from '../admin/Pages/DashBoard/Coupoun/Coupon'

const AdminRoutes = () => {
  return (
    <div>
        <Routes>
            <Route path='/' element={<SellerTable></SellerTable>}></Route>
            <Route path='/coupon' element={<Coupon></Coupon>}></Route>
            <Route path='/add-coupon' element={<AddNewCoupoun></AddNewCoupoun>}></Route>
            <Route path='/home-grid' element={<GridTable></GridTable>}></Route>
            <Route path='/electronics-category' element={<Electronics></Electronics>}></Route>
            <Route path='/shop-by-category' element={<ShopByCategoryTable />} />
            <Route path='/deals' element={<Deal></Deal>}></Route>            

        </Routes>
    </div>
  )
}

export default AdminRoutes