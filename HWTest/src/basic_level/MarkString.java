package basic_level;

import java.nio.Buffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkString
{

	public static String MarkNum(String pInStr)
	{
		//char ss[] = pInStr.toCharArray();
		//int index[] = new int[ss.length];
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = null;
		String newStr = "";
		String s = "*";
		for(int i=0;i<pInStr.length();i++)
		{
			m = p.matcher(pInStr.charAt(i) + "");
			if(m.matches())
			{
				newStr += s;
			}
			newStr +=  pInStr.charAt(i);
			
		}
		
		
		return newStr;
		
	}
	
	public static void main(String[] args)
	{
		System.out.println(MarkNum("1erqw3s4l66"));

	}

}
