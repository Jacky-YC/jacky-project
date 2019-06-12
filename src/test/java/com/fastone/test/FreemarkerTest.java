package com.fastone.test;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.Cleanup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FreemarkerTest {

	@Autowired
	private Configuration cfg;

	@Test
	public void aaa() throws IOException, TemplateException {

		Map<String,String> root = new HashMap<>();
		root.put("user","jacky");
		root.put("password","123456");
		root.put("email","176@163.com");
		root.put("name","jacky666");

		String fileName = "UserCreatedContent.ftl";

		System.out.println(getContent(root, fileName));

	}

	private String getContent(Map map, String fileName) {
		Writer writer = null;
		try {
			Template template = cfg.getTemplate(fileName);
			writer = new StringWriter();
			template.process(map,writer);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return writer.toString();
	}


}
