import React, {Component, useEffect} from "react";
import axios from 'axios';
import Test from "./Test";
import TestLoop from "./TestLoop";


export default class Product extends Component{
    render() {
        return (
            <div>
                <TestLoop />
            </div>
        )
    }
}