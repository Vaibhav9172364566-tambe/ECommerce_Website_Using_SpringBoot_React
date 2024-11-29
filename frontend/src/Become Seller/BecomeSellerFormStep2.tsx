import { Grid2, TextField,Box, Button } from '@mui/material'
import {   useFormik } from 'formik';
import React from 'react'

import * as Yup from "yup"





const BecomeSellerFormStep2 = ({formik}:any) => {




  return (
        <Box >

            < >
                <Grid2 container spacing={3}>
                    <Grid2 size={{xs:12}}>
                         <TextField
                         fullWidth
                         name="name"
                         label="Name"
                         value={formik.values.name}
                         onChange={formik.handleChange}
                         error={formik.touched.name && Boolean(formik.errors.name)}
                         helperText={formik.touched.name && formik.errors.name}

                         >


                         </TextField>

                    </Grid2>


                    <Grid2 size={{xs:6}}>
                         <TextField
                         fullWidth
                         name="mobile"
                         label="Mobile"
                         value={formik.values.mobile}
                         onChange={formik.handleChange}
                         error={formik.touched.mobile && Boolean(formik.errors.mobile)}
                         helperText={formik.touched.mobile && formik.errors.mobile}

                         >


                         </TextField>

                    </Grid2>



                    <Grid2 size={{xs:6}}>
                         <TextField
                         fullWidth
                         name="pincode"
                         label="Pincode"
                         value={formik.values.pincode}
                         onChange={formik.handleChange}
                         error={formik.touched.pincode && Boolean(formik.errors.pincode)}
                         helperText={formik.touched.pincode && formik.errors.pincode}

                         >


                         </TextField>

                    </Grid2>



                    <Grid2 size={{xs:12}}>
                         <TextField
                         fullWidth
                         name="address"
                         label="Address"
                         value={formik.values.address}
                         onChange={formik.handleChange}
                         error={formik.touched.address && Boolean(formik.errors.address)}
                         helperText={formik.touched.address && formik.errors.address}

                         >


                         </TextField>

                    </Grid2>
                      
                      
                    <Grid2 size={{xs:12}}>
                         <TextField
                         fullWidth
                         name="locality"
                         label="Locality"
                         value={formik.values.locality}
                         onChange={formik.handleChange}
                         error={formik.touched.locality && Boolean(formik.errors.locality)}
                         helperText={formik.touched.locality && formik.errors.locality}

                         >


                         </TextField>

                    </Grid2>





                    <Grid2 size={{xs:6}}>
                         <TextField
                         fullWidth
                         name="city"
                         label="City"
                         value={formik.values.city}
                         onChange={formik.handleChange}
                         error={formik.touched.city && Boolean(formik.errors.city)}
                         helperText={formik.touched.city && formik.errors.city}

                         >


                         </TextField>

                    </Grid2>





                    <Grid2 size={{xs:6}}>
                         <TextField
                         fullWidth
                         name="state"
                         label="State"
                         value={formik.values.state}
                         onChange={formik.handleChange}
                         error={formik.touched.state && Boolean(formik.errors.state)}
                         helperText={formik.touched.state && formik.errors.state}

                         >


                         </TextField>

                    </Grid2>

                </Grid2>
            </>

        </Box>

  )
}

export default BecomeSellerFormStep2







