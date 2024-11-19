import { Button, Divider, FormControl, FormControlLabel, FormLabel, Radio, RadioGroup } from '@mui/material';
import { teal } from '@mui/material/colors';
import React, { useState, useEffect } from 'react';
import { colors } from '../../../Data/Filter/color';
import { useSearchParams } from 'react-router-dom';
import { price } from '../../../Data/Filter/price';
import { discount } from './../../../Data/Filter/discount';

const FilterSection = () => {
  const [expandColor, setExpandColor] = useState(false);
  const [searchParams, setSearchParam] = useSearchParams();
  
  // State to manage the selected filters
  const [selectedColor, setSelectedColor] = useState('');
  const [selectedPrice, setSelectedPrice] = useState('');
  const [selectedDiscount, setSelectedDiscount] = useState('');

  const handleColorToggle = () => {
    setExpandColor(!expandColor);
  };

  const updateFilterParams = (e: any) => {
    const { value, name } = e.target;
    if (value) {
      searchParams.set(name, value);
    } else {
      searchParams.delete(name);
    }
    setSearchParam(searchParams);
  };

  const clearAllFilters = () => {
    // Clear all the search params in the URL
    searchParams.forEach((_, key) => {
      searchParams.delete(key);
    });

    // Update the URL with the cleared search params
    setSearchParam(searchParams);

    // Reset the filter states in the UI (reset the radio button selections)
    setSelectedColor('');
    setSelectedPrice('');
    setSelectedDiscount('');
  };

  // UseEffect hook to reflect searchParams in the UI, when URL is updated externally
  useEffect(() => {
    const colorParam = searchParams.get('color');
    const priceParam = searchParams.get('price');
    const discountParam = searchParams.get('discount');
    
    setSelectedColor(colorParam || '');
    setSelectedPrice(priceParam || '');
    setSelectedDiscount(discountParam || '');
  }, [searchParams]);

  return (
    <div className='-z-50 space-y-5 bg-white'>
      <div className='flex items-center justify-between h-[40px] px-9 lg:border-r'>
        <p className='text-lg font-semibold'>Filters</p>
        <Button 
          onClick={clearAllFilters}
          size='small' 
          className='text-teal-600 cursor-pointer font-semibold'>
          Clear All
        </Button>
      </div>
      <Divider/>
      <div className='px-9 space-y-6'>
        <section>
          <FormControl>
            <FormLabel
              sx={{
                fontSize: '16px',
                fontWeight: 'bold',
                color: teal[500],
                pb: '14px',
              }}
              className='text-2xl font-semibold'
              id='color'
            >
              Color
            </FormLabel>
            <RadioGroup
              aria-labelledby="color"
              value={selectedColor} // Bind to selectedColor state
              name="color"
              onChange={(e) => {
                updateFilterParams(e);
                setSelectedColor(e.target.value); // Update UI state
              }}
            >
              {colors.slice(0, expandColor ? colors.length : 5).map((item) => (
                <FormControlLabel 
                  key={item.name}
                  value={item.name}
                  control={<Radio />} 
                  label={
                    <div className='flex items-center gap-3'>
                      <p>{item.name}</p>
                      <p 
                        style={{ backgroundColor: item.hex }} 
                        className={`h-5 w-5 rounded-full ${item.name === "White" ? "border" : ""}`} 
                      ></p>
                    </div>
                  } 
                />
              ))}
            </RadioGroup>
          </FormControl>
          <div>
            <button 
              onClick={handleColorToggle}
              className='text-primary cursor-pointer hover:text-teal-900 flex items-center'
            >
              {expandColor ? 'Hide' : `+${colors.length - 5} more`}
            </button>
          </div>
        </section>
       
        <section>
          <FormControl>
            <FormLabel sx={{
              fontSize:"16px",
              fontWeight:"bold",
              pb:"14px",
              color:teal[600]
            }} className='text-2xl font-semibold' id="price">
               Price
            </FormLabel>
            <RadioGroup
              name='price'
              value={selectedPrice} // Bind to selectedPrice state
              onChange={(e) => {
                updateFilterParams(e);
                setSelectedPrice(e.target.value); // Update UI state
              }}
              aria-labelledby='price'
            >
              {price.map((item) => (
                <FormControlLabel 
                  key={item.name}
                  value={item.value}
                  control={<Radio size="small" />}
                  label={item.name}
                />
              ))}
            </RadioGroup>
          </FormControl>
        </section>
        <Divider />

        <section>
          <FormControl>
            <FormLabel
              sx={{
                fontSize: "16px",
                fontWeight: "bold",
                pb: "14px",
                color: teal[600],
              }}
              className="text-2xl font-semibold"
              id="brand"
            >
              Discount
            </FormLabel>
            <RadioGroup
              name="discount"
              value={selectedDiscount} // Bind to selectedDiscount state
              onChange={(e) => {
                updateFilterParams(e);
                setSelectedDiscount(e.target.value); // Update UI state
              }}
              aria-labelledby="brand"
            >
              {discount.map((item) => (
                <FormControlLabel
                  key={item.name}
                  value={item.value}
                  control={<Radio size="small" />}
                  label={item.name}
                />
              ))}
            </RadioGroup>
          </FormControl>
        </section>
      </div>
    </div>
  );
};

export default FilterSection;
