import React, { useState } from 'react'
import { menLevelTwo } from '../../../Data/category/level two/menLevelTwo'
import { womenLevelTwo } from '../../../Data/category/level two/womenLevelTwo'
import { furnitureLevelTwo } from '../../../Data/category/level two/furnitureLevelTwo'
import { electronicLevelTwo } from '../../../Data/category/level two/electroniclevelTwo'
import { menLevelThree } from '../../../Data/category/level three/menLevelThree'
import { womenLevelThree } from '../../../Data/category/level three/womenLevelThree'
import { furnitureLevelThree } from '../../../Data/category/level three/furnitureLevelThree'
import { electronicLevelThree } from '../../../Data/category/level three/electronicLevelThree'
import { useFormik } from 'formik'
import { log } from 'console'
import { uploadToCloudnary } from '../../../Util/UploadToCloudnary'
import { Alert, Button, CircularProgress, FormControl, FormHelperText, Grid, Grid2, Icon, IconButton, InputLabel, MenuItem, Select, Snackbar, TextField } from '@mui/material'
import { AddPhotoAlternate, ClosedCaption } from '@mui/icons-material'
import { colors } from '../../../Data/Filter/color'
import { mainCategory } from '../../../Data/category/mainCategory'

const categoryTwo: { [key: string]: any[] } = {
  men: menLevelTwo,
  women: womenLevelTwo,
  kids: [],
  home_furniture: furnitureLevelTwo,
  beauty: [],
  electronics: electronicLevelTwo
}

const categoryThree: { [key: string]: any[] } = {
  men: menLevelThree,
  women: womenLevelThree,
  kids: [],
  home_furniture: furnitureLevelThree,
  beauty: [],
  electronics: electronicLevelThree
}



