package huawei.basic.string.execise;

import java.io.*;
import java.util.*;
public class LastWord
{

	public static void main(String[] args)
	{
		BufferedInputStream is = new BufferedInputStream(System.in);
		String s1 = is.toString();
		//Scanner sca = new Scanner(System.in);
		//String s1 = sca.nextLine();
		String ss [] = s1.split(" ");
		System.out.println(ss[ss.length-1].length());
	}

}
