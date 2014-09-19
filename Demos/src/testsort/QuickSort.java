package testsort;

import org.junit.Test;

public class QuickSort
{


	public static <T> void swap(T a,T b)
	{
		T temp;
		temp = a;
		a = b;
		b = temp;
	}
	
	public static <T> boolean bigger(T a,T b)
	{
		if(a instanceof String)
		{
			String as = (String)a;
			String bs = (String)b;
			if(as.compareTo(bs)>0)
				return true;
		}
		else if(a instanceof Integer)
		{
			int ai = (Integer)a;
			int bi = (Integer)b;
			if(ai > bi)
				return true;
		}
		return false;
	}
	
	public static <T> void quikSort(T arr[],int h,int t)
	{
		////这句话不能少，防止递归时，堆栈溢出；
//放在posit()里用这句没用,因为posit()还是会返回一个值，继续传给m，继续递归下去，不能结束递归。
		if(h>=t) return;//出递归！
		int m = posit(arr,h,t) ;
		quikSort(arr,h,m-1);
		quikSort(arr,m+1,t);
	}
	
//参数设计，比较精髓,因为在同一个数组arr上不断定位，所以需要两个下标参数指定在数组哪段上排序
	public static <T> int posit(T arr[],int h,int t)
	{
		int head = h;
		int tail = t;
		T temp = arr[head];
		while(tail > head)
		{
			while(bigger(arr[tail],temp))
			{
				//防止指针已经到达边界，再++  -- 就出界了;
				//边界不写0 或者arr.length-1，因为递归时拆分成很多小数组，不能再传递arr的长度
				if(tail == head)
					break;
				else
					tail--;
			}
			if(head < tail)
			{
//System.out.print("tail:" + tail + " ");
				arr[head] = arr[tail];
				head++;
			}
			while(bigger(temp,arr[head]))
			{
				if(head == tail)
					break;
				else
					head++;
			}
			if(head < tail)
			{
//System.out.print("head:" + head + " ");
				arr[tail] = arr[head];
				tail--;
			}
		}
		arr[head] = temp;
System.out.println("arr排好了：" + arr[head] + " head：" + head + " tail:" + tail);
		return head;
	}
	
	public static <T> void disArr(T arr[])
	{
		for(T a :arr)
		{
			System.out.print(a + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		String a[] = {"1","5","2","3","9"};
		disArr(a);
		quikSort(a,0,a.length-1);
//System.out.println(posit(a,0,a.length-1));
		disArr(a);
	}

}
