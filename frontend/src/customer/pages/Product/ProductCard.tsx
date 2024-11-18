import React, { useEffect, useState } from 'react';
import "./ProductCart.css"
import { Favorite, ModeComment, Translate } from '@mui/icons-material';
import { Button } from '@mui/material';
import { teal } from '@mui/material/colors';


const images = [
  "https://imgs.search.brave.com/0hEqQ5T3QDRuPUUZp5bG8LR2Z9fe0fkrKGJclmFpt8Q/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pLnBp/bmltZy5jb20vb3Jp/Z2luYWxzL2Q0LzUz/LzhiL2Q0NTM4YjJh/Y2JkOWM2YzdhYjc5/ZmYxYzM1Y2YxMThm/LmpwZw",
  "https://imgs.search.brave.com/MG2qAVxplK7sCZVHtzqpw-DfmBQaM_PYgF65jWsw6j4/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pbWFn/ZXMuY2JhemFhci5j/b20vaW1hZ2VzL2V0/aG5pYy1jaGFybS1s/aWxhYy12aXNjb3Nl/LXNpbGstc2FyZWUt/d2l0aC1yYWp3YWRp/LXBhdHRlcm4tcHJp/bnRzLXNhc2NjMzg4/NXI5MjgtdS5qcGc"
,
  "https://imgs.search.brave.com/0hEqQ5T3QDRuPUUZp5bG8LR2Z9fe0fkrKGJclmFpt8Q/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pLnBp/bmltZy5jb20vb3Jp/Z2luYWxzL2Q0LzUz/LzhiL2Q0NTM4YjJh/Y2JkOWM2YzdhYjc5/ZmYxYzM1Y2YxMThm/LmpwZw" ,
  "https://imgs.search.brave.com/MG2qAVxplK7sCZVHtzqpw-DfmBQaM_PYgF65jWsw6j4/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9pbWFn/ZXMuY2JhemFhci5j/b20vaW1hZ2VzL2V0/aG5pYy1jaGFybS1s/aWxhYy12aXNjb3Nl/LXNpbGstc2FyZWUt/d2l0aC1yYWp3YWRp/LXBhdHRlcm4tcHJp/bnRzLXNhc2NjMzg4/NXI5MjgtdS5qcGc",

];

const ProductCard = () => {
  const [currentImage,setCurrentImage]=useState(0)
  const [isHovered,setIsHovered]=useState(false)

   useEffect(()=>{
    let interval:any
    if(isHovered){
      interval=setInterval(()=>{
        setCurrentImage((prevImage)=>(prevImage+1) % images.length)
      },1000)
    }
    else if(interval){
      clearInterval(interval);
      interval=null;

    }
    return () => clearInterval(interval);

   },[isHovered])

  return (
    <>
    <div className='group px-4 relative'> 
      <div className='card'
      onMouseEnter={()=>setIsHovered(true)}
        onMouseLeave={()=>setIsHovered(false)}
      >

        {images.map((item,index) => 
          <img
            className='card-media object-top'
            src={item}  // Provide the src attribute to display the image
            alt='Product'
            style={{ transform: `translateX(${(index - currentImage)*100}%)` }}
            />
        )}
        {isHovered &&
        <div className='indicator flex flex-col items-center space-y-2 '>  
          <div className='flex gap-3 '>
            <Button variant='contained' color='secondary'>
              <Favorite sx={{color:teal[500]}}> </Favorite>
               </Button>
            
               <Button variant='contained' color='secondary'>
              <ModeComment sx={{color:teal[500]}}> </ModeComment>
               </Button>
            
          </div>
        </div>
        } 

      </div>
      <div className='details pt-3 space-y-1 group-hovor-effect rounded-sm'>
        <div className='name'>
          <h1>Niky </h1>
          <p>Blue Shirt</p>


        </div>
        <div className='price flex items-center gap-3'>
          <span className='font-sans text-gray-800'> ₹ 400</span>
           <span className='thin-line-through text-gray-400'> ₹ 999</span>
           <span className='text-primary font-semibold'> 60 %</span>
        </div>
      </div>
    </div>
    </>
  );
}

export default ProductCard;
