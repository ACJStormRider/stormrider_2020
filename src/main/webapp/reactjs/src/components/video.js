import React, {useState, useEffect} from 'react';

function Shop () {

    useEffect(() => {
        fetchItems();
    }, [])

    const fetchItems = async () => {
        const data = await fetch('http://localhost:8888/api/products');
        const products = await data.json();
        console.log(products);
    }

    return (
        <div>shop</div>
    )
}

export default Shop;
