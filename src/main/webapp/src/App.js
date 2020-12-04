import React, { Component } from 'react';
//import logo from './public/images/logo/nameOfTheLogo.svg';
import './App.css';

import Navbar from './components/Navbar';



class App extends Component {
    render() {
        return (
            <React.Fragment>
                <Navbar />
                <Switch>
                    <Route exact path="/" component={ProductList}></Route>
                    <Route component={Default}></Route>
                </Switch>
            </React.Fragment>
        );
    }
}


export default App;