import { DatePicker, LocalizationProvider } from '@mui/x-date-pickers'
import { Dayjs } from 'dayjs'
import { useFormik } from 'formik'
import React from 'react'
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs'
import { Box, Button, Grid2, TextField } from '@mui/material'
import { date } from 'yup'

interface CouponFormValues{

  code:string,
  discountPercentage:number,
  validatityStartDate:Dayjs | null,
  validityEndDate:Dayjs | null
  minimumOrderValue:number

  
}

const AddNewCoupon = () => {

  const formik=useFormik<CouponFormValues>({
    initialValues:{
      code:"",
      discountPercentage:0,
      validatityStartDate:null,
      validityEndDate:null,
      minimumOrderValue:0
    },
    onSubmit:(values)=>{
      console.log("form submit",values);

      const formtedValues={
        ...values,
        validatityStartDate:values.validatityStartDate?.toISOString(),
        validityEndDate:values.validityEndDate?.toISOString()
      }
      console.log("form submit",values,formtedValues);


      
    }
  })
  return (
    <div>
      <h1 className='text-2xl font-bold text-primary pb-5 text-center'>Create New Coupon</h1>
      <LocalizationProvider dateAdapter={AdapterDayjs}>
           <Box component={"form"} onSubmit={formik.handleSubmit} sx={{mt:3}}>
            <Grid2 container spacing={2}>
              <Grid2 size={{xs:12,sm:6}}>

              <TextField
                         fullWidth
                         name="code"
                         label="coupon code"
                         value={formik.values.code}
                         onChange={formik.handleChange}
                         error={formik.touched.code && Boolean(formik.errors.code)}
                         helperText={formik.touched.code && formik.errors.code}

                         >


                         </TextField>

              </Grid2>


             


              
                 <Grid2 size={{xs:12,sm:6}}>

              <TextField
                         fullWidth
                         name="discountPercentage"
                         label="DiscountPercentage"
                         value={formik.values.discountPercentage}
                         onChange={formik.handleChange}
                         error={formik.touched.discountPercentage && Boolean(formik.errors.discountPercentage)}
                         helperText={formik.touched.discountPercentage && formik.errors.discountPercentage}

                         >


                         </TextField>

              </Grid2>

              <Grid2 size={{xs:12,sm:6}}>

                <DatePicker
                sx={{width :"100%"}}
                label="Validity Start Date"
                name='validityStartDate'
                onChange={formik.handleChange}
                value={formik.values.validatityStartDate}
                
                />

              </Grid2>


              
              <Grid2 size={{xs:12,sm:6}}>

                <DatePicker
                sx={{width :"100%"}}
                label="Validity End Date"
                name='validityEndDtae'
                onChange={formik.handleChange}
                value={formik.values.validityEndDate}
                
                />

              </Grid2>


              <Grid2 size={{xs:12}}>

              <TextField
                         fullWidth
                         name="minimumOrderValue"
                         label="Minimum Order Value"
                         value={formik.values.minimumOrderValue}
                         onChange={formik.handleChange}
                         error={formik.touched.minimumOrderValue && Boolean(formik.errors.minimumOrderValue)}
                         helperText={formik.touched.minimumOrderValue && formik.errors.minimumOrderValue}

                         >


                         </TextField>

              </Grid2>

              <Grid2 size={{xs:12}}>
              <Button variant='contained' fullWidth sx={{py:".8rem"}}>
                Create Coupon
                
                </Button>
              </Grid2>




            </Grid2>
               
           </Box>

      </LocalizationProvider>
    </div>
  )
}

export default AddNewCoupon