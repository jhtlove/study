package compress_matrix;

import java.util.ArrayList;

/**
 * ѹ�����󣺶����ͬԪ��ֻ����һ���ռ䣬��Ԫ�ز�����ռ䡣��ʡ�洢�ռ䣬����Ч�ش洢���ڴ�ռ䡣
 * ������󣺲��ö�ά���飬��һά�����ţ��ؼ����ҵ�����Ԫ��С��i��j����һά�������±�k�Ĺؼ�  
 * ����ά����ӳ�䷽�����������ȣ��������ȣ�
 * ϡ���������Ԫ����
 *
 */

//��Ԫ��ṹ
class Triad
{
	int i,j;
	String value;
	
	Triad()
	{
		i = 0;
		j = 0;
		value = null;
	}

	public Triad(int i, int j, String value)
	{
		super();
		this.i = i;
		this.j = j;
		this.value = value;
	}
	
	
}

public class CompressMatrix
{
	
	private static String strs[][] = {
			{"a","",""},
			{"","","cd"},
			{"s","bj",""},
			{"","","123"}
	};

	public static ArrayList<Triad> creatTriad(String s[][])
	{
		int i,j;
		ArrayList<Triad> thr = new ArrayList<Triad>();
		for(i=0;i<s.length;i++)
		{
			for(j=0;j<s[i].length;j++)
			{
				if(s[i][j] != null)
				{
					thr.add(new Triad(i,j,s[i][j]));
				}
			}
		}
		return thr;
	}
	
	public static void reMatrix(ArrayList<Triad> thr)
	{
		int i = thr.get(thr.size()-1).i, j = 0;
		
		int k = 0;
		while(k < thr.size())
		{
			if(thr.get(k).j > j)
			{
				j = thr.get(k).j;
			}
			k++;
		}
		String ss[][] = new String[i+1][j+1];//ע��߽磬С�귶Χ0 - n-1
		
		k = 0;
		while(k < thr.size())
		{
			ss[thr.get(k).i][thr.get(k).j] = thr.get(k).value;
			k++;
		}
		for(int a=0;a<ss.length;a++)
		{
			for(int b=0;b<ss[a].length;b++)
			{
				System.out.print(ss[a][b] + " | ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		
		reMatrix(creatTriad(strs));
		
	}

}
