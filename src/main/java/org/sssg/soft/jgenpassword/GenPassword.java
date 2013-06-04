package org.sssg.soft.jgenpassword;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenPassword {
	private static char[] signs = { '!', '"', '#', '$', '%', '&', '\'', '(',
			')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?',
			'@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~', };

	public String getPassword(int n) {
		if (n < 8) {
			n = 8;
		}
		return getPassword(1, 1, 3, n - 5);
	}

	public String getPassword(int s, int n, int A, int a) {
		if (s < 0) s = 0;
		if (n < 0) n = 0;
		if (A < 0) A = 0;
		if (a < 0) a = 0;
		int length = s + n + A + a;
		if (length < 8) {
			s = 1;
			n = 1;
			A = 3;
			a = 3;
		}
		SecureRandom random = new SecureRandom();
		byte seed[] = random.generateSeed(20);
		random.setSeed(seed);

		List<Character> pw = new ArrayList<Character>();
		for (int i = 0; i < s; i++) {
			pw.add(signs[random.nextInt(signs.length)]);
		}
		for (int i = 0; i < n; i++) {
			pw.add((char) ('0' + random.nextInt(10)));
		}
		for (int i = 0; i < A; i++) {
			pw.add((char) ('A' + random.nextInt(26)));
		}
		for (int i = 0; i < a; i++) {
			pw.add((char) ('a' + random.nextInt(26)));
		}
		Collections.shuffle(pw);

		char[] pass = new char[pw.size()];
		for (int i = 0; i < pass.length; i++) {
			pass[i] = pw.get(i);
		}
		return new String(pass);
	}
}
