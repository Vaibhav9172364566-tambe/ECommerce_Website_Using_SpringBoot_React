import React from 'react';
import './App.css';
import {  ThemeProvider } from '@mui/material';
import Navbar from './customer/components/Navbar/Navbar';
import Home from './customer/pages/Home/Home'
import customeTheme from './Theme/customTheme';
import Product from './customer/pages/Product/Product';
import PageDetails from './customer/pages/pagedetails/ProductDetails';
import ProductDetails from './customer/pages/pagedetails/ProductDetails';


function App() {
  return (
   <>
    <ThemeProvider theme={customeTheme}>

   <div>
   <Navbar></Navbar>
   {/* <Home></Home> */}
   {/* <Product></Product> */}
   <ProductDetails></ProductDetails>

 
   </div>


    </ThemeProvider>
    
   </>
  );
}

export default App;
