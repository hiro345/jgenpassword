package org.sssg.soft.jgenpassword;

/**
 * jgenpassword app class
 * 
 */
public class App {
	public static void main(String[] args) {
		GenPassword app = new GenPassword();
		System.out.println(app.getPassword(8));
	}
}
