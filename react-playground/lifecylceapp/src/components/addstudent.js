import { useState } from "react";
import './addstud.css';

export default function Addstudent(props)
{
 
    const[id,setStudentid]=useState('');
    const[name,setName]=useState('');
    const[subject,setSubject]=useState('');

  const saveUser=( (e)=>
  {
    e.preventDefault();
     const userdata={
         id,
         name,
         subject
     };
     console.log(userdata)
     props.addStudentEvt(userdata);
      
  })



    return(
       
   <div className="clsadd">
     <h5> Student REgistration </h5>
<form className="clsform" onSubmit={ (evt)=>saveUser(evt)}>
  
  <input type="text"   defaultValue={id} placeholder="enter id" onChange={ (evt)=> setStudentid(evt.target.value)}/>
  
  <input type="text"  defaultValue={name} placeholder="enter name"  onChange={ (evt)=> setName(evt.target.value)}/>
  
  <input type="text"   defaultValue={subject} placeholder="enter subject"  onChange={ (evt)=> setSubject(evt.target.value)}/>
  
  <button type="submit">submit</button>





</form>




   </div>




    );



}