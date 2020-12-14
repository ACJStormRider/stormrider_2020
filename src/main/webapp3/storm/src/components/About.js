import React from "react";

import { Jumbotron } from 'react-bootstrap';

class About extends React.Component{
    render() {
        return (

            <Jumbotron className="bg-dark text-white">
                <h1>Hey This is about us</h1>
            </Jumbotron>

        );
    }
}

export default About;