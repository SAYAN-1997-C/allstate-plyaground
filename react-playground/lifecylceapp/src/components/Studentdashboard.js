import axios from "axios"
import { useEffect,useState } from "react"
import Addstudent from "./addstudent";
import Studentcard from "./studentcard";
import './dashboard.css';
import Newscard from "./newscard";

export default function Studentdashboard()
{

    

    const[studentarr,setStudentarr]=useState([])
    const[successMessage,setSuccessMessage] = useState("")
    const[errorMessage,setErrorMessage] = useState("")

    // const[newsarr,setNewsarr] =useState([])

const addEventHandler= (data)=>
{
  axios.post('http://localhost:9096/student/addstudent',data,
   {
    headers: {
        'Content-type': 'application/json'
    }
   })
   .then
   (
    res=>
        {
        setStudentarr([...studentarr,res.data]);
        setErrorMessage("")
        setSuccessMessage("Student added successfully")
        }
   )
   .catch((error) => {
        setSuccessMessage("");
        setErrorMessage("Id is alreday exist");
        console.log(error);
   })
}


    const deleteEventhandler= (childid)=>
    {
axios.delete(`http://localhost:3005/student/${childid}`)
        .then
        (
            res=>
            {
               
                 if(res.status===200)
                 {
                    setStudentarr(studentarr.filter(stud=> stud.id !== childid))
                console.log("record deleted");
                console.log(res)
                 }
            }
        )
        .catch
         (
            err=>console.log("error " + err)
         )

    }

    useEffect(()=>{
 
    axios.get('http://localhost:9096/student/viewall')
    .then
    (
        (res)=>
        {
          
            console.log(res.data );
         setStudentarr(res.data);
             console.log(studentarr)
        }
    )
    .catch
    (
        (err)=>console.log("error occured " + err)
    )


                },[] );

    // ASSINGMENT sample
    //  axios.get('https://newsapi.org/v2/top-headlines?country=in&apikey=7f118af83e1b48f6939fc5096e89fd22&page=1')
    //         .then
    //         (
    //             (res)=>
    //             {
                  
    //                 console.log(res.data.articles);
    //              //   setStudentarr(res.data);
    //              setNewsarr(res.data.articles);
    //                 console.log(studentarr)
    //             }
    //         )
          


return(

 <div className="clsdashboard">
      <h4> Dashboard </h4>
  
  <div className="clsdisplay">
  <h5>{successMessage}</h5>
  <h5>{errorMessage}</h5>

 <div>
    {
       
     studentarr.map(stud=>
<Studentcard key={stud.id} id={stud.id} name={stud["name"]} subject={stud.subject} deleteItem={deleteEventhandler}/>
        
        )


//   newsarr.map (news=>
//     <Newscard content={news.content} author={news.author} urlimg={news.urlToImage} />)


   }
</div>

<Addstudent addStudentEvt={addEventHandler}/>
</div>
 </div>

)

}