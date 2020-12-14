import React, {useEffect, useState} from 'react';
import '../App.css';
import MenuComponent from "./MenuComponent";


function Category({match}) {

    useEffect(() => {
        fetchSubcategories();
        console.log(match);
    }, []);


    const [subcategories, setSubcategories] = useState([]);


    const fetchSubcategories = async () => {
        const fetchSubcategories = await fetch(`http://localhost:8888/api/subcategories/${match.params.id}`);

        const subcategories = await fetchSubcategories.json();
        setSubcategories(subcategories);
        console.log(subcategories);
    }




    const subcategoryStyle = {
        textAlign: 'left',
        padding: '20px',
        fontSize: '20px',
        listStyle: 'none'
    }

    return (
        <div>
            <h1>Category1</h1>

            <div className="subcat-menu">
                {subcategories.map(sub => (
                    <h3 key={sub.id}>{sub.name}</h3>
                ))}
            </div>
        </div>
    );
}

export default Category;

/*
*           <ul>
                {
                    subcategories.map(subcats => (
                        <li key={subcats.id}>{subcats.name}</li>
                    ))
                }
            </ul>
*
* */