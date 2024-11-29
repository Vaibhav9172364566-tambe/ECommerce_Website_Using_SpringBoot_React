import { TextField, Box } from '@mui/material';

interface BecomeSellerFormStep2Props {
  formik: any;
}

const BecomeSellerFormStep4 = ({ formik }: BecomeSellerFormStep2Props) => {
  return (
    <div className="space-y-5">
      <form onSubmit={formik.handleSubmit}>
        {/* Business Name Field */}
        <Box mb={2}>
          <TextField
            fullWidth
            name="businessDetails.businessName"
            label="Business Name"
            value={formik.values.businessDetails.businessName}
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            error={formik.touched.businessDetails?.businessName && Boolean(formik.errors.businessDetails?.businessName)}
            helperText={formik.touched.businessDetails?.businessName && formik.errors.businessDetails?.businessName}
          />
        </Box>

        {/* Seller Name Field */}
        <Box mb={2}>
          <TextField
            fullWidth
            name="sellerName"
            label="Seller Name"
            value={formik.values.sellerName}
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            error={formik.touched.sellerName && Boolean(formik.errors.sellerName)}
            helperText={formik.touched.sellerName && formik.errors.sellerName}
          />
        </Box>

        {/* Email Field */}
        <Box mb={2}>
          <TextField
            fullWidth
            name="email"
            label="Email"
            value={formik.values.email}
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            error={formik.touched.email && Boolean(formik.errors.email)}
            helperText={formik.touched.email && formik.errors.email}
          />
        </Box>

        {/* Password Field */}
        <Box mb={2}>
          <TextField
            fullWidth
            name="password"
            label="Password"
            value={formik.values.password}
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            error={formik.touched?.password && Boolean(formik.errors?.password)}
            helperText={formik.touched?.password && formik.errors?.password}
          />
        </Box>
      </form>
    </div>
  );
};

export default BecomeSellerFormStep4;
