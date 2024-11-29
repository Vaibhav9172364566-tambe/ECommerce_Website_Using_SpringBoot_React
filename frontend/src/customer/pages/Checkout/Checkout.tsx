import { Box, Button, FormControl, FormControlLabel, Modal, Radio, RadioGroup } from '@mui/material';
import React from 'react';
import AddressCard from './AddressCard';
import AddressForm from './AddressForm';
import PricingCard from '../Card/PricingCard';

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 500,
  bgcolor: 'background.paper',
  boxShadow: 24,
  p: 4,
};

const paymentGateWayList = [
  {
    value: 'RAZORPAY',
    image: 'https://upload.wikimedia.org/wikipedia/commons/b/b3/Razorpay_logo.webp',
    label: 'Razorpay',
  },
  {
    value: 'STRIPE',
    image: 'https://www.logo.wine/a/logo/Stripe_(company)/Stripe_(company)-Logo.wine.svg',
    label: 'Stripe',
  },
];

const Checkout = () => {
  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);
  const [paymentGateWay, setPaymentGateWay] = React.useState('RAZORPAY');

  const handlePaymentChange = (event: any) => {
    setPaymentGateWay(event.target.value);
  };

  return (
    <>
      <div className="pt-10 px-5 sm:px-10 md:px-44 lg:px-60 min-h-screen">
        <div className="space-y-5 lg:space-y-0 lg:grid grid-cols-3 lg:gap-9">
          <div className="col-span-2 space-y-5">
            <div className="flex justify-between items-center">
              <h1 className="font-semibold">Select Address</h1>
              <Button onClick={handleOpen}>Add new Address</Button>
            </div>

            <div className="text-xs font-medium space-y-5">
              <p>Saved Address</p>
              <div className="space-y-3">
                {[1, 1, 1].map((Item, index) => (
                  <AddressCard key={index} />
                ))}
              </div>
            </div>

            <div className="py-4 px-5 rounded-sm border">
              <Button onClick={handleOpen}>Add new Address</Button>
            </div>
          </div>

          <div>
            <div className="space-y-3 border p-5 rounded-md">
              <h1 className="text-primary font-medium pb-2 text-center">Choose Payment Gateway</h1>
              <RadioGroup
                row
                aria-labelledby="demo-row-radio-buttons-group-label"
                name="row-radio-buttons-group"
                className="flex justify-between pr-0"
                onChange={handlePaymentChange}
                value={paymentGateWay}
              >
                {paymentGateWayList.map((item) => (
                  <FormControlLabel
                    key={item.value}
                    className="border w-[45%] pr-2 rounded-md justify-center"
                    value={item.value}
                    control={<Radio />}
                    label={
                      <img
                        className={`${
                          item.value === 'STRIPE' ? 'w-14' : ''
                        } object-contain`}
                        src={item.image}
                        alt={item.label}
                      />
                    }
                  />
                ))}
              </RadioGroup>
            </div>

            <div className="border rounded-md">
              <PricingCard />
              <div>
                <Button className="p-5" fullWidth variant="contained" sx={{ py: '11px' }}>
                  Checkout
                </Button>
              </div>
            </div>
          </div>
        </div>
      </div>

      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <AddressForm />
        </Box>
      </Modal>
    </>
  );
};

export default Checkout;