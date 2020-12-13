import React from 'react';
import {Jumbotron, Container} from "react-bootstrap";



class Welcome extends React.Component {

//  METHODS FOR RETRIEVING VALUES FROM PATH
//=====================================================================================================================

    getLanguage() {
        const language = this.props.match.params.language;
        return language;
    }


//  RENDER TRANSLATIONS
//=====================================================================================================================

    renderWelcome(language) {
        switch(language) {
            case 'en':
                return 'Welcome';
                break;
            case 'is':
                return 'Bulbulbul';
                break;
            default:
                break;
        }
    }

    renderWelcomeMessage(language) {
        switch(language) {
            case 'en':
                return 'Welcome message from STORMRIDER';
                break;
            case 'is':
                return 'Bulbulbul asdas asfsdf asfgwthyt STORMRIDER';
                break;
            default:
                break;
        }
    }

//  RENDER METHOD
//=====================================================================================================================

    render() {
        return (
            <Jumbotron>
                <Container>
                    <h1 className="welcome">{this.renderWelcome(this.getLanguage())}</h1>
                    <p className="welcome-message">{this.renderWelcomeMessage(this.getLanguage())}</p>
                </Container>
            </Jumbotron>
        );
    }
}

export default Welcome;
