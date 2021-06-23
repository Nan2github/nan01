package com.example.nandemo;

import com.example.nandemo.service.OrderService;
import com.example.nandemo.service.ProductService;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class NandemoApplicationTests {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;

	@Test
	public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
		Mockito.when(productService.getProductName("1")).thenReturn("Mock Product Name");
		String testName = orderService.getProductName("1");
		Assert.assertEquals("Mock Product Name", testName);
	}

	@Test
	void contextLoads() {
	}

}
