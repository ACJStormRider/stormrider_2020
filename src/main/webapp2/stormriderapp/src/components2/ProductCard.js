import React, {Component} from 'react';
import {Card, Button} from "react-bootstrap";
import {Link, Route} from 'react-router-dom';


export default class ProductCard extends Component {


    constructor(props) {
        super(props);
        this.state = {
            card: this.props.parentData
        }
    }




    render() {
        const {card} = this.state;
        return (
            <div>
                <Card style={{ width: '18rem', backgroundColor:'#F4F4F4', margin:'0 20px', boxShadow: 'rgba(0, 0, 0, 0.16) 0px 2px 4px 1px'}}>
                    <Card.Img variant="top" src={process.env.PUBLIC_URL + "/img/hnakkur.png"} width={192} alt="hnakkur" />
                    <Card.Body>
                        <Card.Title style={{ fontFamily:'Mukta Mahee', textAlign:'center', fontSize:'2.4em' ,fontWeight:'500'}}>Hruni</Card.Title>
                        <Card.Text style={{textAlign:'right'}}>
                            Product details
                            <p style={{ fontFamily:'number-font'}}>{card.price}</p>
                        </Card.Text>
                        <Button variant="primary">
                            <Link to={"productDetails"} className="nav-link">ProductDetails</Link>
                        </Button>
                    </Card.Body>
                </Card>
            </div>
        );
    }
}
// className={"border border-dark bg-secondary text-white"}
// <Product />