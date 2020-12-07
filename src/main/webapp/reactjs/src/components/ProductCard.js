import React, {Component} from 'react';
import {Card, Table, Button} from "react-bootstrap";
import Product from "./Product";

export default class ProductCard extends Component {
    render() {
        return (
            <Card className={"border border-dark bg-dark text-white"} style={{ width: '18rem' }}>
                <Card.Img variant="top" src={process.env.PUBLIC_URL + "/img/locologo.png"} width={192} alt="second logo" />
                <Card.Body>
                    <Card.Title>Card Title</Card.Title>
                    <Card.Text>
                        Product details
                    </Card.Text>
                    <Button variant="primary">
                        <div>Price</div>
                        <Product />
                    </Button>
                </Card.Body>
            </Card>
        );
    }
}
