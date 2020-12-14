import React from 'react';
import ProductCard from "./ProductCard";
import {Jumbotron} from "react-bootstrap";
import axios from 'axios';

export default class ProductListId extends React.Component{


    constructor(props) {
        super(props);
        this.state={
            cards: []
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8888/api/products")
            .then(response => response.data)
            .then((data) => {
                this.setState({cards: data});
            });

    }


    render() {
        return (
            <div>
                <Jumbotron style={{display:'flex'}}>
                    {
                        this.state.cards.length === 0 ?
                            <tr>
                                <td colSpan="6">Products available</td>
                            </tr> :
                            this.state.cards.map((card) => (
                                <tr key={card.id}>
                                    <td>{card.name}</td>
                                </tr>
                                && <ProductCard parentData={card}/>
                            ))
                    }

                </Jumbotron>
            </div>
        );
    }
}