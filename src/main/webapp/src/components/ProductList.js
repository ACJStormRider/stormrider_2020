import React from 'react';
import product from '../images/product-dummy.png'

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

//  CONSTRUCTOR
//=====================================================================================================================

    constructor(props) {
        super(props);
        this.state = {category: []};
        this.state = {subcategories: []};
        this.state = {productGroups: []};
    }

//  GET REQUEST
//=====================================================================================================================

    componentDidMount() {
        axios.get("http://localhost:8888/api/category/" + this.getCategoryId())
            .then(response => response.data)
            .then((data) => {
                this.setState({category : data});
            })

        this.state.category.subcategoryIds.map((subcategoryId) =>
            subcategoryId.
        )
    }

//  RENDER METHODS
//=====================================================================================================================

    render() {
        return (
            <CardColumns className="card-frame">
            {
                this.state.category.map((category) =>
                <span>
                {
                    (category.categoryId == this.getCategoryId()) ?
                    <span>
                    {
                        category.subcategories.map((subcategory) =>
                        <span>
                        {
                            subcategory.productGroups.map((productGroup) =>
                                <Card style={{width: '18rem'}}>
                                    <Card.Img variant="top" src={product}/>
                                    <Card.Body>
                                        {
                                            productGroup.productGroupLanguages.map((productGroupLanguage) =>
                                        <span>
                                        {
                                            (productGroupLanguage.appLanguageCode == this.getLanguage()) ?
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