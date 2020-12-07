import React from 'react';
import './App.css';
import Navi from './components/Navi';
import { Container, Row , Jumbotron, Col} from 'react-bootstrap';
import Welcome from './components/Welcome';
import Footer from './components/Footer';
import BookList from "./components/BookList";
import Book from "./components/Book";
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import ProductPage from "./components/ProductPage";

function App() {
    const marginTop = {
        marginTop:"20px"
    };
    let x =444;

  return (

    <Router className="App">
        <Navi />
        <Container>
            <Row>
                <Col lg={12} style={marginTop}>
                    <Switch>
                        <Route path="/" exact component={Welcome}/>
                        <Route path="/add" exact component={Book}/>
                        <Route path="/list" exact component={BookList}/>
                        <Route path="/Products" exact component={ProductPage}/>
                    </Switch>
                </Col>
            </Row>
        </Container>
        <Footer />
    </Router>
  );
}

export default App;
