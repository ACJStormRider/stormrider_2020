import React from 'react';
import { Navbar, Nav } from 'react-bootstrap';
import {Link, Route} from 'react-router-dom';


class Navi extends React.Component {
    render(){

        return(
            <div>
                <Navbar bg="dark" variant="dark">
                    <Link to={""} className="navbar-brand">
                        <img src={process.env.PUBLIC_URL + "/locologo.png"} width={15} alt="second-logo"/>
                    </Link>
                    <Nav className="mr-auto">
                        <Link to={"products"} className="nav-link">Products</Link>
                    </Nav>
                </Navbar>
            </div>
        );
    }
}

export default Navi;