const AddProductsForm = () => {
  const [uploadImage, setUploadImage] = useState(false)
  const [snakbarOpen, setOpenSnackbar] = useState(false)

  const formik = useFormik({
    initialValues: {
      title: "",
      description: "",
      mrpPrice: "",
      sellingPrice: "",
      quantity: "",
      color: "",
      images: [],
      category: "",
      category2: "",
      category3: "",
      sizes: "",

    },
    onSubmit: (values) => {
      // dispatchEvent(createProduct({request:values,jwt:localStorage.getItem("jwt")}))
      console.log(values);

    }

  });

  const handleImageChange = async (event: any) => {
    const file = event.target.files[0];
    setUploadImage(true)
    const image = await uploadToCloudnary(file)
    formik.setFieldValue("images", [...formik.values.images, image]);
    setUploadImage(false)

  }

  const handleRemoveImage = (index: number) => {
    const updatedImages = [...formik.values.images]
    updatedImages.splice(index, 1);
    formik.setFieldValue("images", updatedImages)
  };

  const childCategory = (category: any, parantCategoryId: any) => {
    return category.filter((child: any) => {
      return child.parentCategoryId == parantCategoryId;
    })

  }

  const handleCloserSnackbar = () => {
    setOpenSnackbar(false);
  }
  return (
    <div>
      <form onSubmit={formik.handleSubmit} className='space-y-4 p-4'>
        <Grid2 container spacing={2}>
          <Grid2 className='flex flex-wrap gap-5 ' size={{ xs: 12 }}>
            <input
              type='file'
              accept='image/*'
              id='fileInput'
              style={{ display: "none" }}
              onChange={handleImageChange}
            />

            <label className='relative' htmlFor='fileInput'>
              <span className='w-24 h-24 cursor-pointer flex items-center justify-center p-3 border rounded-md border-gray-700'>
                <AddPhotoAlternate className='text-gray-700'></AddPhotoAlternate>

              </span>

              {uploadImage && (
                <div className='absolute left-0 right-0 top-0 bottom-0 w-24 h-24 flex justify-center items-center'>
                  <CircularProgress></CircularProgress>

                </div>


              )}
            </label>


            <div className='flex flex-wrap gap-2'>
              {formik.values.images.map((image, index) => (
                <div className='relative'>
                  <img
                    className='w-24 h-24 object-cover'
                    key={index}
                    src={'image'}
                    alt={`ProductImage ${index + 1} `}



                  />

<IconButton
      onClick={() => handleRemoveImage(index)} 
      className="" 
      size="small" 
      color="error" 
      sx={{
        position: 'absolute',
        top: 5,
        right: 5, 
        outline: 'none',
        zIndex: 1, 
      }}
    >
      <ClosedCaption sx={{ fontSize: '1rem' }} /> 
    </IconButton>
                  

                </div>
              ))}

            </div>

          </Grid2>


          {/* title */}
          <Grid2 size={{xs:12}}>
            <TextField
            fullWidth
            id='title'
            name='title'
            label="Title"
            value={formik.values.title}
            onChange={formik.handleChange}
            error={formik.touched.title && Boolean (formik.errors.title)}
            helperText={formik.touched.title && formik.errors.title}
            required
            >

            </TextField>
          </Grid2>


          <Grid2 size={{xs:12}}>
            <TextField
            multiline
            rows={4}
            fullWidth
            id='description'
            label="Description"
            value={formik.values.description}
            onChange={formik.handleChange}
            error={
              formik.touched.description && Boolean (formik.errors.description)
            }
            helperText={formik.touched.description && formik.errors.description}
            required

            >

            </TextField>


          </Grid2>


          <Grid2 sx={{xs:12 ,md:4, lg:3}}>
            <TextField
            fullWidth
            id='mrp_price'
            name="mrpPrice"
            label="MRP Price"
            type='number'
            value={formik.values.mrpPrice}
            onChange={formik.handleChange}
            error={formik.touched.mrpPrice && Boolean(formik.errors.mrpPrice)}
            helperText={formik.touched.mrpPrice && formik.errors.mrpPrice}
            >

            </TextField>

          </Grid2>

          <Grid2 size={{xs:12,md:4,lg:3}}>
            <TextField
            fullWidth
            id='sellingPrice'
            name='sellingPrice'
            label="Selling Price"
            type='number'
            value={formik.values.sellingPrice}
            onChange={formik
              .handleChange
            }
            error={formik.touched.sellingPrice && Boolean(formik.errors.sellingPrice)}
            helperText={formik.touched.sellingPrice && formik.errors.sellingPrice}
            required
            >

            </TextField>

          </Grid2>



          <Grid2 size={{xs:12,md:4,lg:3}}>
               <FormControl
               fullWidth
               error={formik.touched.color && Boolean(formik.errors.color)}
               required
               
               >
                <InputLabel id="color-label">Color</InputLabel>
                <Select
                labelId='color-label'
                id='color'
                name='color'
                value={formik.values.color}
                onChange={formik.handleChange}
                label="Color"
                >

                  <MenuItem value="">
                    <em>None</em>
                  
                  </MenuItem>

                  {colors.map((color,index)=>
                  <MenuItem
                  value={color.name}>
                  <div className='flex gap-3'>
                    <span style={{backgroundColor:color.hex}} className={`h-5 w-5 rounded-full ${color.name === "White" ? "border" : ""}`}>

                    </span>
                    <p>{color.name}</p>
                  </div>
                
                  </MenuItem>)}
                </Select>

                {formik.touched.color && formik.errors.color && (<FormHelperText>{formik.errors.color}</FormHelperText>)}


               </FormControl>
               
          </Grid2>

          <Grid2 size={{xs:12,md:4,lg:3}}>
            <FormControl
            fullWidth
            error={formik.touched.sizes && Boolean(formik.errors.sizes)}
            required

            >
              <InputLabel 
              id="sizes-label"
              >Sizes</InputLabel>
              <Select
              labelId='sizes-label'
              id='sizes'
              name='sizes'
              value={formik.values.sizes}
              onChange={formik.handleChange}
              label="Sizes"

              >
                <MenuItem
                value=""
                ><em>None</em></MenuItem>

                <MenuItem value="FREE">FREE</MenuItem>
                <MenuItem value="S">S</MenuItem>
                <MenuItem value="M">M</MenuItem>
                <MenuItem value="L">L</MenuItem>
                <MenuItem value="Xl">Xl</MenuItem>

              </Select>
              {formik.touched.sizes && formik.errors.sizes && <FormHelperText>{formik.errors.sizes}</FormHelperText>}

            </FormControl>

          </Grid2> 



          <Grid2 size={{xs:12 ,md:4,lg:4}}>
            <FormControl
            fullWidth
            error={formik.touched.category && Boolean(formik.errors.category)}
            required
            >

              <InputLabel
              id="category-label"
              >Category</InputLabel>

              <Select
              labelId='category-label'
              id='category'
              name='category'
              value={formik.values.category}
              onChange={formik.handleChange}
              label="Category"
              >
                {mainCategory.map((item)=>(
                  <MenuItem value={item.categoryId}>{item.name}</MenuItem>
                ))}

              </Select>
             {formik.touched.category && formik.errors.category &&(<FormHelperText>{formik.errors.category}</FormHelperText>)}

            </FormControl>


          </Grid2>


            <Grid2 size={{xs:12}}>
              <FormControl
              fullWidth
              error={formik.touched.category && Boolean(formik.errors.category)}
              required
              >
                 
                 <InputLabel id="category2-label">Second Category</InputLabel>
                <Select
                labelId='category2-label'
                id='category2'
                name='category2'
                value={formik.values.category2}
                onChange={formik.handleChange}
                label="Second Category"
                >

                  {formik.values.category && categoryTwo[formik.values.category] ?.map((item)=>(<MenuItem value={item.categoryId}>{item.name}</MenuItem>))}
                </Select>

                {formik.touched.category && formik.errors.category && (<FormHelperText>{formik.errors.category}</FormHelperText>)}

              </FormControl>

            </Grid2>

                  
                  
            <Grid2 size={{xs:12}}>
              <FormControl
              fullWidth
              error={formik.touched.category && Boolean(formik.errors.category)}
              required
              >
                 
                 <InputLabel id="category2-label">Third Category</InputLabel>
                <Select
                labelId='category-label'
                id='category'
                name='category3'
                value={formik.values.category3}
                onChange={formik.handleChange}
                label="Third Category"
                >

                <MenuItem value=""><em>None</em></MenuItem>
                {formik.values.category2 && childCategory(
                  categoryThree[formik.values.category],
                  formik.values.category2
                )
                ?.map((item:any)=>(
                  <MenuItem value={item.categoryId}>{item.name}</MenuItem>
                ))
                }


                </Select>

                {formik.touched.category && formik.errors.category && (<FormControl>{formik.errors.category}</FormControl>)}


              </FormControl>

            </Grid2>












          <Grid2 size={{xs:12}}>

            <Button
            sx={{p:"14px"}}
            color='primary'
            variant='contained'
            fullWidth
            type='submit'
            >
              {false ? <CircularProgress size="small"
              sx={{width:"27px",height:"27px"}}
              ></CircularProgress>:"Add Product"}

            </Button>
          </Grid2>



          

        </Grid2>

      </form>

{/* 
     <Snackbar
     anchorOrigin={{vertical:"top",horizontal:"right"}}
     open={snakbarOpen} autoHideDuration={6000}
     onClose={handleCloserSnackbar}
     >
      <Alert
      onClose={handleCloserSnackbar}
      severity={true ? "error" :"success"}
      variant='filled'
      sx={{width:"100%"}}
      >

        {sellerProduct.error ? sellerProduct.error : "Product created succefully"}
      </Alert>

     </Snackbar> */}

    </div>
  )
}

export default AddProductsForm