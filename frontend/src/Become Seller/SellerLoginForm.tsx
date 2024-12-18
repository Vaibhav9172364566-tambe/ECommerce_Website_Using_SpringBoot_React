import { TextField } from '@mui/material'

import { useFormik } from 'formik';

const SellerLoginForm = () => {
  const formik=useFormik({
    initialValues:{
      email:"",
      otp:""
    },
    onSubmit:(values)=>{
      console.log("submit",values);
      
    }
  });

  return (
    <div>
      <h1 className='text-center font-bold text-xl text-primary pb-5'>Login As Seller</h1>
      <div className='space-y-5'>
        <TextField
        fullWidth
        name="email"
        label="Email"
        value={formik.values.email}
        onChange={formik.handleChange}
        onBlur={formik.handleBlur}
        error={formik.touched.email && Boolean(formik.errors.email)}
        helperText={formik.touched.email && formik.errors.email}
        >
 
        </TextField>


        {true &&
        <div className='space-y-2'>
          <p className='font-medium  text-sm opacity-60'> Enter Otp sent to your email</p>
          <TextField
        fullWidth
        name="otp"
        label="Otp"
        value={formik.values.otp}
        onChange={formik.handleChange}
        onBlur={formik.handleBlur}
        error={formik.touched.otp && Boolean(formik.errors.otp)}
        helperText={formik.touched.otp && formik.errors.otp}
        >
 
        </TextField>

        </div>
        }

      </div>

    </div>
  )
}

export default SellerLoginForm