package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;


public class StringUtilTest {
	public static void main(String[] args) {
		String str = "111";
		str = StringUtils.rightPad(str, 10, "0");
		System.out.println(str);
		List<String> strList = new ArrayList<>();
		strList.add("1");
		strList.add("145");
		strList.add("15467");
		strList.add("112312");
		Collections.sort(strList);
		System.out.println(strList);
	}
}
