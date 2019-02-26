package com.blitznihar.spring.appsimplerestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.blitznihar.spring.appsimplerestapi.terraform.Terraform;
import com.blitznihar.spring.appsimplerestapi.terraform.TerraformController;
import com.blitznihar.spring.appsimplerestapi.terraform.TerraformService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TerraformController.class, secure = false)
public class TerraformControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TerraformService terraformService;
	
	Terraform mocktf = new Terraform(10, "DevOps");

	
	@Test
	public void retrieveTerraformData() throws Exception {

		Mockito.when(terraformService.getTerraform(Mockito.anyString())).thenReturn(mocktf);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/terraform").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:10,stack:DevOps}";
		
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
}
