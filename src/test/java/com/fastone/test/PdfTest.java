package com.fastone.test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PdfTest {

	public static void main(String[] args) {
/*
		// 小驼峰
		System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTAT_NAME"));
		// 大驼峰
		System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "ConSTAT_NAME"));
*/

//		Files.append();
		try {
			List<String> all = Files.readAllLines(Paths.get("C:\\Users\\YeCheng\\Documents\\jacky.txt"));
			System.out.println(all);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
