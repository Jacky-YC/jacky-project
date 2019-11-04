package com.fastone.test.event;

public class JackyEventTest {

	public static void main(String[] args) {

		ApplicationContext context = new ApplicationContext();

		context.addApplicationListener(event -> {
			Object source = event.getSource();
			if (source instanceof Integer) {
				int now = (int) source;
				System.out.println("检测到事件源为整型，事件源变为: " + now);
			}
		});

		context.addApplicationListener(event -> {
			Object source = event.getSource();
			if (source instanceof String) {
				String now = (String) source;
				System.out.println("检测到事件源为字符串类型，事件源变为: " + now);
			}
		});

		context.publishEvent(new JackyEvent(1));


	}

}
