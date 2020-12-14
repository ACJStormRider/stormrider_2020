import React, {Component} from "react";


export default class ProductDetails extends Component{

    constructor(props) {
        super(props);
        this.state = {
            card: this.props.parentData
        }
    }
    
    render() {
        return(
            <div>
                <div>Product name: </div>
                
            </div>
        );
    }
}