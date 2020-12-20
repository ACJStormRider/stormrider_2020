import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import {Container, Row, Col} from "react-bootstrap";
import {BrowserRouter as Router, Switch, Route, Link} from 'react-router-dom'

import Welcome from "./components/Welcome";
import NavBar from "./components/NavBar";
import ProductList from "./components/ProductList";
import AboutUs from "./components/AboutUs";
import Product from "./components/Product";
import React from "react";


function App() {

    return (
        <Router>
            <NavBar/>
            <Container>
                <Row>
                    <Col>
                        <Switch>
                            <Route path="/:language" exact component={Welcome}/>
                            <Route path="/about-us/:language/:aboutUs" component={AboutUs}/>
                            <Route path="/product-list/:language/:categoryId" component={ProductList}/>
                            <Route path="/product-details/:language/:productGroupId" component={Product}/>
                        </Switch>
                    </Col>
                </Row>
            </Container>
        </Router>
    );
}

export default App;


