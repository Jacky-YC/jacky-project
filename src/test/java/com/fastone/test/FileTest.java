package com.fastone.test;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class FileTest {
	private static Logger logger = LoggerFactory.getLogger("scheduler");
	
	public static void main(String[] args) {
		String logPath = "C:\\fastone\\users\\admin\\jobs\\job-1\\log-1\\scheduler.log";
		String message = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").format(new Date(System.currentTimeMillis())) +" : Child Job "+1+" cancelled due to exceeding maximum retries";
		logRecord(logPath,message);
	}
	
	private static void logRecord(String logPath,String message){
		
		try(FileWriter writer = new FileWriter(logPath,true);) {
			writer.write(message);
		} catch (IOException e) {
			log.info("writing scheduler log happen IOException : {}",e.getMessage());
		}
	}
	
}
