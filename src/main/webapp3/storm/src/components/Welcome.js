import React from "react";

import { Jumbotron } from 'react-bootstrap';

class Welcome extends React.Component{
    render() {
        return (

            <Jumbotron className="bg-dark text-white">
                <h1>Hey! Welcome to our store</h1>
                <p>
                    <blockquote>Testing blockquote :O </blockquote>
                </p>
            </Jumbotron>

        );
    }
}

export default Welcome;