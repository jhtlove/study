package compress_matrix;

import java.util.ArrayList;

/**
 * 压缩矩阵：多个相同元素只分配一个空间，零元素不分配空间。节省存储空间，更有效地存储在内存空间。
 * 特殊矩阵：不用二维数组，用一维数组存放；关键是找到矩阵元素小标i，j和在一维数组中下标k的关键  
 * （多维数组映射方法：按行优先，按列优先）
 * 稀疏矩阵：用三元组存放
 *
 */

//三元组结构
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
		String ss[][] = new String[i+1][j+1];//注意边界，小标范围0 - n-1
		
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
