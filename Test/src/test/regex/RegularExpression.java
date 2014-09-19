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
		
		//��б�ܱȽ����⣬������ʽ����//����һ��/��һ��/���������ת���ַ�
		p("a".matches(".*"));
		p("\\".matches("\\\\"));//true
		
		//POSIX style  \p{Lower}	A lower-case alphabetic character: [a-z]
		
		//�հ��� whiteLine
		p("\n".matches("^\\s*\\n$"));
		
		//Pattern ptn = Pattern.compile("[\\w]+@.{3}\\.com|cn");//���ܴﵽƥ��com��cn��
		String s = "---@126.com";
		Pattern ptn = Pattern.compile("[\\w]|[.-]+@[\\w]+\\.[\\w]+");
		Matcher m = ptn.matcher(s);
		p(m.matches());
	}

}
