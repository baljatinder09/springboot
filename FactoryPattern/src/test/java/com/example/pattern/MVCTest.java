package com.example.pattern;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MVCTest {
	
	 @Autowired
	 private MockMvc mvc;
	 
	 @Test
		public void MvcRestTest() {
		 
		  try {
			mvc.perform(get("/taskbuilder")
				      .contentType(MediaType.APPLICATION_JSON))
				      .andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			      
	 }
}
