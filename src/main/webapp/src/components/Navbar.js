import React, { Component } from 'react'
import logo from '../images/logo/dummyLogo.png';
import '../App.css';

export default class Navbar extends Component {
    render() {
        return (
            <div>
                <div>
                    <img src={logo} alt="Logo" className="logo" />
                </div>
                <div className="navbar">
                    <span>Riding Gear</span>
                    <span>Other Stuff</span>
                    <span>About Us</span>
                </div>
            </div>
        )
    }
}
