import org.junit.Test;

/*��ν�ȡ�̵��ַ��������ʹ��KMP�㷨
 * *����һ��query��һ��text������Сд��ĸ��ɡ�
 * Ҫ����text���ҳ���ͬ����˳������������query�е��������ĸ���еĳ��ȡ�
 * ���磬 queryΪ��acbac����textΪ��acaccbabb������ôtext�еġ�cba��Ϊ�������������query�е���ĸ���У�
 * ��ˣ����ؽ��Ӧ��Ϊ�䳤��3����ע�����Ч�ʡ�

 */

public class StringCompare
{
	
	//ÿ���г��ȸ��£�����ˣ����ߴ���Ŀ�ʼƥ�䣬���ˣ���ֹͣ
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
		//i�����ƶ��Ƚϴ���
		for(int i=1;i < a.length() + b.length();i++)
		{
			indexA = a.length() -1;
			indexB = 0;
			//����ÿ�αȽϸ�����ע�����֮�󣬳����߽��ֱ�С����Ҫ֪���ĸ��ַ����ǳ�����
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
