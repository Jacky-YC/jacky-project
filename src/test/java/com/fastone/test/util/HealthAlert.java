package com.fastone.test.util;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HealthAlert {

	private static final String iconPath = "C:\\Users\\YeCheng\\Desktop\\website\\img\\favicon.ico";

	private static int remaindNum = 0;

	public static void main(String[] args) throws InterruptedException, IOException {

		while (true) {
			Icon icon = new ImageIcon(iconPath);
			int isYes = JOptionPane.showConfirmDialog(null, "Please stand up and move!", "Health remind", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, icon);
			if (isYes == JOptionPane.YES_OPTION) {
				remaindNum = 0;
				TimeUnit.MINUTES.sleep(30L);
			} else {
				remaindNum++;
				if (remaindNum < 3)
					TimeUnit.MINUTES.sleep(3L);
				else {
					JOptionPane.showMessageDialog(null, "Forced rest", "必须休息一下了", JOptionPane.INFORMATION_MESSAGE);
					Runtime.getRuntime().exec("rundll32.exe user32.dll,LockWorkStation");
					remaindNum = 0;
				}
			}
		}
	}

}
