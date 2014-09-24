package search;

public class Search
{

	public static int binarySearch(int x,int arr[])
	{
		int high = arr.length - 1;
		int low = 0;
		int mid = 0;
		while(low<=high)
		{
			mid = (low + high) /2;
			if(x == arr[mid])
			{
				return mid;//找到了，就返回了正确的数组下标
			}

			if(x > arr[mid])
			{
				low = mid + 1;
			}
			else
			{
				high = mid - 1;
			}
		}
		return -1;//没找到返回-1
	}
	
	public static int binarySearch(int x,int low ,int high,int arr[])
	{
		int mid = -1;//初始化为没找到，非法位置-1
		if(low <= high)
		{
			mid = (low + high) / 2;
			if(x == arr[mid])
			{
				return mid;//写了等于的情况，可以不写小于的情况，没写等于的情况，就必须写小于的if
			}
			
			 if (x > arr[mid])
			{
				mid = binarySearch(x,mid+1,high,arr);
			}
			 //if (x < arr[mid])
			else
			{
				mid = binarySearch(x,low,mid-1,arr);
			}
		}
		return mid;
	}
	
	public static void main(String[] args)
	{
		int a[] = {1,3,5,7,10,12};
		
		System.out.println(binarySearch(12,0,a.length-1,a));
		
		System.out.println(binarySearch(12,a));
	}

}
