import React, {useEffect, useState} from 'react';
import ProductCard from "./ProductCard";
import {Jumbotron} from "react-bootstrap";


export default class Products extends React.Component{


    constructor(props) {
        super(props);
        this.state={
            cards: []
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8888/api/subcategories")
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

/*
*
*
*       const fetchProducts = async () => {
        const fetchProducts = await fetch(`http://localhost:8888/api/products`);

        const products = await fetchProducts.json();
        setProducts(products);
        console.log(products);
    }
*
*
* */
