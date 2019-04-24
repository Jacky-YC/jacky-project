package com.fastone.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3845610317257158405L;
	private String field;
	private String operator;
	private Object value;


}
