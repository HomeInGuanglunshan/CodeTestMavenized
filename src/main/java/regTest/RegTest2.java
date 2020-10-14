package regTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest2 {

	public static void main(String[] args) {
		String regex = "\\w+@\\w+\\.(com\\.cn)|\\w+@\\w+\\.(com|cn)";
		Pattern pattern = Pattern.compile(regex);
		String context = "checkhere1@hotmail.com   ;checkhere2@hotmail.com;sdfkfj@sfsdf65656.com.cn "
				+ ";jfkdjgkjhgk@jdfjkg.cn.cn ;sadfsd@sdfsd.cn";
		Matcher matcher = pattern.matcher(context);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}

	}
}
