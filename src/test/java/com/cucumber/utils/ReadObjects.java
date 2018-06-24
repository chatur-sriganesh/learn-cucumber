package com.cucumber.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;

public class ReadObjects {
	static ArrayList<String> LIST_OF_SCREENS = new ArrayList<String>();
	HashMap<String, String> LOCATIOR_MAPPING = new HashMap<>();

	public static String readLocatorPropertyFile(String element, String screenName, WebDriver driver) {
		File folder = new File("src/test/resources/Screens");

		File[] files = folder.listFiles();

		for (File file : files) {
			LIST_OF_SCREENS.add(file.getPath());
		}
		System.out.println("All Screen file names: " + LIST_OF_SCREENS);
		for (String screen : LIST_OF_SCREENS) {
			if (screen.contains(screenName)) {
				ResourceBundle bundle = ResourceBundle.getBundle("Screens/" + screenName);
				return bundle.getObject(element).toString();

			}
		}
		return screenName;

	}

	// public static void loadAllScreenNames() {
	public static void main(String[] args) {

		ResourceBundle bundle = ResourceBundle.getBundle("Screens/HomePage");
		System.out.println(bundle.getObject("signin").toString());

		File folder = new File("src/test/resources/Screens");

		File[] files = folder.listFiles();

		for (File file : files) {
			LIST_OF_SCREENS.add(file.getPath());
		}
		System.out.println("All Screen file names: " + LIST_OF_SCREENS);
		for (String screen : LIST_OF_SCREENS) {
			if (screen.contains("login")) {
			}
		}
	}
}
