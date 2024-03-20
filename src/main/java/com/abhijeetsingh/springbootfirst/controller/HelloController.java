package com.abhijeetsingh.springbootfirst.controller;

import com.abhijeetsingh.springbootfirst.dto.ProductDTO;
import com.abhijeetsingh.springbootfirst.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@RestController
public class HelloController {

    @GetMapping("/")
    public String check() {
        return "yes online";
    }

    @GetMapping("/hello")
    public String getHome() {
        return  "<b>Home Page</b>";
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProductById(@PathVariable("id") long productId) throws IOException {
        Retrofit rf = new Retrofit.Builder().
                baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductService service = rf.create(ProductService.class);
        Call<ProductDTO> response = service.getProductById(productId);
        return response.execute().body();
    }

}
