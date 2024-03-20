package com.abhijeetsingh.springbootfirst.service;

import com.abhijeetsingh.springbootfirst.dto.ProductDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductService {

    @GET("products/{id}")
    Call<ProductDTO> getProductById(@Path("id") long id);
}
