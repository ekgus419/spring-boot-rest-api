package com.example.controller;

import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.model.Product;
@RestController
@RequiredArgsConstructor
public class ProductServiceController {
    private final ProductService productService;
//    private static Map<String, Product> productRepo = new HashMap<>();
//    static {
//        Product honey = new Product();
//        honey.setId("1");
//        honey.setName("Honey");
//        productRepo.put(honey.getId(), honey);
//
//        Product almond = new Product();
//        almond.setId("2");
//        almond.setName("Almond");
//        productRepo.put(almond.getId(), almond);
//    }

    // GET API 리소스를 가져온다.
    /*@RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }*/
    //  POST API 리소스를 생성한다.
    /*@RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
//        productRepo.put(product.getId(), product);
//        productService.insert(product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }*/
    /*    // DELETE API 리소스를 삭제한다.
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        //productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }*/

/*    // PUT API 리소스를 업데이트한다.
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
//        productRepo.remove(id);
//        product.setId(id);
//        productRepo.put(id, product);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }
    */

    @GetMapping("/products")
    public ResponseEntity readProducts() {
        return ResponseEntity.ok(productService.readProductAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> readProduct (@PathVariable Long id) {
        return ResponseEntity.ok(productService.readProduct(id));
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct (@RequestBody Product product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @PutMapping("/products")
    public ResponseEntity<Product> updateProduct (@RequestBody Product product) {
        Product newProduct = productService.readProduct(product.getId());
        newProduct.setName(product.getName());
        return ResponseEntity.ok(productService.saveProduct(newProduct));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct (@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}
