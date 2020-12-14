import React, {Component} from 'react';
import {Card, Button} from "react-bootstrap";
import {Link} from 'react-router-dom';
import ProductDetails from "./ProductDetails";


export default class ProductCard extends Component {


    constructor(props) {
        super(props);
        this.state = {
            card: this.props.parentData
        }
    }

    onClick = (event) => {
        <ProductDetails parentData={this.state.card}/>
    }



    render() {
        const {card} = this.state;
        return (
            <div>
                <Card style={{ width: '18rem', backgroundColor:'#F4F4F4', margin:'0 20px', boxShadow: 'rgba(0, 0, 0, 0.16) 0px 2px 4px 1px'}}>
                    <Card.Img variant="top" src={process.env.PUBLIC_URL + `/img/${card.img}` } width={192} alt="hnakkur" />
                    <Card.Body>
                        <Card.Title style={{ fontFamily:'Mukta Mahee', textAlign:'center', fontSize:'2.4em' ,fontWeight:'500'}} key={card.id}>{card.productGroupName}</Card.Title>
                        <Card.Text style={{textAlign:'right'}}>

                            <p style={{ fontFamily:'number-font'}} key={card.id}>{card.totalPrice}</p>
                        </Card.Text>
                        <Button variant="primary">
                            <Link to={`/productDetails/${this.state.card.productGroupId}`} className="nav-link" key={card.id}>{card.productGroupName}
                            </Link>
                        </Button>

                    </Card.Body>
                </Card>
            </div>
        );
    }
}

//"/img/hnakkur.png"

/*<Link to={`/category/${this.state.menu.id}`}>
                        <li key={menu.id}>{menu.name}</li>
                    </Link>
*
*
* */