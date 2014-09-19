package my_sudoku;

/***
 * 数独游戏 关键是如何产生有解的数字矩阵？算法的可扩展性（分治递归？）
 * 
 */
public class Sudoku
{
	private int size;// 9 * 9 的数独游戏size为3,subArr的size和这个一样大，一行元素个数 3 * 3 = 9 个
	private SubDiamonds sudoku[][] = null;// 数独
	public static final Sudoku instance = new Sudoku();

	// [记录在数独中的位置和元素] 【i,j,num】?
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

	// 填入一个数字之后，记录被影响的行列，以及子块
	public void affected()
	{

	}

	// 按照一定方式，填入数字。优先从左至右，从上到下，依次填入数字
	public void fillNum()
	{

	}

	// 创建一个空的数独
	public void create()
	{
		sudoku = new SubDiamonds[this.size][this.size];// 这样创建数独对吗？

		for (int i = 0; i < this.size; i++)
		{
			for (int j = 0; j < this.size; j++)
			{
				sudoku[i][j] = new SubDiamonds(this.size);// 每个里面存的又是一个SubDiamond对象，对象要new
			}
		}
	}

	// 打印相应数独大小的横线
	public void disLine()
	{
		for (int i = 0; i < this.size * this.size; i++)
		{
			System.out.print("—— ");
		}
		System.out.println();
	}

	//判断第 n行完整性,n: 0到size*size-1行;假如先运行子块检测，那么，非法数字已经被剔除了
	public boolean inRow(int n)
	{
		int temRow[] = new int[size*size];//把小数组一行提出来，放入数组temRow中
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
				return false;//一行中有重复数字
		}

		return true;
	}
	//判断第 n列完整性,n: 0到size*size-1列;
	public boolean inLine(int n)
	{
		int temLine[] = new int[size*size];//把小数组一行提出来，放入数组temRow中
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
				return false;//一行中有重复数字
		}

		return true;
	}

	// 检查数独整个9行，9列是否完整正确；k: 0到size*size-1 行/列
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

	// 打印整个数独
	public void display()
	{
		int k = 0;// 打印子方块第k行
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

// 子方块
class SubDiamonds
{
	int size;// 对于 子方块 3 * 3，size就等于3
	int subArr[][];// 二维数组，表示子方块

	SubDiamonds()
	{
		size = 3;
		subArr = new int[size][size];// 内存分析：这样也创建了第二维的空间，还是只是声明了？
	}

	SubDiamonds(int size)
	{
		this.size = size;
		subArr = new int[size][size];
	}

	// 判断某个元素是否在方块里面，也可用来判断这个数是否可以被填入此方块中
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

	// 判断格子是否完整(最大n*n，最小1，没有重复,这样来判断？)
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
						return false;//重复数字
					}
				}
				else
					return false;//非法数字
			}
		}
		//没有非法数字，又没有重复，又填满了，根据抽屉原理，必然完整正确了
//		for(int i=0;i<b.length;i++)
//		{
//			if(b[i] == false)
//				return false;//不完整
//		}
		return true;
		
		
//		for (int k = 1; k <= size * size; k++)
//		{
//			if (!inSubArr(k))
//				return false;
//		}
//		return true;
	}
	
	//获取小方块的第k行，返回一个数组
	public int[] getOneRow(int k)
	{
		int temp[] = new int[this.subArr[0].length];
		for (int i = 0; i < this.subArr[k].length; i++)
		{
			temp[i] = subArr[k][i];
		}
		return temp;
	}
	
	////获取小方块的第k列，返回一个数组
	public int[] getOneLine(int k)
	{
		int temp[] = new int [size];
		for(int i=0;i<size;i++)
		{
			temp[i] = subArr[i][k];
		}
		return temp;
	}

	// 显示一个小方块的第k行
	public void disOneRow(int k)
	{
		for (int i = 0; i < this.subArr[k].length; i++)
		{
			System.out.print(this.subArr[k][i] + "  ");
		}
		System.out.print("|");
	}
}
