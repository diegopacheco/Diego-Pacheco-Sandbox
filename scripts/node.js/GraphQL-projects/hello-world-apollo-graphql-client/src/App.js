import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

async function loadGreeting(){
  const response = await fetch('http://localhost:9000/graphql',{
    method: 'POST',
    headers: {
      'content-type': 'application/json',
    },
    body: JSON.stringify({query: '{ greeting }'})
  }).then(res => res.json());
  const data = await response;
  return data.data.greeting;
}

class App extends Component {
  constructor(props){
    super(props);
    this.state = {
      greeting: '',
    };
    loadGreeting().then( (greeting) =>  { 
      console.log("got: " + greeting);  
      this.setState({greeting})
     });
  }
  render() {
    const {greeting} = this.state;
    return (
      <div className="App">
        <header className="App-header">
          <h1 className="App-title">From GraphQL Server: {greeting}</h1>
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
        </header>
      </div>
    );
  }
}

export default App;
