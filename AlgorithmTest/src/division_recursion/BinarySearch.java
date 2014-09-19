package division_recursion;
//二分搜索：递归的，也可用循环while实现
public class BinarySearch
{

	public static int bSearch(int a[],int s,int t,int x)
	{
		if(s > t) return -1;
		int mid = (s + t) / 2;
		if(a[mid] == x) return mid;
		else if(a[mid] > x)
		{
			bSearch(a,s,mid - 1,x);
		}
		else 
			bSearch(a,mid + 1,t,x);
		return -1;//未找到
	}

	
	public static void main(String[] args)
	{
		int a[] = {1,2,3,4,5,7,9,22,38,89};
		System.out.println(bSearch(a,0,a.length-1,6));
	}

}
