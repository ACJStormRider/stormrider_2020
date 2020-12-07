import React, {Component} from "react";
import ProductList from "./ProductList";

export default class ProductPage extends Component{
    render() {
        return(
            <div>
                <div>Products: </div>
                <ProductList />
            </div>
        );
    }
}