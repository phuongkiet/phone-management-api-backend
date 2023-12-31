import axios from "axios";

const PRODUCT_API_BASE_URL = "http://localhost:8080/product";
class ProductService {
    getProducts(){
        return axios.get(PRODUCT_API_BASE_URL);
    }

    createProduct(product){
        return axios.post(PRODUCT_API_BASE_URL + "/addProduct", product);
    }

    getProductById(productId){
        return axios.get(PRODUCT_API_BASE_URL + '/' + productId);
    }

    updateProduct(product, productId){
        return axios.put(PRODUCT_API_BASE_URL + '/updateProduct/' + productId, product);
    }

}

const productService = new ProductService();

export default productService;