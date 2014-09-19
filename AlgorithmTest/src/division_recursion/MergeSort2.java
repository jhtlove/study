package division_recursion;
/***
 * 
 * 自然合并排序，扫描一趟，找有有序段;边界检测处理是难点！！！ 还有bug……
 *
 */
public class MergeSort2
{ 
	//合并a上a1至a2与a2 + 1至a3,存入b的 【a1 - a3】
	public static void merge(int a[],int a1,int a2,int a3)
	{
		int b[] = new int[a.length];
		int index1 = a1;
		int index2 = a2 + 1;
		int k = a1;
		while(index1 <= a2 && index2 <= a3)
		{
			if(a[index1] <= a[index2])
			{
				b[k] = a[index1];
				k++;
				index1++;
			}
			else
			{
				b[k] = a[index2];
				k++;
				index2++;
			}
		}
		while(index1 <= a2)
		{
			b[k] = a[index1];
			k++;
			index1++;
		}
		while(index2 <= a3)
		{
			b[k] = a[index2];
			k++;
			index2++;
		}
		
		//合并后结果复制回a
		for(int i=a1;i<=a3;i++)
		{
			a[i] = b[i];
		}
	}
	//非递归合并
	public static void scanAndSort(int a[])
	{
		if(a.length <= 1)return;
		int a1 = 0,a2 = 0;
		//a1 = a2 = 3;声明的时候不能用连等，这样可以
		int i = 0;
		while(a[i] < a[i+1])
		{
			i++;
			if(i == a.length -1) return;//已经全部有序了
		}
		a2 = i;//记录前一段
		i++;//开始下一段，++后会有可能指向最后一个元素了
		//注意边界检测！！！
//万一后面只剩下一个元素没得比较了,下面第一个while将不会执行
		boolean b = false;//检测有没有合并到最后一个元素,没剩下最后一个落单的，就是true
//		if(i == a.length - 1)
//		{
//			b = false;
//		}
		while((i < a.length-1))
		{
			
			while(a[i] < a[i+1])
			{
				i++;//外层循环已经管不到i了，即使i超值了
				if(i == a.length - 1)
				{
					b = true;//合并完了
					break;
				}
			}
			
			merge(a,a1,a2,i);//有没有可能一次merge完？
			a2 = i;//a2指向合并好的新的这段
			i++;//开始下一段
		}
		//当i 指向最后剩下的一个元素,没得喝最后一个元素比较
		if(i == a.length - 1 && b == false)
		{
			merge(a,a1,a2,i);//专门为最后一个元素merge一下
		}
	}
	
	public static void display(int a[])
	{
		for(int temp:a)
		{
			System.out.print(temp + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args)
	{
		int a[] = {801,1001,801,825};
		display(a);
		scanAndSort(a);
		display(a);
	}

}
