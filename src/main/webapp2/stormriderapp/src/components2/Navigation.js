import React from "react";
import '../App.css';
import {Link} from 'react-router-dom';
import { Navbar, Nav } from 'react-bootstrap';


class Navigation extends React.Component {
    render() {


        return (
            <div>
                <Navbar bg="dark" variant="dark">
                    <Link to={""} className="navbar-brand">
                        <img src={process.env.PUBLIC_URL + "/headerlogo.png"} width={150} alt="header-logo"/>
                    </Link>
                    <Nav >
                        <Link to={"/test"} className="navbar-brand">
                            <li>Test</li>
                        </Link>

                    </Nav>
                </Navbar>
            </div>

        );
    }

}

export default Navigation;


// <ul><li></li></ul>
/*
*
*               <Link to={"/category1"} style={navStyle}>
                    <li>{this.x}</li>
                </Link>
                <Link to={"/category2"} style={navStyle}>
                    <li>{this.y}</li>
                </Link>
* */


/*
*
*     useEffect(() => {
        fetchCategories();
    }, []);


    const [categories, setCategories] = useState([]);

    const fetchCategories = async () => {
        const data = await fetch('http://localhost:8888/api/categoryList');

        const categories = await data.json();

        let y = categories[1];

        for(let i = 0; i < categories.size; i++){
            console.log('Here - Start');
            console.log(categories[i]);
            console.log('Here - End');
        }

        console.log(y.name);
        console.log(categories);
        setCategories(categories);
    }




    const navStyle = {
        color: 'white'
    };



    return (
        <nav>
            <Link to={""} className="nav-img">
                <img src={process.env.PUBLIC_URL + "/logo2.png"} width={159} alt="navbarlogo"/>
            </Link>

            <ul className="nav-links">
                {
                    categories.map(category => (
                        <MenuComponent parentData={category}/>
                    ))
                }
                <Link to={"/about"} style={navStyle}>
                    <li>About Page</li>
                </Link>
                <Link to={"/shop"} style={navStyle}>
                    <li>Shop Page</li>
                </Link>

            </ul>
        </nav>

    );
*
*
*
* */