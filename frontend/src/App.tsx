import React from 'react';
import './App.css';
import { ThemeProvider } from '@mui/material';
import Navbar from './customer/components/Navbar/Navbar';
import Home from './customer/pages/Home/Home'
import customeTheme from './Theme/customTheme';
import Product from './customer/pages/Product/Product';
import PageDetails from './customer/pages/pagedetails/ProductDetails';
import ProductDetails from './customer/pages/pagedetails/ProductDetails';
import Review from './customer/pages/Review/Review';
import Card from './customer/pages/Card/Card';
import Checkout from './customer/pages/Checkout/Checkout';
import { Route, Routes } from "react-router-dom";
import Account from './customer/pages/Account/Account';
import OrderDetails from './customer/pages/Account/OrderDetails';
import BecomeSeller from './Become Seller/BecomeSeller';



function App() {
  return (
    <>
      <ThemeProvider theme={customeTheme}>

        <div>
          {/* <Home></Home>
          <Product></Product>
          <ProductDetails></ProductDetails>
          <Review></Review>
          <Card></Card>
          <Checkout></Checkout>
          <Account></Account> */}
          <Navbar></Navbar>



          <Routes>

            <Route path='/' element={<Home></Home>} />
            <Route path='/products/:category' element={<Product></Product>}></Route>


            <Route path='/reviews/:productId' element={<Review></Review>}></Route>
            <Route path='/product-details/:categoryId/:name/:productId' element={<ProductDetails></ProductDetails>}></Route>
            <Route path='/card' element={<Card></Card>}></Route>
            <Route path="/checkout" element={<Checkout></Checkout>}></Route>
            <Route path='/become-seller' element={<BecomeSeller></BecomeSeller>}></Route>
            <Route path='/account/*' element={<Account></Account>}></Route>



          </Routes>

        </div>


      </ThemeProvider>

    </>
  );
}

export default App;
