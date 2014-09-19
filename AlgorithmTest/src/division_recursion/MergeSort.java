package division_recursion;
/***
 * 
 * 二路归并排序
 *
 */
public class MergeSort
{
	//把数组a元素copy到b里面
	public static boolean copyArr(int a[],int b[])
	{
		if(a.length > b.length) return false;
		for(int i=0;i<a.length;i++)
		{
			b[i] = a[i];
		}
		return true;
	}

	//a,b升序排列，最后也升序排列
	public static int[] merge(int arr[],int left,int right)
	{
		//left == right一个元素，不用合并了
		if(left < right)
		{
			//只复制该次待合并的元素行不行？ 行，就是在b上移动的下标有所改变，每次都是从0开始
			int b[] = new int[right-left+1];
			for(int i=left,j=0;i<=right;i++,j++)
			{
				b[j] = arr[i];
			}
//			int b[] = new int[arr.length];
//			copyArr(arr,b);
//			int mid = (left + right) / 2;
//			//在b上取数比较，合并结构放到arr上
//			int l = left;
//			int m = mid + 1;//
//			int k = left;//k是此次arr上待合并元素的起始位置，不是每次都从0开始！
			int l = 0;
			int r = b.length-1;//记录右边界
			int mid = (0 + r) / 2;//记录左边界
			int m = mid + 1;//后半段，起始位置要定对
			int k = left;//k是此次arr上待合并元素的起始位置，不是每次都从0开始！
			while(l <= mid && m <= r)
			{
				//有等于，优先取前半段中的，所以排序是稳定的
				if(b[l] <= b[m])
				{
					arr[k] = b[l];
					l++;
				}
				else
				{
					arr[k] = b[m];
					m++;
				}
				k++;
			}
			while(l <= mid)
			{
				arr[k] = b[l];//
				k++;
				l++;
			}
			while(m <= r)
			{
				arr[k] = b[m];
				k++;
				m++;
			}
		}
		return arr;//引用，改变了传进来的数组arr上的元素排序
		
	}
	
	public static void mergeSort(int arr[],int head,int tail)
	{
		if(head < tail)
		{
			int mid = (head + tail) / 2;
			mergeSort(arr,head,mid);
			mergeSort(arr,mid+1,tail);
//System.out.print(head + "-" + tail + "merge前: ");
//display(arr);
			merge(arr,head,tail);
//System.out.print(head + "-" + tail + "merge后: ");
//display(arr);
		}
	}
	
	public static void display(int arr[])
	{
		for(int a : arr)
		{
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		int a[] = {801,1001,801,825};//前半段，后半段，各自有序
		display(a);
		mergeSort(a,0,a.length-1);
		display(a);
	}

}
