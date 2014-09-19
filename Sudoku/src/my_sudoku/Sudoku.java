package my_sudoku;

/***
 * ������Ϸ �ؼ�����β����н�����־����㷨�Ŀ���չ�ԣ����εݹ飿��
 * 
 */
public class Sudoku
{
	private int size;// 9 * 9 ��������ϷsizeΪ3,subArr��size�����һ����һ��Ԫ�ظ��� 3 * 3 = 9 ��
	private SubDiamonds sudoku[][] = null;// ����
	public static final Sudoku instance = new Sudoku();

	// [��¼�������е�λ�ú�Ԫ��] ��i,j,num��?
	public Sudoku()
	{
		size = 1;
	}

	public int getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	// ����һ������֮�󣬼�¼��Ӱ������У��Լ��ӿ�
	public void affected()
	{

	}

	// ����һ����ʽ���������֡����ȴ������ң����ϵ��£�������������
	public void fillNum()
	{

	}

	// ����һ���յ�����
	public void create()
	{
		sudoku = new SubDiamonds[this.size][this.size];// ����������������

		for (int i = 0; i < this.size; i++)
		{
			for (int j = 0; j < this.size; j++)
			{
				sudoku[i][j] = new SubDiamonds(this.size);// ÿ������������һ��SubDiamond���󣬶���Ҫnew
			}
		}
	}

	// ��ӡ��Ӧ������С�ĺ���
	public void disLine()
	{
		for (int i = 0; i < this.size * this.size; i++)
		{
			System.out.print("���� ");
		}
		System.out.println();
	}

	//�жϵ� n��������,n: 0��size*size-1��;�����������ӿ��⣬��ô���Ƿ������Ѿ����޳���
	public boolean inRow(int n)
	{
		int temRow[] = new int[size*size];//��С����һ�����������������temRow��
		int c = 0;
		
		for(int j=0;j<size;j++)
		{
			int temSubRow[] = sudoku[n/size][j].getOneRow(n%size);
			for(int i = 0;i<temSubRow.length;i++)
			{
				temRow[c] = temSubRow[i];
				c++;
			}
		}
		
		boolean b[] = new boolean[size*size];
		for(int i=0;i<b.length;i++)
		{
			b[i] = false;
		}
		
		for(int i=0;i<temRow.length;i++)
		{
			if(b[temRow[i]] == false)
			{
				b[temRow[i]] = true; 
			}
			else
				return false;//һ�������ظ�����
		}

		return true;
	}
	//�жϵ� n��������,n: 0��size*size-1��;
	public boolean inLine(int n)
	{
		int temLine[] = new int[size*size];//��С����һ�����������������temRow��
		int c = 0;
		
		for(int i=0;i<size;i++)
		{
			int temSubLine[] = sudoku[i][n/size].getOneLine(n%size);
			for(int j = 0;j<temLine.length;j++)
			{
				temLine[c] = temSubLine[j];
				c++;
			}
		}
		
		boolean b[] = new boolean[size*size];
		for(int i=0;i<b.length;i++)
		{
			b[i] = false;
		}
		
		for(int i=0;i<temLine.length;i++)
		{
			if(b[temLine[i]] == false)
			{
				b[temLine[i]] = true; 
			}
			else
				return false;//һ�������ظ�����
		}

		return true;
	}

	// �����������9�У�9���Ƿ�������ȷ��k: 0��size*size-1 ��/��
	public boolean checkRowAndLine()
	{
		for (int k = 0; k < size * size; k++)
		{
			if(!inRow(k)||!inLine(k))
			{
				return false;
			}
		}
		return true;

	}

	// ��ӡ��������
	public void display()
	{
		int k = 0;// ��ӡ�ӷ����k��
		for (int i = 0; i < sudoku.length; i++)
		{
			for (k = 0; k < this.sudoku[0][0].size; k++)
			{
				for (int j = 0; j < sudoku[i].length; j++)
				{
					sudoku[i][j].disOneRow(k);
				}
				System.out.println();
			}
			disLine();
		}

	}

	public static void main(String[] args)
	{
		instance.setSize(3);
		instance.create();
		instance.display();
	}

}

// �ӷ���
class SubDiamonds
{
	int size;// ���� �ӷ��� 3 * 3��size�͵���3
	int subArr[][];// ��ά���飬��ʾ�ӷ���

	SubDiamonds()
	{
		size = 3;
		subArr = new int[size][size];// �ڴ����������Ҳ�����˵ڶ�ά�Ŀռ䣬����ֻ�������ˣ�
	}

	SubDiamonds(int size)
	{
		this.size = size;
		subArr = new int[size][size];
	}

	// �ж�ĳ��Ԫ���Ƿ��ڷ������棬Ҳ�������ж�������Ƿ���Ա�����˷�����
//	public boolean inSubArr(int k)
//	{
//		int i, j;
//		for (i = 0; i < this.subArr.length; i++)
//		{
//			for (j = 0; j < this.subArr[i].length; j++)
//			{
//				if (k == this.subArr[i][j])
//					return true;
//			}
//		}
//		return false;
//	}

	// �жϸ����Ƿ�����(���n*n����С1��û���ظ�,�������жϣ�)
	public boolean isSubIntact()
	{
		boolean b[] = new boolean[size*size];
		for(int i=0;i<b.length;i++)
		{
			b[i] = false;
		}
		
		for (int i = 0; i < this.subArr.length; i++)
		{
			for (int j = 0; j < this.subArr[i].length; j++)
			{
				if (1 <= this.subArr[i][j] && size*size >= this.subArr[i][j])
				{
					if(b[this.subArr[i][j]-1] == false)
					{
						b[this.subArr[i][j]-1] = true;
					}
					else
					{
						return false;//�ظ�����
					}
				}
				else
					return false;//�Ƿ�����
			}
		}
		//û�зǷ����֣���û���ظ����������ˣ����ݳ���ԭ����Ȼ������ȷ��
//		for(int i=0;i<b.length;i++)
//		{
//			if(b[i] == false)
//				return false;//������
//		}
		return true;
		
		
//		for (int k = 1; k <= size * size; k++)
//		{
//			if (!inSubArr(k))
//				return false;
//		}
//		return true;
	}
	
	//��ȡС����ĵ�k�У�����һ������
	public int[] getOneRow(int k)
	{
		int temp[] = new int[this.subArr[0].length];
		for (int i = 0; i < this.subArr[k].length; i++)
		{
			temp[i] = subArr[k][i];
		}
		return temp;
	}
	
	////��ȡС����ĵ�k�У�����һ������
	public int[] getOneLine(int k)
	{
		int temp[] = new int [size];
		for(int i=0;i<size;i++)
		{
			temp[i] = subArr[i][k];
		}
		return temp;
	}

	// ��ʾһ��С����ĵ�k��
	public void disOneRow(int k)
	{
		for (int i = 0; i < this.subArr[k].length; i++)
		{
			System.out.print(this.subArr[k][i] + "  ");
		}
		System.out.print("|");
	}
}
