import React from 'react'

export default class extends React.Component {
  static async getInitialProps(){
    var json = await fetch("/time").then((resp) => resp.json())
    return {time: json.time}
  }

  render() {
    return <p>Current time is: {this.props.time}</p>
  }
}
