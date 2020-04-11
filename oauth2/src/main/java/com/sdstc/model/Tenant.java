package com.sdstc.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Tenant implements Serializable{
	private static final long serialVersionUID = 1875530964317274753L;
	private Long id;
	private String name;
}
