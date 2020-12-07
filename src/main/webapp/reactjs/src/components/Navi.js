import React from 'react';

import { Navbar, Nav } from 'react-bootstrap';
//import locologo from '../../public/locologo.png';
import {Link} from 'react-router-dom';

class Navi extends React.Component {
    render(){

        return(
            <Navbar bg="dark" variant="dark">
                <Link to={""} className="navbar-brand">
                    <img src={process.env.PUBLIC_URL + "/locologo.png"} width={192} alt="second logo"/>
                </Link>
                <Nav className="mr-auto">
                    <Link to={"add"} className="nav-link">Add Book</Link>
                    <Link to={"list"} className="nav-link">Book List</Link>
                </Nav>
            </Navbar>
        );
    }
}

export default Navi;