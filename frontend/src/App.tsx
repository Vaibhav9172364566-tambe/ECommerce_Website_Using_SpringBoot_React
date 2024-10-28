import React from 'react';
import logo from './logo.svg';
import './App.css';
import { Button, ThemeProvider } from '@mui/material';
import HomeIcon from '@mui/icons-material/Home';
import Navbar from './customer/components/Navbar';
import customeTheme from './Theme/customTheme';


function App() {
  return (
   <>
    <ThemeProvider theme={customeTheme}>

   <div>
   <Navbar></Navbar>

   </div>


    </ThemeProvider>
    
   </>
  );
}

export default App;
