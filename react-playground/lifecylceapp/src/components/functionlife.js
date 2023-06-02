
import React, { useState, useEffect } from 'react';

export default function Functionlife(props)
{
    const[msg,setMsg]=useState("");

    useEffect(() => {
            
          
           console.log ("effect hook called");

      });

  return(
    <div>
        
        <input type="text" value={msg} onChange={ (evt)=> setMsg(evt.target.value)}/> 
   Child component  Property is  {props.data}


    </div>



  )


}