/** @type {import('tailwindcss').Config} */
const tailwindConfig = {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        primary: "#00927c",
        secondary: "#EAF0F1",
      },
    },
  },
  plugins: [],
};

module.exports = tailwindConfig;
