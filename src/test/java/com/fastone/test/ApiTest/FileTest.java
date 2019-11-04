package com.fastone.test.ApiTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileTest {

	private String[] data;

	public FileTest(String[] data) {
		this.data = data;
	}


	class UseFile extends FileTest {

		private String header;

		public UseFile(String header, String[] values) {
			super(data);
			this.header = header;
		}

		public void test() {
			System.out.println(super.data);
		}

	}

	public void main(String[] args) {
		String[] arr = {};
		new FileTest.UseFile("header",arr).test();
	}

}