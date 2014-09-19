package division_recursion;

/***
 * 
 * 快速排序
 *
 */
public class QuickSort
{
	
//	public static void swap(int a,int b)
//	{
//		int temp = a;
//		a = b;
//		b = temp;
//	}

	//找出划分位置
	public static int position(int arr[],int l,int r)
	{
		int temp = arr[l];
		int left = l;
		int right = r;
//这里排序都不带等于temp 也没关系？,因为quickSort 会从分段-1 和 +1的位置开始递归，index有变化
		while(left < right)
		{
			//如果arr[0]是最小的元素，遇到它自己还是会停住，不会越界
			while(arr[right] > temp && left < right)
			{
				right--;
			}
			if(left < right)
			{
				arr[left] = arr[right];
				left++;
			}
			//拿到最大的元素?
			while(arr[left] < temp && left < right)
			{
				left++;
			}
			if(left < right)
			{
				arr[right] = arr[left];
				right--;
			}
		}
		arr[left] = temp;//排好一个元素
		return left;
	}
	
	public static void quickSort(int arr[],int left,int right)
	{
		if(left > right) return;
		int mid = position(arr,left,right);//mid不能是固定的
		quickSort(arr,left,mid-1);
		quickSort(arr,mid+1,right);
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
		int a[] = {4,4,4,4};
		display(a);
//position(a,1,7);
		quickSort(a,0,a.length-1);
		display(a);
	}

}

/***
 * 另外一个quickSort代码
 */
//public class QuickSort
//{
//
//
//	public static <T> void swap(T a,T b)
//	{
//		T temp;
//		temp = a;
//		a = b;
//		b = temp;
//	}
//	
//	public static <T> boolean bigger(T a,T b)
//	{
//		if(a instanceof String)
//		{
//			String as = (String)a;
//			String bs = (String)b;
//			if(as.compareTo(bs)>0)
//				return true;
//		}
//		else if(a instanceof Integer)
//		{
//			int ai = (Integer)a;
//			int bi = (Integer)b;
//			if(ai > bi)
//				return true;
//		}
//		return false;
//	}
//	
//	public static <T> void quikSort(T arr[],int h,int t)
//	{
//		////这句话不能少，防止递归时，堆栈溢出；
////放在posit()里用这句没用,因为posit()还是会返回一个值，继续传给m，继续递归下去，不能结束递归。
//		if(h>t) return;//出递归！
//		int m = posit(arr,h,t) ;
//		quikSort(arr,h,m-1);
//		quikSort(arr,m+1,t);
//	}
//	
////参数设计，比较精髓,因为在同一个数组arr上不断定位，所以需要两个下标参数指定在数组哪段上排序
//	public static <T> int posit(T arr[],int h,int t)
//	{
//		int head = h;
//		int tail = t;
//		T temp = arr[head];
//		while(tail > head)
//		{
//			while(bigger(arr[tail],temp))
//			{
//				//防止指针已经到达边界，再++  -- 就出界了;
//				//边界不写0 或者arr.length-1，因为递归时拆分成很多小数组，不能再传递arr的长度
//				if(tail == head)
//					break;
//				else
//					tail--;
//			}
//			if(head < tail)
//			{
////System.out.print("tail:" + tail + " ");
//				arr[head] = arr[tail];
//				head++;
//			}
//			while(bigger(temp,arr[head]))
//			{
//				if(head == tail)
//					break;
//				else
//					head++;
//			}
//			if(head < tail)
//			{
////System.out.print("head:" + head + " ");
//				arr[tail] = arr[head];
//				tail--;
//			}
//		}
//		arr[head] = temp;
//System.out.println("arr排好了：" + arr[head] + " head：" + head + " tail:" + tail);
//		return head;
//	}
//	
//	public static <T> void disArr(T arr[])
//	{
//		for(T a :arr)
//		{
//			System.out.print(a + " ");
//		}
//		System.out.println();
//	}
//	
//	public static void main(String[] args)
//	{
//		String a[] = {"1","5","2","3","9"};
//		disArr(a);
//		quikSort(a,0,a.length-1);
////System.out.println(posit(a,0,a.length-1));
//		disArr(a);
//	}
//
//}

