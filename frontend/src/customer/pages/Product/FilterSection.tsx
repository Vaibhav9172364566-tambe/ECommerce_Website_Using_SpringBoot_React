import { Button, Divider, FormControl, FormControlLabel, FormLabel, Radio, RadioGroup } from '@mui/material';
import { teal } from '@mui/material/colors';
import React, { useState } from 'react';
import { colors } from '../../../Data/Filter/color';

const FilterSection = () => {
  const [expandColor, setExpandColor] = useState(false);
  const handleColorToggle = () => {
    setExpandColor(!expandColor);
  };

  return (
    <div className='-z-50 space-y-5 bg-white'>
      <div className='flex items-center justify-between h-[40px] px-9 lg:border-r'>
        <p className='text-lg font-semibold'>Filters</p>
        <Button size='small' className='text-teal-600 cursor-pointer font-semibold'>Clear All</Button>
      </div>
      <Divider>
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
                defaultValue=""
                name="color"
              >
                {colors.slice(0, expandColor ? colors.length : 5).map((item) => (
                  <FormControlLabel 
                    key={item.name} // Added unique key based on item.name
                    value={item.name} // Set value dynamically based on item.name
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
        </div>
      </Divider>
    </div>
  );
};

export default FilterSection;
