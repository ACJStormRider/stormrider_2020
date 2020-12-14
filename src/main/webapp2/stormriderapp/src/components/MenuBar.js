import React from 'react';
import '../App.css';
import {Link} from 'react-router-dom';


function MenuBar() {



    const navStyle = {
        color: 'white'
    };

    return (
        <div className="App">
            <Link to={"/Category"} style={navStyle}>

            </Link>
        </div>
    );
}

export default MenuBar;

/*
* const [categoryList, setCategoryList] = useState([]);

    useEffect(() => {
        fetchCategory();
    }, []);

    const [categories, setCategories] = useState([]);

    const fetchCategories = async () => {
        const data = await fetch('http://localhost:8888/api/categoryList');

        const categories = await data.json();
        console.log(categories);
        setProducts(categories);
    }
    *
    *
    *       <h1>Tester</h1>
            {categories.map(category => (
                <h1 key={category.id}>{category.name}</h1>
            ))}

*
* */