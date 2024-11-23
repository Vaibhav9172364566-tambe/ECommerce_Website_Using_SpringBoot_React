import React from 'react'
import { Avatar, Grid2,Box, Grid, Rating, IconButton } from '@mui/material'
import { Delete } from '@mui/icons-material'
import { red } from '@mui/material/colors';

const ReviewCard = () => {
  return (
    <div className='flex justify-between '>
        <Grid2 container spacing={8}>
            <Grid2 size={{xs:1}}>
                <Box>
                    <Avatar className='text-white' sx={{width:56,height:56,
                        bgcolor:"#9155FD"
                    }}>
                        Z
                    </Avatar>
                </Box>

            </Grid2>

            <Grid2 size={{xs:9}}>
                <div className='space-y-2'>
                    <p className='font-semibold text-lg'>Zosh</p>
                    <p className='opacity-70'>2027-11-27T23:16:07.47833</p>

                </div>

                <Rating
            readOnly
            value={4}
            precision={5}

            />
            <p>value for money product,great product</p>
            <div>
                <img
                className='w-24 h-24 object-cover'
                src='https://www.lashkaraa.in/cdn/shop/products/Lashkaraa21May1568.jpg?v=1664275907&width=360'
                alt=''
                >
                </img>
            </div>
                
            

            </Grid2>
        </Grid2>
        <div>
  <IconButton>
    <Delete sx={{color:red[700]}}></Delete>
  </IconButton>
</div>

    </div>
  )
}

export default ReviewCard