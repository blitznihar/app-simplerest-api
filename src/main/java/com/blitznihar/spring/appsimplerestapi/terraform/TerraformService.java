package com.blitznihar.spring.appsimplerestapi.terraform;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

@Component
public class TerraformService {
	
	private final AtomicLong counter = new AtomicLong();
	public Terraform getTerraform(String stack) {
	return new Terraform(counter.incrementAndGet(), stack);
	}
	public long insertTerraform(Terraform terraform) {
		return terraform.getId();
	}
	public String updateTerraform(Terraform terraform) {
		return "Updated Successfully" + terraform.getStack();
	}
}
