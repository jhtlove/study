package list_reverse;

public class ReverseArray
{
	static int  arr[ ] = {1,2,3,5,6,8,4}; 
	
	//传递形参，还是可以修改ReverseArray.arr元素内容。
	public static void resArray(int a[])
	{
		for(int i=0;i<a.length/2;i++)
		{
			int k = a[i];
			a[i] = a[a.length-1-i];
			a[a.length-1-i] = k;
		}
	}
	
	public static void main(String[] args)
	{
		for(int j=0;j<ReverseArray.arr.length;j++)
		{
			System.out.print(arr[j] + " ") ;
		}
		resArray(ReverseArray.arr);
		System.out.println();
		for(int j=0;j<ReverseArray.arr.length;j++)
		{
			System.out.print(arr[j] + " ") ;
		}

	}

}
