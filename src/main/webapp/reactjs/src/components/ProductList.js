import React, {Component} from 'react';
import {Card, Table, Jumbotron} from "react-bootstrap";
import ProductCard from "./ProductCard";


export default class ProductList extends Component{

    constructor(props) {
        super(props);
        this.state={
            cards: []
        };
    }

    componentDidMount() {

    }


    render() {
        return (
            <Jumbotron>
                <ProductCard />
            </Jumbotron>
            /*
            <Card className={"border border-dark bg-dark text-white"} style={{ width: '18rem' }}>
                <Card.Img variant="top" src={process.env.PUBLIC_URL + "/img/locologo.png"} width={192} alt="second logo" />
                <Card.Title>Card Title</Card.Title>
                <Card.Body>
                    <ProductCard />
                </Card.Body>
            </Card>
             */
        );
    }
}
/*
*
<Card style={{ width: '18rem' }}>
  <Card.Img variant="top" src="holder.js/100px180" />
  <Card.Body>
    <Card.Title>Card Title</Card.Title>
    <Card.Text>
      Some quick example text to build on the card title and make up the bulk of
      the card's content.
    </Card.Text>
    <Button variant="primary">Go somewhere</Button>
  </Card.Body>
</Card>
*           <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>Book List</Card.Header>
                <Card.Body>
                    <Table bordered hover stiped variant="dark">
                        <thead>
                        <tr>
                            <th>Title</th>
                            <th>Author</th>
                            <th>ISBN Number</th>
                            <th>Price</th>
                            <th>Language</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr align="center">
                            <td colspan="6">No books available</td>
                        </tr>
                        </tbody>
                    </Table>
                </Card.Body>
            </Card>
* */