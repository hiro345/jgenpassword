package org.sssg.soft.jgenpassword;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	GenPassword app;
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
		this.app = new GenPassword();
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * check password length
	 */
	public void testPasswordLength8() {
		String pass = app.getPassword(8);
		assertTrue(pass.length() == 8);
	}
	public void testPasswordLength16() {
		String pass = app.getPassword(16);
		assertTrue(pass.length() == 16);
	}
	public void testPassword8NumLength() {
		String pass = app.getPassword(8);
		assertTrue(getNumLength(pass) == 1);
	}
	public void testPassword8CapitalLetterLength() {
		String pass = app.getPassword(8);
		assertTrue(getCapitalLetterLength(pass) == 3);
	}
	public void testPassword8SmallLetterLength() {
		String pass = app.getPassword(8);
		assertTrue(getSmallLetterLength(pass) == 3);
	}
	public void testPassword8SignLength() {
		String pass = app.getPassword(8);
		assertTrue(getSignLength(pass) == 1);
	}
	public void testPassword16NumLength() {
		String pass = app.getPassword(16);
		assertTrue(getNumLength(pass) == 1);
	}
	public void testPassword16CapitalLetterLength() {
		String pass = app.getPassword(16);
		assertTrue(getCapitalLetterLength(pass) == 3);
	}
	public void testPassword16SmallLetterLength() {
		String pass = app.getPassword(16);
		assertTrue(getSmallLetterLength(pass) == 11);
	}
	public void testPassword16SignLength() {
		String pass = app.getPassword(16);
		assertTrue(getSignLength(pass) == 1);
	}
	
	private int getNumLength(String s) {
		int ret = 0;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if ('0' <= c && c<='9') {
				ret++;
			}
		}
		return ret;
	}
	private int getCapitalLetterLength(String s) {
		int ret = 0;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if ('A' <= c && c<='Z') {
				ret++;
			}
		}
		return ret;
	}
	private int getSmallLetterLength(String s) {
		int ret = 0;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if ('a' <= c && c<='z') {
				ret++;
			}
		}
		return ret;
	}
	private int getSignLength(String s) {
		int num = getNumLength(s);
		int cl = getCapitalLetterLength(s);
		int sl = getSmallLetterLength(s);
		int ret = s.length() - (num + cl + sl);
		return ret;
	}
}
