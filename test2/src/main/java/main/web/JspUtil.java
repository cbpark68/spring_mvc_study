package main.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

public final class JspUtil {

	public static boolean CheckDate(String date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false);
			sdf.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public static String left(String str, int length) {
		String leftStr = null;
		if (str.length() < length) {
			length = str.length();
		}
		leftStr = str.substring(0, length);
		return leftStr;
	}

	public static String right(String str, int length) {
		String rightStr = null;
		if (str.length() < length) {
			length = str.length();
		}
		rightStr = str.substring(str.length() - length);
		return rightStr;
	}

}
