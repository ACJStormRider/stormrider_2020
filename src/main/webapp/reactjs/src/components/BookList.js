import React, {Component} from "react";
import {Card, Table} from 'react-bootstrap';

export default class BookList extends Component {
    render() {
        return (
            <Card className={"border border-dark bg-dark text-white"}>
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
        );
    }

}
