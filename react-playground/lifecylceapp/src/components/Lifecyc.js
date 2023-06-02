import React from 'react'
import Functionlife from './functionlife';

class Lifecyclesample extends React.Component
{
  constructor(props)
  {
    super(props);
    this.state  = { info : "hackathon"};
    console.log("Inside Constructor"); 
    
  }

  componentDidMount()
  {
    console.log("Component Mounted");
    this.setState({info:"java assessment"})
    
  }

  componentDidUpdate()
  {
    console.log("Component updated ");
  }

  render() {

      return(

        <div>

              Props value is {this.props.message}
                <h1> Lifecylce Sample </h1>

<Functionlife data="hello"/>

<input type="text" value={this.state.info} onChange={ (evt)=> this.setState({info:evt.target.value})}/>
        <h3> State vlaue is         {this.state.info} </h3>


        </div>


      );



  }
}

export default Lifecyclesample;