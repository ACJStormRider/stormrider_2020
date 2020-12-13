import React from 'react';
import {Container, Jumbotron} from "react-bootstrap";



class AboutUs extends React.Component {

//  METHODS FOR RETRIEVING VALUES FROM PATH
//=====================================================================================================================

    getLanguage() {
        const language = this.props.match.params.language;
        console.log(language);
        return language;
    }

    getAboutUs() {
        const aboutUs = this.props.match.params.aboutUs;
        console.log(aboutUs);
        return aboutUs;
    }

//  RENDER TRANSLATIONS
//=====================================================================================================================

    renderAboutUsMessage(language) {
        switch(language) {
            case 'en':
                return 'Message about STORMRIDER';
                break;
            case 'is':
                return 'Bulbulbul asfgwthyt STORMRIDER';
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
                    <h1 className="welcome">{this.getAboutUs()}</h1>
                    <p className="welcome-message">{this.renderAboutUsMessage(this.getLanguage())}</p>
                </Container>
            </Jumbotron>
        );
    }
}

export default AboutUs;