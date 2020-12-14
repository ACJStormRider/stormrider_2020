import React, {Component, useEffect, useState} from 'react';
import {Card, Button} from "react-bootstrap";
import {Link} from 'react-router-dom';
import '../App.css';



const navStyle = {
    color: 'white'
};

export default class MenuComponent extends Component {


    constructor(props) {
        super(props);
        this.state = {
            menu: this.props.parentData
        }
    }






    render() {
        const {menu} = this.state;
        return(
            <div>
                <ul className="nav-links">
                    <Link to={`/category/${this.state.menu.id}`}>
                        <li key={menu.id}>{menu.name}</li>
                    </Link>

                </ul>
            </div>
        )
    }
}
// className={"border border-dark bg-secondary text-white"}
// <Product />

/*
*
*       const {card} = this.state;
        return (
            <div>
                <Card style={{ width: '18rem', backgroundColor:'#F4F4F4', margin:'0 20px', boxShadow: 'rgba(0, 0, 0, 0.16) 0px 2px 4px 1px'}}>
                    <Card.Img variant="top" src={process.env.PUBLIC_URL + "/img/hnakkur.png"} width={192} alt="hnakkur" />
                    <Card.Body>
                        <Card.Title style={{ fontFamily:'header-font', textAlign:'center', fontSize:'2.4em' ,fontWeight:'500'}}>Hruni</Card.Title>
                        <Card.Text style={{textAlign:'right'}}>
                            Product details
                            <span style={{ fontFamily:'number-font'}}>{card.price}</span>
                        </Card.Text>
                        <Button variant="primary">
                            testilly
                        </Button>
                    </Card.Body>
                </Card>
            </div>
*
*
* */