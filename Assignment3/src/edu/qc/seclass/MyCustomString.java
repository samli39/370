package edu.qc.seclass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyCustomString implements MyCustomStringInterface {
	private String word = null;

	@Override

	public String getString() {
		// TODO Auto-generated method stub
		return word;
	}

	@Override
	public void setString(String string) {
		// TODO Auto-generated method stub
		word = string;
	}

	@Override
	/**
	 * using Pattern and matcher to find out the number of digit in string
	 */
	public int countNumbers() {
		// TODO Auto-generated method stub
		if (word == null)
			throw new NullPointerException("there is empty string");
		if (word == "")
			return 0;
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(word);
		int num = 0;
		while (m.find()) {
			num++;
		}
		return num;
	}

	@Override
	/**
	 * check if it is from start of end create a string for store character if
	 * it is from start, start from the nth position and then i+n until of out
	 * bound,then store the ith character in string if is t from end, start with
	 * length-n position and i-n; then reverse the string order
	 */
	public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
		// TODO Auto-generated method stub
		String string = "";
		if (word == null && n > 0)
			throw new NullPointerException("there is no string");
		if (n <= 0)
			throw new IllegalArgumentException("nth can not less than or equal to 0");
		if (word == "" || word.length() < n)
			return string;
		int length = word.length();
		if (!startFromEnd) {
			for (int i = n - 1; i <= length - 1; i += n) {
				string += word.charAt(i);
			}
		} else {
			for (int i = length - n; i >= 0; i -= n) {
				string += word.charAt(i);
			}
			String temp = "";
			for (int i = string.length() - 1; i >= 0; i--) {
				temp += string.charAt(i);
			}
			string = temp;
		}

		return string;
	}

	@Override
	public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
		// TODO Auto-generated method stub
		String temp = "";
		if (startPosition > endPosition)
			throw new IllegalArgumentException("endPosition can not larger");
		if (startPosition <= endPosition && (startPosition) < 1 || endPosition > word.length())
			throw new MyIndexOutOfBoundsException(
					"the startPosition cannot smaller than 1 and the endPosition cannnot greater than "
							+ word.length());
		if (startPosition <= endPosition && startPosition > 0 && endPosition > 0 && word == null)
			throw new NullPointerException("point to the null pointer");
		for (int i = 0; i < word.length(); i++) {
			char digit = word.charAt(i);
			if (i >= startPosition - 1 && i < endPosition) {
				switch (digit) {
				case '0':
					temp += "Zero";
					break;
				case '1':
					temp += "One";
					break;
				case '2':
					temp += "Two";
					break;
				case '3':
					temp += "Three";
					break;
				case '4':
					temp += "Four";
					break;
				case '5':
					temp += "Five";
					break;
				case '6':
					temp += "Six";
					break;
				case '7':
					temp += "Seven";
					break;
				case '8':
					temp += "Eight";
					break;
				case '9':
					temp += "Nine";
					break;
				default:
					temp += digit;
				}
			} else
				temp += digit;
		}
		word = temp;
	}

}
