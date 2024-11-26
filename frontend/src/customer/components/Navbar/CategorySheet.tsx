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
import { useNavigate } from 'react-router-dom';

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
  const navigate = useNavigate();
  const [filteredCategory, setFilteredCategory] = useState<any[]>([]);

  useEffect(() => {
    if (selectedCategory && categoryTwo[selectedCategory]) {
      setFilteredCategory(categoryTwo[selectedCategory]);
    }
  }, [selectedCategory]);

  const childCategory = (category: any[], parentCategoryId: any) => {
    return category.filter((child: any) => child.parentCategoryId === parentCategoryId);
  };

  return (
    <Box sx={{ zIndex: 2 }} className="bg-white shadow-lg lg:h-[500px] overflow-y-auto">
      <div className="flex text-sm flex-wrap">
        {filteredCategory?.map((item: any, index: number) => (
          <div
            className={`p-8 lg-w-[20%] ${index % 2 === 0 ? "bg-slate-50" : "bg-white"}`}
            key={item.categoryId}
          >
            <p className="text-primary mb-5 font-semibold">{item.name}</p>
            <ul className="space-y-3">
              {childCategory(categoryThree[selectedCategory] || [], item.categoryId).map((child: any) => (
                <li
                  key={child.categoryId}
                  onClick={() => navigate("/products/" + child.categoryId)}  // Correct the URL based on the child's categoryId
                  className="hover:text-primary cursor-pointer"
                >
                  {child.name}
                </li>
              ))}
            </ul>
          </div>
        ))}
      </div>
    </Box>
  );
};

export default CategorySheet;
