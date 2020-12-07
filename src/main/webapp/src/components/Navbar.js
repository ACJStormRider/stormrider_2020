import React, { Component } from 'react'
import logo from '../images/logo/dummyLogo.png';
import '../App.css';
import axios from 'axios';

export default class Navbar extends Component {

    constructor(props) {
        super(props);
        this.state = {
            categories : [] // constructs a list for categories
        }
    }

    componentDidMount() {
        axios.get("") // link to the localhost url from controller
            .then((data) => {
                this.setState({categories: data});
            });
    }


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
