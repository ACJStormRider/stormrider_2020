import React from'react';
import './App.css';
import Navigation from "./components2/Navigation";
import About from "./components/About";
import Shop from "./components/Shop";
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Category from "./components/Category";
import Test from "./components2/Test";
import { Container, Row , Jumbotron, Col} from 'react-bootstrap';
import Footer from "./components2/Footer";

function App() {

    const marginTop = {
        marginTop:"20px"
    };
    let x =444;

  return (
      <div>
          <Router>
              <Navigation />
              <Container>
                  <Row>
                      <Col lg={12} style={marginTop}>
                          <Switch>
                              <Route path="/test" exact component={Test}/>
                              <Route path="/products" exact component={Category}/>
                          </Switch>
                      </Col>
                  </Row>
              </Container>
              <Footer />
          </Router>
      </div>

  );
}

export default App;

/*
*                 <Route path="/" exact component={Home}/>
                  <Route path="/about" exact component={About}/>
                  <Route path="/shop" exact component={Shop}/>
                  <Route path="/category/:id" exact component={Category}/>
*
*
*
* <Router>
          <div >
              <Navigation />
              <Switch>
                  <Route path="/test" exact component={Test}/>
                  <Route path="/products" exact component={Category}/>
              </Switch>
          </div>
      </Router>
*
* */