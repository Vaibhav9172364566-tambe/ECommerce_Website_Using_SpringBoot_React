import { Route, Routes } from 'react-router-dom';
import Profile from '../seller/pages/Account/Profile';
import Orders from '../seller/pages/Order/Orders';
import Payments from '../seller/pages/Payment/Payments';
import AddProducts from '../seller/pages/Products/AddProducts';
import Products from '../seller/pages/Products/Products';
import DashBoard from '../seller/pages/SellerdashBoard/DashBoard';
import Transaction from '../seller/pages/Payment/Transaction';

const SellerRoutes = () => {
  return (
    <div>
      <Routes>
        <Route path="/" element={<DashBoard />} />
        <Route path="/products" element={<Products />} />
        <Route path="/add-product" element={<AddProducts />} />
        <Route path="/orders" element={<Orders />} />
        <Route path="/account" element={<Profile />} />
        <Route path="/payment" element={<Payments />} />
        <Route path='/transaction' element={<Transaction></Transaction>}></Route>
      </Routes>
    </div>
  );
};

export default SellerRoutes;

