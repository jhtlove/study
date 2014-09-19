package test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression
{

	public static void p(Object o)
	{
		System.out.println(o.toString());
	}
	

	public static void main(String[] args)
	{
		/*String s = "abc";
		p(s.matches("..."));
		Pattern p = Pattern.compile("[a-z]{3}");
		Matcher m = p.matcher("abc");
		p(m.matches());
		p("abc".matches("[a-z]{3}"));*/
		
		//反斜杠比较特殊，正则表达式里面//代表一个/，一个/又是特殊的转移字符
		p("a".matches(".*"));
		p("\\".matches("\\\\"));//true
		
		//POSIX style  \p{Lower}	A lower-case alphabetic character: [a-z]
		
		//空白行 whiteLine
		p("\n".matches("^\\s*\\n$"));
		
		//Pattern ptn = Pattern.compile("[\\w]+@.{3}\\.com|cn");//不能达到匹配com或cn的
		String s = "---@126.com";
		Pattern ptn = Pattern.compile("[\\w]|[.-]+@[\\w]+\\.[\\w]+");
		Matcher m = ptn.matcher(s);
		p(m.matches());
	}

}
