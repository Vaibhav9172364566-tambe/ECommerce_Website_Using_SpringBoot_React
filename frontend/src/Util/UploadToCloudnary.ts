export const uploadToCloudnary=async(pics:any)=>{
    const cloud_name="dgay8jhsv"
    const upload_present="ecommerce1"


    if(pics){
        const data=new FormData();
        data.append("file",pics)
        data.append("upload_present",upload_present)
        data.append("cloud_name",cloud_name)

        const res=await fetch("https://console.cloudinary.com/v1_1/dgay8jhsv/upload",{

            method:"POST",
            body:data
        })

        const fileDate=await res.json();
        return fileDate.url

    }
    else{
        console.log("error : pic not found" );
        
    }


}