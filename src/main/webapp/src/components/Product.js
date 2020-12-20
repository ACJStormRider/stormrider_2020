import React from 'react';
import bridle from '../images/products/bridle.png'
import horseshoes from '../images/products/horseshoes.jpg'
import saddle1 from '../images/products/saddle1.png'
import saddle2 from '../images/products/saddle2.jpg'

import axios from 'axios';
import {CardColumns, Card, Button, Jumbotron} from "react-bootstrap";


class Product extends React.Component {

//  METHODS FOR RETRIEVING VALUES FROM PATH
//=====================================================================================================================

    getProductGroupId() {
        const productGroupId = this.props.match.params.productGroupId;
        return productGroupId;
    }

    getLanguage() {
        const language = this.props.match.params.language;
        return language;
    }

    getImage(link) {
        switch(link) {
            case 'bridle.png':
                return bridle;
                break;
            case 'horseshoes.jpg':
                return horseshoes;
                break;
            case 'saddle1.png':
                return saddle1;
                break;
            case 'saddle2.jpg':
                return saddle2;
                break;
            default:
                break;
        }
    }

//  CONSTRUCTOR
//=====================================================================================================================

    constructor(props) {
        super(props);
        this.state = {categories: []};
    }

//  GET REQUEST
//=====================================================================================================================

    componentDidMount() {
        axios.get("http://localhost:8888/api/category/all") // the ID needs to be passed from NavBar
            .then(response => response.data)
            .then((data) => {
                this.setState({categories : data});
            })
    }

//  RENDER METHODS
//=====================================================================================================================

    render() {
        return (
            <CardColumns className="card-frame">
                {
                    this.state.categories.map((category) =>
                        <>
                                        {
                                            category.subcategories.map((subcategory) =>
                                                <>
                                                    {
                                                        subcategory.productGroups.map((productGroup) =>
                                                            <>
                                                                {
                                                                    (productGroup.productGroupId == this.getProductGroupId()) ?
                                                                        <div>{productGroup.productGroupId}</div>
                                                                        :
                                                                        null
                                                                }
                                                            </>
                                                        )
                                                    }
                                                </>
                                            )
                                        }
                                    </>
                    )
                }
            </CardColumns>
        );
    }

}

export default Product;