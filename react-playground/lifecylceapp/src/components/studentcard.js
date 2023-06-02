
import './card.css';

export default function Studentcard(props)
{

const deleteStudent= (evt)=>
{
props.deleteItem(props.id)

} 


return(
   <div className="clscard">
       <h5> Student Name {props.name}</h5>
     <h5> Degree {props.subject}</h5>  

<button onClick={deleteStudent}>Delete</button>


   </div>




)


}