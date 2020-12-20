import React from 'react';
import bridle from '../images/products/bridle.png'
import horseshoes from '../images/products/horseshoes.jpg'
import saddle1 from '../images/products/saddle1.png'
import saddle2 from '../images/products/saddle2.jpg'

import axios from 'axios';
import {CardColumns, Card, Button, Jumbotron} from "react-bootstrap";


class ProductList extends React.Component {

//  METHODS FOR RETRIEVING VALUES FROM PATH
//=====================================================================================================================

    getCategoryId() {
        const categoryId = this.props.match.params.categoryId;
        return categoryId;
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
                    (category.categoryId == this.getCategoryId()) ?
                    <>
                    {
                        category.subcategories.map((subcategory) =>
                        <>
                        {
                            subcategory.productGroups.map((productGroup) =>
                                <Card style={{width: '18rem'}}>
                                    <Card.Img variant="top" style={{height: '20rem'}} src={this.getImage(productGroup.productGroupImage.image)}/>
                                    <Card.Body>
                                        {
                                            productGroup.productGroupLanguages.map((productGroupLanguage) =>
                                        <>
                                        {
                                            (productGroupLanguage.appLanguageCode == this.getLanguage()) ?
                                                <div>
                                                    <Card.Text className="card-title">{productGroupLanguage.productGroupName}</Card.Text>
                                                    <Card.Text className="card-description">{productGroupLanguage.productGroupDescription}</Card.Text>
                                                </div>
                                                :
                                                null
                                        }
                                        </>
                                            )
                                        }
                                        <Card.Text className="card-description">Price: {productGroup.basePrice + productGroup.vat}</Card.Text>
                                        <Button variant="outline-dark" block href={
                                            {
                                                pathname: "/product-details/" + this.getLanguage() + "/" + productGroup.productGroupId
                                            }
                                        }>View Product</Button>
                                    </Card.Body>
                                </Card>
                            )
                        }
                        </>
                        )
                    }
                    </>
                    :
                    null
                }
                </>
                )
            }
            </CardColumns>
        );
    }

}

export default ProductList;