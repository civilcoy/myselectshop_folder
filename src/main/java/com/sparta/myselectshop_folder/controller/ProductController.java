package com.sparta.myselectshop_folder.controller;

import com.sparta.myselectshop_folder.dto.ProductMypriceRequestDto;
import com.sparta.myselectshop_folder.dto.ProductRequestDto;
import com.sparta.myselectshop_folder.dto.ProductResponseDto;
import com.sparta.myselectshop_folder.entity.Product;
import com.sparta.myselectshop_folder.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 관심 상품 등록하기
    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto, HttpServletRequest request) {
        // 응답 보내기
        return productService.createProduct(requestDto, request);
    }

    // 관심 상품 조회하기
    @GetMapping("/products")
    public Page<Product> getProducts(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sortBy") String sortBy,
            @RequestParam("isAsc") boolean isAsc,
            HttpServletRequest request
    ) {
        // 응답 보내기
        return productService.getProducts(request, page-1, size, sortBy, isAsc);
    }

    // 관심 상품 최저가 등록하기
    @PutMapping("/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto, HttpServletRequest request) {
        // 응답 보내기 (업데이트된 상품 id)
        return productService.updateProduct(id, requestDto, request);
    }

}