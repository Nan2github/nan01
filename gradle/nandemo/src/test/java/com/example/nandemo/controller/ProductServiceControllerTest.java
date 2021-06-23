package com.example.nandemo.controller;

import com.example.nandemo.AbstractRestControllerTest;
import com.example.nandemo.model.Product;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductServiceControllerTest extends AbstractRestControllerTest {

    @Override
    @BeforeEach
    public void setUp(){
        super.setUp();
    }

    @Test
    @Order(1)
    public void getProductList() throws Exception{
        String uri = "/products";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        validateResponse(mvcResult, 2);
    }

    @Test
    @Order(2)
    public void createProduct() throws Exception{
        String uri = "/products";
        Product product = new Product();
        product.setId("3");
        product.setName("Ginger");
        String inputJson = super.mapToJson(product);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Product[] productList = super.mapFromJson(content, Product[].class);
        validateResponse(mvcResult, 3);
    }

    @Test
    @Order(3)
    public void updateProduct() throws Exception{
        String uri = "/products/1";
        Product product = new Product();
        product.setId("");
        product.setName("Lemon");
        String inputJson = super.mapToJson(product);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        validateResponse(mvcResult, 3);
    }

    @Test
    @Order(4)
    public void deleteProduct() throws Exception{
        String uri = "/products/2";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        validateResponse(mvcResult, 2);
    }


    private void validateResponse(MvcResult mvcResult, int expectedLen) throws IOException {
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Product[] productList = super.mapFromJson(content, Product[].class);
        Assert.assertTrue(productList.length == expectedLen);
    }
}
