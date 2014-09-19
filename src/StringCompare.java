import org.junit.Test;

/*多次截取短的字符串，多次使用KMP算法
 * *给定一个query和一个text，均由小写字母组成。
 * 要求在text中找出以同样的顺序连续出现在query中的最长连续字母序列的长度。
 * 例如， query为“acbac”，text为“acaccbabb”，那么text中的“cba”为最长的连续出现在query中的字母序列，
 * 因此，返回结果应该为其长度3。请注意程序效率。

 */

public class StringCompare
{
	
	//每次有长度更新，变大了，或者从最长的开始匹配，成了，就停止
	@Test
	public static void compareString(String a,String b)
	{
		char as[] = a.toCharArray();
		char bs[] = b.toCharArray();
		int len = 0;
		if(a.length() >= b.length())
		{
		   len = a.length();	
		}
		else
		{
			len = b.length();	
		}
		char ssa[] = new char[len];
		char ssb[] = new char[len];
		for(int i=0;i<Math.abs(as.length - bs.length);i++)
		{
			for(int j=0;j<len;j++)
			{
				
			}
		}
		
		int indexA = a.length() -1;
		int indexB = 0;
		//i控制移动比较次数
		for(int i=1;i < a.length() + b.length();i++)
		{
			indexA = a.length() -1;
			indexB = 0;
			//控制每次比较个数，注意后移之后，超出边界又变小；需要知道哪个字符串是长的吗？
			for(int j=1;j<=i;j++)
			{
				if(as[indexA] == bs[indexB])
				{
					
				}
			}
		}
	}

	public static void main(String[] args)
	{
		String a = "acbac";
		String b = "acaccbabb";
		
		
	}

}
