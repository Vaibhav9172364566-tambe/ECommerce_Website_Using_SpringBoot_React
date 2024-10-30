import React from 'react'
import { menLevelTwo } from '../../../Data/category/level two/menLevelTwo'
import { womenLevelTwo } from '../../../Data/category/level two/womenLevelTwo'

import { electronicLevelTwo } from '../../../Data/category/level two/electroniclevelTwo'
import { furnitureLevelTwo } from '../../../Data/category/level two/furnitureLevelTwo'


import {menLevelThree} from '../../../Data/category/level three//menLevelThree'

import { womenLevelThree } from '../../../Data/category/level three/womenLevelThree'


import { electronicLevelThree } from '../../../Data/category/level three/electronicLevelThree'

import { furnitureLevelThree } from '../../../Data/category/level three/furnitureLevelThree'



const categoryTwo={
    men: menLevelTwo,
    women:womenLevelTwo,
    electronics:electronicLevelTwo,
    home_furniture:furnitureLevelTwo


    

   
}
const categoryThree={
  men:menLevelThree,
  women:womenLevelThree,
  electronics:electronicLevelThree,
  home_furniture:furnitureLevelThree


}

const CategorySheet = () => {
  return (
    <div>CategorySheet</div>
  )
}

export default CategorySheet