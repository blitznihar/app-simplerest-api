package com.blitznihar.spring.appsimplerestapi.terraform;

public class Terraform {
	private final long id;
    private final String stack;

    public Terraform(long id, String stack) {
        this.id = id;
        this.stack = stack;
    }

    public long getId() {
        return id;
    }

    public String getStack() {
        return stack;
    }
}
