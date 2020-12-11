import React from 'react';
import product from '../images/product-dummy.png'

import axios from 'axios';
import {CardColumns, Card, Button, Jumbotron} from "react-bootstrap";


//  DECLARATION OF GLOBAL LANGUAGE VARIABLE
//============================================

class ProductList extends React.Component {

    getCategoryId() {
        const categoryId = this.props.match.params.categoryId;
        console.log(categoryId);
        return categoryId;
    }

    getLanguage() {
        const language = this.props.match.params.language;
        console.log(language);
        return language;
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
                <span>
                {
                    (category.categoryId == this.getCategoryId()) ?
                    <span>
                    {
                        category.subcategory.map((subcategory) =>
                        <span>
                        {
                            subcategory.productGroup.map((productGroup) =>
                                <Card style={{width: '18rem'}}>
                                    <Card.Img variant="top" src={product}/>
                                    <Card.Body>
                                        {
                                            productGroup.productGroupLanguage.map((productGroupLanguage) =>
                                        <span>
                                        {
                                            (productGroupLanguage.appLanguage == this.getLanguage()) ?
                                                <div>
                                                    <Card.Text className="card-title">{productGroupLanguage.productGroupName}</Card.Text>
                                                    <Card.Text className="card-description">{productGroupLanguage.productGroupDescription}</Card.Text>
                                                </div>
                                                :
                                                null
                                        }
                                        </span>
                                            )
                                        }
                                        <Card.Text className="card-description">Price: {productGroup.basePrice + productGroup.vat}</Card.Text>
                                        <Button variant="outline-dark" block>Go somewhere</Button>
                                    </Card.Body>
                                </Card>
                            )
                        }
                        </span>
                        )
                    }
                    </span>
                    :
                    null
                }
                </span>
                )
            }
            </CardColumns>
        );
    }

}

export default ProductList;