export default function Newscard(props)
{

    return(

    <div>

      <h6>   {props.content}</h6>   
    <h6>        {props.author}</h6> 
    <div>
            <img src={props.urlimg} alt="noimage"></img>

            </div>  
    </div>


    )



}