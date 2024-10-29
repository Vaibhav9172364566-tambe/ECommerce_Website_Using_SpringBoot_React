import React from 'react';

const DealCart = () => {
    return (
        <div className='w-[13rem] cursor-pointer'>
            <img
                className='border-x-[7px] border-t-[7px] border-pink-600 w-full h-[12rem] object-cover object-top'
                src='https://rukminim2.flixcart.com/image/416/416/xif0q/smartwatch/u/r/h/-original-imagyxxfgz52vzqn.jpeg?q=70&crop=false'
                alt='Smart Watch'
            />
            <div className='border-4 border-black bg-[#080808] text-white p-4 text-center'>
                <p className='text-lg font-semibold'>Smart Watch</p>
                <p className='text-2xl font-bold'>20% OFF</p>
                <p className='text-lg'>Shop Now</p>
            </div>
        </div>
    );
};

export default DealCart;
