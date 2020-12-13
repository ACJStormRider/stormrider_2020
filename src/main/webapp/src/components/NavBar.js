import React from 'react';
import logo from '../header-logo.png'

import {Navbar, Nav, Button} from "react-bootstrap";
import {Link} from 'react-router-dom';
import axios from "axios";


//  DECLARATION OF GLOBAL LANGUAGE VARIABLE
//============================================

var language = 'en';




class NavBar extends React.Component {

//  CONSTRUCTOR
//=====================================================================================================================

    constructor(props) {
        super(props);
        this.state = {categories: []};
    }

//  GET REQUEST
//=====================================================================================================================

    componentDidMount() {
        axios.get("http://localhost:8888/api/category/all")
            .then(response => response.data)
            .then((data) => {
                this.setState({categories : data});
            })
    }

//  RENDER TRANSLATIONS
//=====================================================================================================================

    renderAboutUs(language) {
        switch(language) {
            case 'en':
                return 'About Us';
                break;
            case 'is':
                return 'Um Okkur';
                break;
            default:
                break;
        }
    }

//  RENDER METHOD
//=====================================================================================================================

    render() {
        return (
            <Navbar expand="lg" bg="dark" variant="dark">
                <Link className="navbar-brand" to={
                    {
                        pathname: "/" + language
                    }
                }><img src={logo} width="150"/></Link>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="mr-auto">
                <>
                {
                    this.state.categories.map((category) =>
                    <>
                    {
                        category.categoryLanguages.map((categoryLanguage) =>
                        <>
                        {
                            (categoryLanguage.appLanguageCode === language) ?
                                <Link className="nav-link" to={
                                    {
                                        pathname: "/product-list/" + language + "/" + categoryLanguage.categoryId
                                    }
                                }>{categoryLanguage.name}</Link>
                            :
                            null
                        }
                        </>
                        )
                    }
                    </>
                    )
                }
                </>
                <Link className="nav-link" to={
                    {
                        pathname: "/about-us/" + language + "/" + this.renderAboutUs(language)
                    }
                }>{this.renderAboutUs(language)}</Link>
                </Nav>
                </Navbar.Collapse>
            </Navbar>

        );
    }
}

export default NavBar;