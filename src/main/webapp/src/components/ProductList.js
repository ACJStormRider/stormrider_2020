import React from 'react';
import bridle from '../images/products/bridle.png'
import horseshoes from '../images/products/horseshoes.jpg'
import saddle1 from '../images/products/saddle1.png'
import saddle2 from '../images/products/saddle2.jpg'

import {CardColumns, Card, Button, Jumbotron} from "react-bootstrap";



class ProductList extends React.Component {

//  R E N D E R   M E T H O D
//=====================================================================================================================

    render() {
        const { categoryId } = this.props.match.params; // Will retreive the catgeoryId parameter passed through the path
        console.log(categoryId);
        return (
            <div>lalal</div>
        /*
            <CardColumns className="card-frame">
            {
                this.props.categories.map((category) =>
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
                                        <Button variant="outline-dark" block>Go somewhere</Button>
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
            */
        );
    }

}

export default ProductList;