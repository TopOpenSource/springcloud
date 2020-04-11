package com.sdstc.system.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Customer implements Serializable{
	private static final long serialVersionUID = 1875530964317274753L;
	private Long id;
	private String name;
}
