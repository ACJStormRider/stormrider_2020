import React from "react";
import './App.css';
import Navigation from "./components/Navigation";
import Welcome from "./components/Welcome";
import Footer from "./components/Footer";
import { Container, Row , Col} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import About from "./components/About";
import ProductList from "./components/ProductList";
import ProductListId from "./components/ProductListId";
import ProductDetails from "./components/ProductDetails";


function App() {

    const marginTop = {
        marginTop:"20px"
    };

  return (
      <div>
          <Router className="App">
              <Navigation />
              <Container>
                  <Row>
                      <Col lg={12} style={marginTop}>
                          <Switch>
                              <Route path="/" exact component={Welcome}/>
                              <Route path="/about" exact component={About}/>
                              <Route path="/productlistall" exact component={ProductList}/>
                              <Route path="/productlist1" exact component={ProductListId}/>
                              <Route path="/productDetails/:id" exact component={ProductDetails}/>
                          </Switch>
                      </Col>
                  </Row>
              </Container>
              <h1>Hi</h1>
              <Footer />
          </Router>
      </div>
  );
}

export default App;

//