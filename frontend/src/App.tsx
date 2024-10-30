import React from 'react';
import './App.css';
import {  ThemeProvider } from '@mui/material';
import Navbar from './customer/components/Navbar/Navbar';
import Home from './customer/pages/Home/Home'
import customeTheme from './Theme/customTheme';


function App() {
  return (
   <>
    <ThemeProvider theme={customeTheme}>

   <div>
   <Navbar></Navbar>
   <Home></Home>

 
   </div>


    </ThemeProvider>
    
   </>
  );
}

export default App;
