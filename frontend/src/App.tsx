import React from 'react';
import './App.css';
import {  ThemeProvider } from '@mui/material';
import Navbar from './customer/components/Navbar/Navbar';
import Home from './customer/pages/Home/Home'
import customeTheme from './Theme/customTheme';
import Product from './customer/pages/Product/Product';
import PageDetails from './customer/pages/pagedetails/ProductDetails';
import ProductDetails from './customer/pages/pagedetails/ProductDetails';
import Review from './customer/pages/Review/Review';
import Card from './customer/pages/Card/Card';
import Checkout from './customer/pages/Checkout/Checkout';
import { BrowserRouter } from "react-router-dom";
import Account from './customer/pages/Account/Account';



function App() {
  return (
   <>
    <ThemeProvider theme={customeTheme}>

   <div>
   <Navbar></Navbar>
   {/* <Home></Home> */}
   {/* <Product></Product> */}
   {/* <ProductDetails></ProductDetails> */}

   {/* <Review></Review> */}
   {/* <Card></Card> */}
   {/* <Checkout></Checkout> */}
   <Account></Account>

 
   </div>


    </ThemeProvider>
    
   </>
  );
}

export default App;
