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

//  RENDER METHODS
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


    render() {
        return (
            <Navbar expand="lg">
                <Link to={""} className="navbar-brand">
                    <img src={logo} width="150"/>
                </Link>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="mr-auto">
                <span>
                {
                    this.state.categories.map((category) =>
                    <span>
                    {
                        (typeof(category.categoryLanguages) == 'object') ?
                        <span>
                        {
                            category.categoryLanguages.map((categoryLanguage) =>
                            <span>
                            {
                                (categoryLanguage.appLanguageCode === language) ?
                                <Link className="navlink" to={
                                    {
                                        pathname: "/" + language + "/" + categoryLanguage.categoryId,
                                        state: this.state.category
                                    }
                                }>
                                    {categoryLanguage.name}
                                </Link>
                                :
                                null
                            }
                            </span>
                            )
                        }
                        </span>
                        :
                        null
                    }
                    </span>
                    )
                }
                </span>
                    <Link to={"/about-us"} className="nav-link">{this.renderAboutUs(language)}</Link>
                </Nav>
                </Navbar.Collapse>
            </Navbar>

        );
    }
}

export default NavBar;