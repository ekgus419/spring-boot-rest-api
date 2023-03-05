package com.example.service;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    // TODO ProductRepository 연결하고 Controller에서 호출하도록 변경
    // ProductServiceController > ProductService (Model) > ProductRepository ( getter / setter ) 맞아?
    // TODO ProductServiceController 이름은 ProductController 가 더 좋겠다.

    // 아니야!
    // jpa 관련된 포스팅 참조하고
    // 책 이번에 산거 참조하면 내용 있을거야
    // 하는김에 entity, model, dto 의 차이점도 한번 공부해봐
    // jpa 면 서버 마리아db 연결해야하는거지??
   // 응
    // product 테이블 설계하고 create table sql도 resources/schema.sql 파일로 하나 만들어두면 좋아

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product readProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new EntityNotFoundException("No product");
    }

    public List<Product> readProductAll() {
        return productRepository.findAll();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
