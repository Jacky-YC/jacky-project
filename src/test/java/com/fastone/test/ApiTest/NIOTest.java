package com.fastone.test.ApiTest;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class NIOTest {
	
	public static void main(String[] args) {
		
		Path path = Path.of("C:\\log\\a.txt");
		try(FileWriter fw = new FileWriter(path.toFile(),true);) {
			if (!Files.exists(path)) {
				Files.createFile(path);
			}
			StringReader sr = new StringReader("\r\n哈哈aaaads");
			sr.transferTo(fw);
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
