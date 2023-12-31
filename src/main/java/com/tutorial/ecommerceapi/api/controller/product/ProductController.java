package com.tutorial.ecommerceapi.api.controller.product;

import com.tutorial.ecommerceapi.api.model.ProductInventoryBody;
import com.tutorial.ecommerceapi.model.Inventory;
import com.tutorial.ecommerceapi.model.Product;
import com.tutorial.ecommerceapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProduct();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    //TODO: Add authorization into REACT
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody ProductInventoryBody body){
        Product savedProduct = productService.addProduct(body);
        return ResponseEntity.ok(savedProduct);
    }

    //TODO: Add authorization into REACT
    //Update product
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody ProductInventoryBody body, @PathVariable Long id){
        Product updatedProduct = productService.updateProduct(id, body);
        return ResponseEntity.ok(updatedProduct);
    }

    //TODO: Add authorization into REACT
    //Delete Product by change the status of the Enabled
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    @PostMapping("/deleteProduct")
    public ResponseEntity<Product> deleteProduct(@RequestParam Long productId){
        Product deleteProduct = productService.deleteProduct(productId);
        return ResponseEntity.ok(deleteProduct);
    }
}
