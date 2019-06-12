package com.fastone.test.util;

public class RandomUtil {

	public static int randomCode() {
		return (int) ((Math.random() * 9 + 1) * 1000000);
	}

	public static void main(String[] args) {
		System.out.println(randomCode());
	}

}
