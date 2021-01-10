import { useEffect, useState } from 'react';
import ProductsList from './ProductsList';
import StepsHeader from './StepsHeader';
import { Product } from './types';
import './styles.css';
import { fetchProducts } from './api';
import Footer from '../Footer';

function Orders() {

    const [products, setProducts] = useState<Product[]>([]);
    console.log(products);

    useEffect(() => {
        fetchProducts()
            .then(response => setProducts(response.data))
            .catch(error => console.log(error))
    }, []);

    return (
        <div className="orders-container">
            <StepsHeader/>
            <ProductsList products={products}/>
            
        </div>
    );
}

export default Orders;