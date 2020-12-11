import React from 'react';
import {Jumbotron} from "react-bootstrap";


class Welcome extends React.Component {

    render() {
        return (
            <Jumbotron>
                <div className="welcome">Welcome</div>
            </Jumbotron>
        );
    }
}

export default Welcome;