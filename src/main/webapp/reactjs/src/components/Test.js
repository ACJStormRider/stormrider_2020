import React, {useEffect, useState} from "react";
import {Jumbotron} from 'react-bootstrap';


function Test() {
    const [list, setList] = useState([]);

    useEffect(() => {
        fetchProducts();
    }, []);

    const [products, setProducts] = useState([]);

    const fetchProducts = async () => {
        const data = await fetch('http://localhost:8888/api/products');

        const products = await data.json();
        console.log(products);
        setProducts(products);
    }

    return(
        <div>
            <Jumbotron>
                <h1>Tester</h1>
                {products.map(product => (
                    <h1 key={product.id}>{product.price}</h1>
                ))}
            </Jumbotron>
        </div>
    )
}
export default Test;