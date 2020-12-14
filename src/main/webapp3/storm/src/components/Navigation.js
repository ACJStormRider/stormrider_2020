import React from 'react';
import { Navbar, Nav } from 'react-bootstrap';
import {Link} from 'react-router-dom';


class Navigation extends React.Component {
    render(){

        return(
            <div>
                <Navbar bg="dark" variant="dark" style={{
                    background: `url("/header.jpg")`,backgroundRepeat: 'no-repeat',width:'100%',height:'200px'
                }}>
                    <Link to={""} className="navbar-brand">
                        <img src={process.env.PUBLIC_URL + "/headerlogo.png"} width={150} alt="second-logo"/>
                    </Link>
                    <Nav className="mr-auto">
                        <Link to={"/productlistall"} className="nav-link" >Product List All</Link>
                        <Link to={"/productlist1"} className="nav-link" >Product List cat2</Link>
                        <Link to={"/about"} className="nav-link" >About</Link>
                    </Nav>
                </Navbar>
            </div>
        );
    }
}

export default Navigation;