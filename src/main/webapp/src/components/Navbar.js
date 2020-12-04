import React, { Component } from 'react'
import logo from '../images/logo/dummyLogo.png';


export default class Navbar extends Component {
    render() {
        return (
            <div>
                <img src={logo} alt="Logo" />;
            </div>
        )
    }
}
