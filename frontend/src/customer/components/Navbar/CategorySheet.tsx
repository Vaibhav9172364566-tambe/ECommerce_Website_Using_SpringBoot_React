import React, { useState, useEffect } from 'react';
import { menLevelTwo } from '../../../Data/category/level two/menLevelTwo';
import { womenLevelTwo } from '../../../Data/category/level two/womenLevelTwo';
import { electronicLevelTwo } from '../../../Data/category/level two/electroniclevelTwo';
import { furnitureLevelTwo } from '../../../Data/category/level two/furnitureLevelTwo';

import { menLevelThree } from '../../../Data/category/level three/menLevelThree';
import { womenLevelThree } from '../../../Data/category/level three/womenLevelThree';
import { electronicLevelThree } from '../../../Data/category/level three/electronicLevelThree';
import { furnitureLevelThree } from '../../../Data/category/level three/furnitureLevelThree';
import { Box } from '@mui/material';

const categoryTwo: { [key: string]: any[] } = {
  men: menLevelTwo,
  women: womenLevelTwo,
  electronics: electronicLevelTwo,
  home_furniture: furnitureLevelTwo,
};

const categoryThree: { [key: string]: any[] } = {
  men: menLevelThree,
  women: womenLevelThree,
  electronics: electronicLevelThree,
  home_furniture: furnitureLevelThree,
};

const CategorySheet = ({ selectedCategory, setShowSheet }: any) => {
  // Local state for tracking filtered categories if necessary
  const [filteredCategory, setFilteredCategory] = useState<any[]>([]);

  useEffect(() => {
    // Whenever the selected category changes, filter the category
    if (selectedCategory && categoryTwo[selectedCategory]) {
      setFilteredCategory(categoryTwo[selectedCategory]);
    }
  }, [selectedCategory]); // This will trigger every time `selectedCategory` changes

  // Ensure child categories are correctly filtered
  const childCategory = (category: any, parentCategoryId: any) => {
    // Debugging output
    console.log("category:", category); // Log the category
    console.log("Is Array:", Array.isArray(category)); // Log if category is an array
    
    if (Array.isArray(category)) {
      return category.filter((child: any) => child.parentCategoryId === parentCategoryId);
    }
    
    console.warn("Expected an array but got:", category); // Log warning if it's not an array
    return []; // Return an empty array if category is not an array
  };

  return (
    <Box
      sx={{ zIndex: 2 }}
      className="bg-white shadow-lg lg:h-[500px] overflow-y-auto"
    >
      <div className="flex text-sm flex-wrap">
        {/* Iterate over the filtered category based on the selected category */}
        {filteredCategory?.map((item: any, index: number) => (
          <div
            className={`p-8 lg-w-[20%] ${index % 2 === 0 ? "bg-slate-50" : "bg-white"}`}
            key={item.categoryId}
          >
            <p className="text-primary mb-5 font-semibold">{item.name}</p>
            <ul className="space-y-3">
              {/* Find the child categories based on the item and selectedCategory */}
              {childCategory(categoryThree[selectedCategory], item.categoryId).map(
                (child: any) => (
                  <div key={child.categoryId}>
                    <li className="hover:text-primary cursor-pointer">{child.name}</li>
                  </div>
                )
              )}
            </ul>
          </div>
        ))}
      </div>
    </Box>
  );
};

export default CategorySheet;
