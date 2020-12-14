import React, {useState, useEffect} from "react";
import {Table, Card} from "react-bootstrap";



function ProductDetails({match}) {

    useEffect(() => {
        fetchProducts();
        console.log(match);
    }, []);


    const [products, setProducts] = useState([]);


    const fetchProducts = async () => {
        const fetchProducts = await fetch(`http://localhost:8888/api/productDetails/${match.params.id}`);

        const products = await fetchProducts.json();
        setProducts(products);
        console.log(products);
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


            <p>{match.params.id}</p>
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>Book List</Card.Header>
                <Card.Body>
                    <p>
                        {products.map(product => (
                            <p>{product.productId}</p>
                        ))}
                    </p>
                    <Table bordered hover stiped variant="dark">
                        <thead>
                        <tr>
                            <th>Product</th>
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
            <div className="subcat-menu">
                <Table>
                    <thead>
                        <tr>

                        </tr>
                    </thead>
                </Table>
                {products.map(sub => (
                    <h3 key={sub.id}>{sub.name}</h3>
                ))}
            </div>
        </div>
    );
}

export default ProductDetails;

/*

export default class ProductDetails extends Component{


    constructor() {
        super(props);
        this.state={
            cards: []
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8888/api/productDetails")
            .then(response => response.data)
            .then((data) => {
                this.setState({cards: data});
            });

    }


    render() {
        return (
            <div>
                <Jumbotron style={{display:'flex'}}>
                    {
                        this.state.cards.length === 0 ?
                            <tr>
                                <td colSpan="6">Products available</td>
                            </tr> :
                            this.state.cards.map((card) => (
                                <tr key={card.id}>
                                    <td>{card.name}</td>
                                </tr>
                                && <ProductCard parentData={card}/>
                            ))
                    }

                </Jumbotron>
            </div>
        );
    }
}*/
