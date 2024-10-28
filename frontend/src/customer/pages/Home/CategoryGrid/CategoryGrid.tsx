import React from 'react'

const CategoryGrid = () => {
  return (
    <div className='grid gap-4 grid-rows-12 grid-cols-12  lg:h-[600px] px-5 lg:px-20'>
        <div className='col-span-3 row-span-12 text-white'>
            <img  
            className="w-full h-full object-cover object-top rounded-md"
            src='https://imgs.search.brave.com/g4hlAnXmyC_sKhvOjwWmcvT7ccA-U0DNPy-9rRp4yoo/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly93d3cu/cmV2aWV3c3hwLmNv/bS9ibG9nL3dwLWNv/bnRlbnQvdXBsb2Fk/cy8yMDE4LzA1L1Nh/cmVlLmNvbS1TYXJl/ZXMtNDI1eDU2NS5q/cGc' alt=''></img>

        </div>
        <div className='col-span-2 row-span-6 text-white'>
            <img
            className="w-full h-full object-cover object-top rounded-md"
            src='https://imgs.search.brave.com/DmDt0KrCPvJjbVQjqdqsgZYNvqVu7nmr2nGUxriT-cs/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9tLm1l/ZGlhLWFtYXpvbi5j/b20vaW1hZ2VzL0kv/NDFSREtOVlBVNkwu/anBn' alt=''></img>

        </div>

        <div className='col-span-4 row-span-6 text-white'>
        <img 
        className="w-full h-full object-cover object-top rounded-md"
        src="https://images.pexels.com/photos/12730873/pexels-photo-12730873.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" alt='' />
        </div>

        <div className='col-span-3 row-span-12 text-white'>
        <img 
        className="w-full h-full object-cover object-top rounded-md"
        src="https://imgs.search.brave.com/8HePnKeGKR3GJDLCzvN7e2zmmS4NBCHQv8phXUQkTLU/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9ibG9n/LmczZmFzaGlvbi5j/b20vd3AtY29udGVu/dC91cGxvYWRzLzIw/MTkvMTAvbWVucy1r/dXJ0YS13aXRoLWtv/dGkuanBn" alt="" />

        </div>

        <div className='col-span-4 row-span-6 text-white'>
        <img 
        className="w-full h-full object-cover object-top rounded-md"
        src="https://imgs.search.brave.com/8o5p84el_BMMGGz3BjSBZZZdl982ukBvjOMaQZgme0I/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvNTIw/NTI5NDgyL3Bob3Rv/L2dvbGQtc291ay1k/dWJhaS5qcGc_cz02/MTJ4NjEyJnc9MCZr/PTIwJmM9aE15NVFB/U0FtbzByRzF0OXdy/eko0YXByMV8wMkdq/cWJHNU1kMllJNXBj/UT0" alt="" />

        </div>


        <div className='col-span-2 row-span-6 text-white'>
        <img 
        className="w-full h-full object-cover object-top rounded-md"
        src="https://imgs.search.brave.com/Eys0Ct-u3TIMJ7dmD98JNgsTgqPiu1EIDtgMYljeWBM/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly93d3cu/c2hvZS10ZWFzZS5j/b20vd3AtY29udGVu/dC91cGxvYWRzLzIw/MjMvMTAvUGluay1T/aG9lcy1BZmZpbGlh/dGUtMi5qcGc" alt="" />

        </div>

        


    </div>
  )
}

export default CategoryGrid