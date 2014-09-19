package basic_level;

public class StringMatch
{

	private static String str1 = "abcdacdd";
	private static String str2 = "acdd";
	
	public int maxMatch()
	{
		String s1 = str1;
		String s2 = str2;
		
		char ss1[] = s1.toCharArray();
		char ss2[] = s2.toCharArray();
		char temp1 [];
		char temp2 [];
		String indx1 = "";
		String indx2 = "";
		int max = 0;
		if(ss1.length > ss2.length)
		{
			temp1 = ss1;
			indx1 = s1;
			temp2 = ss2;
			indx2 = s2;
		}
		else
		{
			temp1 = ss2;
			temp2 = ss1;
			indx1 = s2;//s1 和 temp1指向长的字符串
			indx2 = s1;
		}
		for(int i=0;i<indx1.length();i++)
		{
			int count = 0;
			for(int j=0;j<indx2.length();j++)
			{
				if(i+j < s1.length())
				{
					if(temp1[j+i] == temp2[j])
					{
						count++;
					}
				}
				else
					break;
			}
			if(count > max)
			{
				max = count;
			}
			
		}
		
		
		return max;
	}
	
	public static void main(String[] args)
	{
		System.out.println(new StringMatch().maxMatch());
	}

}
