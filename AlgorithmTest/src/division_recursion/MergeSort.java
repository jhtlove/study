package division_recursion;
/***
 * 
 * ��·�鲢����
 *
 */
public class MergeSort
{
	//������aԪ��copy��b����
	public static boolean copyArr(int a[],int b[])
	{
		if(a.length > b.length) return false;
		for(int i=0;i<a.length;i++)
		{
			b[i] = a[i];
		}
		return true;
	}

	//a,b�������У����Ҳ��������
	public static int[] merge(int arr[],int left,int right)
	{
		//left == rightһ��Ԫ�أ����úϲ���
		if(left < right)
		{
			//ֻ���Ƹôδ��ϲ���Ԫ���в��У� �У�������b���ƶ����±������ı䣬ÿ�ζ��Ǵ�0��ʼ
			int b[] = new int[right-left+1];
			for(int i=left,j=0;i<=right;i++,j++)
			{
				b[j] = arr[i];
			}
//			int b[] = new int[arr.length];
//			copyArr(arr,b);
//			int mid = (left + right) / 2;
//			//��b��ȡ���Ƚϣ��ϲ��ṹ�ŵ�arr��
//			int l = left;
//			int m = mid + 1;//
//			int k = left;//k�Ǵ˴�arr�ϴ��ϲ�Ԫ�ص���ʼλ�ã�����ÿ�ζ���0��ʼ��
			int l = 0;
			int r = b.length-1;//��¼�ұ߽�
			int mid = (0 + r) / 2;//��¼��߽�
			int m = mid + 1;//���Σ���ʼλ��Ҫ����
			int k = left;//k�Ǵ˴�arr�ϴ��ϲ�Ԫ�ص���ʼλ�ã�����ÿ�ζ���0��ʼ��
			while(l <= mid && m <= r)
			{
				//�е��ڣ�����ȡǰ����еģ������������ȶ���
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
		return arr;//���ã��ı��˴�����������arr�ϵ�Ԫ������
		
	}
	
	public static void mergeSort(int arr[],int head,int tail)
	{
		if(head < tail)
		{
			int mid = (head + tail) / 2;
			mergeSort(arr,head,mid);
			mergeSort(arr,mid+1,tail);
//System.out.print(head + "-" + tail + "mergeǰ: ");
//display(arr);
			merge(arr,head,tail);
//System.out.print(head + "-" + tail + "merge��: ");
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
		int a[] = {801,1001,801,825};//ǰ��Σ����Σ���������
		display(a);
		mergeSort(a,0,a.length-1);
		display(a);
	}

}
