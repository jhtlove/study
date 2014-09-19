package division_recursion;

/***
 * 
 * ��������
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

	//�ҳ�����λ��
	public static int position(int arr[],int l,int r)
	{
		int temp = arr[l];
		int left = l;
		int right = r;
//�������򶼲�������temp Ҳû��ϵ��,��ΪquickSort ��ӷֶ�-1 �� +1��λ�ÿ�ʼ�ݹ飬index�б仯
		while(left < right)
		{
			//���arr[0]����С��Ԫ�أ��������Լ����ǻ�ͣס������Խ��
			while(arr[right] > temp && left < right)
			{
				right--;
			}
			if(left < right)
			{
				arr[left] = arr[right];
				left++;
			}
			//�õ�����Ԫ��?
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
		arr[left] = temp;//�ź�һ��Ԫ��
		return left;
	}
	
	public static void quickSort(int arr[],int left,int right)
	{
		if(left > right) return;
		int mid = position(arr,left,right);//mid�����ǹ̶���
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
 * ����һ��quickSort����
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
//		////��仰�����٣���ֹ�ݹ�ʱ����ջ�����
////����posit()�������û��,��Ϊposit()���ǻ᷵��һ��ֵ����������m�������ݹ���ȥ�����ܽ����ݹ顣
//		if(h>t) return;//���ݹ飡
//		int m = posit(arr,h,t) ;
//		quikSort(arr,h,m-1);
//		quikSort(arr,m+1,t);
//	}
//	
////������ƣ��ȽϾ���,��Ϊ��ͬһ������arr�ϲ��϶�λ��������Ҫ�����±����ָ���������Ķ�������
//	public static <T> int posit(T arr[],int h,int t)
//	{
//		int head = h;
//		int tail = t;
//		T temp = arr[head];
//		while(tail > head)
//		{
//			while(bigger(arr[tail],temp))
//			{
//				//��ָֹ���Ѿ�����߽磬��++  -- �ͳ�����;
//				//�߽粻д0 ����arr.length-1����Ϊ�ݹ�ʱ��ֳɺܶ�С���飬�����ٴ���arr�ĳ���
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
//System.out.println("arr�ź��ˣ�" + arr[head] + " head��" + head + " tail:" + tail);
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

