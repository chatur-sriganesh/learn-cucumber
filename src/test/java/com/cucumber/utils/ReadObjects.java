package com.cucumber.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReadObjects {
	static ArrayList<String> LIST_OF_SCREENS = new ArrayList<String>();

	public static void readLocatorPropertyFile() {
		File folder = new File("src/test/resources/Screens");

		File[] files = folder.listFiles();

		System.out.println("Available Screens files with locators: ");
		for (File file : files) {
			LIST_OF_SCREENS.add(file.getPath());
			System.out.println(file);
		}

	}

	public static String getLocatorValueFromProperties(String element, String screenName) {
		for (String screen : LIST_OF_SCREENS) {
			if (screen.contains(screenName)) {
				ResourceBundle bundle = ResourceBundle.getBundle("Screens/" + screenName);
				return bundle.getObject(element).toString();

			}
		}
		return null;
	}
}
