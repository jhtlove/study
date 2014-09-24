package sort;

import java.util.ArrayList;
import java.util.Random;

public class Sort
{

	public static Random r = new Random();

	// public static transient ArrayList<String> arr = new
	// ArrayList<String>();//��̬ transient
	// static int n;
	// public static int a[] = new int [n];//��̬�����飬nҲ����Ҫ��̬�Ĳ�����

	// static long l = 88888l;
	// static float f = 0.12f;
	//
	/**
	 * �����򣬽���С���ѡ� 0-len�Ǵ����������飬kָ��ôα����������ĸ����
	 */

	public static void adjustDown(int arr[], int len, int k)
	{
		// f = l;
		int temp = arr[k];

		for (int i = 2 * k + 1; i <= len; i = 2 * i + 1)
		{
			// ֻ���Һ��Ӵ��ڣ����Һ�������С�Ľ�㣬��ô�Ż�ı�̽��ָ��i�ķ��򡣣�iһֱָ������������ĺ��ӽ����ֵ��С�Ľ�㣬Ϊ��С���ѵ�Ŀ�꣩
			if (i < len && arr[i] > arr[i + 1])
			{
				i++;
			}
			if (temp <= arr[i])
			{
				break;//Ҫôbreak������Ҫôk����������
			}
			else
			{
				arr[k] = arr[i];
				k = i;// kһֱָ����һ��ѭ���������������� �ĸ����
			}
		}
		arr[k] = temp;// ��������kָ��û����ֱ��break������û�м������µ���
	}

	// ��������Ҫ������ʼ�ѣ���k��0λ�ã��������µ�������Ȼ���ó��Ѷ����Զѵ�ɾ�������Ӹ��ƻ��˶����ʣ��ִӸ����µ���һ�μ��ɡ�
	// �ԶѵĲ��룺�½����ڶѵ�ĩ�ˣ��ƻ��������������Ķ����ʣ������ϵ�����ĳһ�η��϶ѵ����ʼ���
	public static void heapSort(int arr[], int len)
	{
		// ���ѭ�������˳�ʼ��
		for (int i = (len - 1) / 2; i >= 0; i--)
		{

			adjustDown(arr, len, i);
			// Sort.disArr(arr);
		}
		int temp = 0;
		for (int index = len; index >= 0;)
		{
			temp = arr[0];
			arr[0] = arr[index];
			arr[index] = temp;
			// System.out.println(arr[index] + " ");
			// Sort.disArr(arr);
			index--;
			adjustDown(arr, index, 0);// �̶����������ĸ���ʼ���µ���
		}

	}

	// ��С���ѵĲ��룬������Ҫ���ϵ���--AdjustUp
	public static void insertHeap(int arr[], int k)
	{

		// kΪ�������λ��
		int index = k;
		int temp = arr[index];// n+1ָ���·����Ԫ��
		while ((index - 1) / 2 >= 0 && temp < arr[(index - 1) / 2])
		{
			arr[index] = arr[(index - 1) / 2];// �����Ԫ�ظ�С���ͰѸ��ڵ�ֵ�ŵ��ӽڵ���ȥ
			index = (index - 1) / 2;// Ĭ�ϸ��ڵ�ֵ��temp�����ˣ�һֱ��tempȥ�͸����������ĸ�������ȥ�Ƚ�
			if (index == 0)
				break;// ��Ҫ�ڸ���ȦȦ����1��2����0���Ͳ�����
		}
		arr[index] = temp;
	}

	// �������ϵ�����������ʼ�ѡ�
	// һ�߲��ϲ���Ԫ�أ�һ���Եף�k�����ϣ�0������һ�Ρ�
	public static void heapSort(int arr[])
	{
		// ��ֱ�Ӳ��뷨��˼ά��һ�����������У��������ϵ�����������ʼ��
		for (int i = 0; i <= arr.length - 1; i++)
		{
			insertHeap(arr, i);
		}

		// ����Ҫ�õ����µ�����������л����������Ϊֻ�жѶ�Ԫ�ؾ��С�������ԣ�����Ѷ�Ԫ�أ��Ӷ��ƻ��˶ѵĽṹ����Ȼ��Ҫ���µ�����
		int temp = 0;
		for (int index = arr.length - 1; index >= 0;)
		{
			temp = arr[0];
			arr[0] = arr[index];
			arr[index] = temp;
			// System.out.println(arr[index] + " ");
			// Sort.disArr(arr);
			index--;
			adjustDown(arr, index, 0);
		}
	}

	public static void selectSort(int a[])
	{
		int i = 0, j = 0;
		// int restMin = 0;
		int index = 0;
		int temp = 0;
		// �ӵ�0��λ��ѡ��Ԫ�ص��ڵ����ڶ���λ�ã����ֻʣһ��Ԫ�أ��Ͳ���ѡ��λ����
		for (i = 0; i < a.length - 1; i++)
		{
			// restMin = a[i];//Ϊ�ҵ���ֵ��׼��;ʣ��λ���е���Сֵ
			index = i;// �����ȳ�ʼ��Ϊ��ǰλ��,��Ϊ��ֵ���ܾ��ǵ�ǰλ�õ�Ԫ����
			// jָ����Ƚϵ�Ԫ��
			for (j = i + 1; j < a.length; j++)
			{
				// a[index]ֵ�Ǳ仯�ģ���indexָ��ʣ��λ���е���Сֵ
				if (a[j] < a[index])
				{
					// restMin = a[j];//restMin������Сֵ
					index = j;// ��¼��ֵ��λ�ã�ͬʱa[index]��ȻҲ��¼����ֵ�Ĵ�С
				}
			}
			// swap ������Сֵ�͵�ǰλ��Ԫ�ص�ֵ
			if (index != i)
			{
				temp = a[i];
				a[i] = a[index];
				a[index] = temp;
			}

		}
	}

	// �ϲ����У���midλ�õķ�ǰ��ͺ�Σ���Ӱ��midȡֵ�ļ��㣬�Լ��߽�Ŀ��ơ�
	public static void merge(int a[], int left, int mid, int right)
	{
		if (left >= right)
			return;

		int index1 = 0;// �α�ָ��ϲ��е�һ��[0 �� mid-left-1]�����ָ��
		int index2 = mid - left;// �α�ָ��ϲ��е���һ��[mid-left- right - left]
		int k = left;// ָ��ϲ������е�λ��,���ָ��

		// ��a��ȡԭ���ݣ� ��b�Ϻϲ����ٰ����ս�������ԭ��������a������copy���ݵ�b���Ѻϲ�����ֱ�Ӹ��ǵ�a��
		int b[] = new int[right - left + 1];

		for (int i = 0; i < right - left + 1; i++)
		{
			b[i] = a[left + i];
		}

		while (index1 <= mid - left - 1 && index2 <= right - left)
		{
			if (b[index1] <= b[index2])
			{
				a[k++] = b[index1++];
			}
			else
			{
				a[k++] = b[index2++];
			}
		}

		while (index1 <= mid - left - 1)
		{
			a[k++] = b[index1++];// û�м����ģ�����
		}
		while (index2 <= right - left)
		{
			a[k++] = b[index2++];
		}
	}

	public static void mergeSort(int a[], int left, int right)
	{
		if (left >= right)
			return;
		int mid = (left + right) / 2 + 1;
		mergeSort(a, left, mid - 1);
		mergeSort(a, mid, right);
		merge(a, left, mid, right);

	}

	/**
	 * 
	 * ��������֮ð�����򣬽����������
	 */
	public static void bubbleSort(int a[])
	{
		int i = 0, j = 0, temp = 0;
		boolean swaped = false;
		// i������������n��Ԫ������������n-1��
		for (i = 0; i < a.length - 1; i++)
		{
			swaped = false;
			// jָ����������У�ÿһ�˽�һ�����������е����Ԫ�طŵ������е���󡣻���j+1������ע��߽����
			for (j = 0; j < a.length - i - 1; j++)
			{
				if (a[j] > a[j + 1])
				{
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					swaped = true;
				}
			}
			if (swaped == false)
			{
				return;// ����������ֹͣ����
			}
		}
	}

	/**
	 * ��������֮��������
	 */

	// public static int partition2(int a[], int left, int right)
	// {
	// // int index = left + r.nextInt(right-left+1);
	// int value = a[left];
	// // System.out.println(left + " -- " + right + " ��׼Ԫ���� : a[" +index +
	// // "]=" + a[index]);
	// while (left < right)
	// {
	// // ��������ֵ��Ԫ������Ļ���߻��ұ߶�û�й�ϵ��ֻҪ��֤С����������ߣ������������ұ�
	// while (a[left] <= value && left < right)
	// left++;
	//
	// while (a[right] >= value && left < right)
	// right--;
	//
	// if (left < right)
	// {
	// // swapǰ������Ԫ�أ������Ѿ����ܱ�֤��ʱ���±�ֵ�������������
	// int temp = a[left];
	// a[left] = a[right];
	// a[right] = temp;
	// left++;
	// right--;
	// }
	// }
	// // a[left] = value;
	// Sort.disArr(a);
	// System.out.println("��������ֵ������λ�ã����λ�ã��ǣ� " + left);
	// return left;
	// }

	public static int partition(int a[], int left, int right)
	{
		// ��׼Ԫ�ص�ѡ����ڿ�����������Ӱ��ϴ�index
		int index = left + r.nextInt(right - left + 1);// ���ѡ��׼Ԫ�أ������ŵ�a[left]�ڱ�λ�ã�Ȼ���right��ʼɨ�裬������ȷ��
		/**
		 * a[0]���ڱ�����֤�ˣ��Ӻ�ɨ�裬������Ԫ��һ�����Ըû�׼Ԫ��Ϊ�����࣡û������ֱ���Թ���Ԫ�أ�Ҳһ���Ǵ�������Ҳࡣ
		 * һ��Ҫ��������һ�����ƽ�����Ԫ�ص�����λ��
		 * ��������λ���λ�ã��ؼ��Ϳ�������ô��С������Ԫ��ֵ�ķŵ�������ߣ���������Ԫ��ֵ�ķŵ������ұ�
		 * �����ڿ�һ��λ�õİ취Ҳ�ã���swap���뷨Ҳ��
		 * ����Ĵ�������ξ���ʵ�ֵ��أ�����ʹ��˫����������ͷָ���βָ�룬�����½�㣩��ͷ���֮ǰ����С�ģ���β���֮�������
		 */
		// if(index > right || index < left)
		// {
		// System.out.println("ERROR index");
		// }
		// else
		// {
		// System.out.println(left + " -- " + right + " ��׼Ԫ���� : a[" +index +
		// "]=" + a[index]);
		// }
		// int index = (left + right) / 2;
		int value = a[index];// ��value�����˵�ǰѡȡ������Ԫ�أ��Ϳ��ڿ�һ��λ��

		// һ��������Ԫ�ؽ���������ߣ��ŵ�����ʹ�right��ʼ��⣬���Ҿ�Ӧ�ô�left��ʼ��⣩��ʹ���ڿյ�λ�ô�����������������λ�ñƽ���������һ��ʼ�ʹ�����Ԫ�ص���ʼλ�ÿ�ʼ�ƶ�

		int temp = a[left];
		a[left] = a[index];
		a[index] = temp;

		//
		while (left < right)
		{
			// �Ƚ��д��Ⱥţ�����ظ�Ԫ���磺4��3��4�����ָ��Ż��ƶ�����Ȼ����ѭ����

			// �����Ҳ࿪ʼ��⣬����4,9��ѡ��9��value��ֱ�ӿ�ʼright--�Ͳ���
			while (left < right && a[right] >= value)
			{
				right--;
			}
			a[left] = a[right];
			// index = right;
			// if(left < right)
			// {
			// //������Ҫ�Ƚ�һ��left��right�Ƿ��غϣ������Լ���ֵ���Լ��Ƚϣ�ָ���ƶ�һ�Σ�Ч����û�иĽ�
			// left++;
			// }
			// left++;//���󡣵�left��rightָ���غ�ʱ����仰ִ�оͲ��ԣ�ǿ�ƵĶ����һ�Σ��غ�֮ǰ���ǶԵ�
			while (left < right && a[left] <= value)
			{
				left++;
			}
			a[right] = a[left];
			// index = left;
			// if(left < right)
			// {
			// //������Ҫ�Ƚ�һ��left��right�Ƿ��غϣ������Լ���ֵ���Լ��Ƚϣ�ָ���ƶ�һ�Σ�Ч����û�иĽ�
			// right--;
			// }
		}
		// ��Ȼleft==right��
		a[left] = value;
		// System.out.println(" ���ֵ�(��Ԫ������λ��)�� " + left);
		return left;
	}

	public static void quikSort(int a[], int left, int right)
	{
		if (left >= right)
			return;
		int p = partition(a, left, right);
		quikSort(a, left, p - 1);
		quikSort(a, p + 1, right);
	}

	/**
	 * ֱ�Ӳ������򣬽��Ϊ����
	 * 
	 * @param a
	 */
	public static void insertSort(int a[])
	{
		int i = 0, j = 0, temp = 0;
		//���ֻ��һ��Ԫ�أ�����forѭ��������ִ�У�Ҳ�ԡ�
		for (i = 1; i <= a.length-1; i++)
		{
			//a[0] = a[i];// a[0]���ڱ���ʵ�ʲ����������Ͳ��ܽ�a[0]��Ŵ������Ԫ�أ���̫�ʺ�ʵ�ʱ��ʵ��
			temp = a[i];
			// iָ��������Ԫ�أ��ӵڶ�����ʼ��̽�������ǰһ��С����Ҫ����
			//���������Ԫ�ء�3,1����Ҳ��
			if (a[i] < a[i - 1])
			{
				// �ҵ����ʵĲ���λ�ã�jָ���Ѿ�����Ķ�;�ڱ���֤ ���j==1ʱ�� һ����ͣ����
				j = i - 1;
				//��Ȼ�ܽ������if���棬��ôwhile�е�������һ�ο϶��ǳ����ģ�����Ųһ�£�����ʹ����do����while�����
				while (temp < a[j] && j>=0)
				{
					a[j + 1] = a[j];
					j--;
				}
				a[j + 1] = temp;
			}
		}
	}
//����ָ�룬һ��ָ�������Ԫ�أ�һ��ָ���Ѿ��ź��������
	public static void insertSort(int a[], int left, int right)
	{
		int i = 0, j = 0, temp = 0;
		// i ָ��������Ԫ�ء�ʵ��Ӧ��ʱ�����Ǵ������left = 0��right = a.lenght-1��
		for (i = left + 1; i <= right; i++)
		{
			// ���������Ԫ����Ҫ��ǰ���룬�Ͳ��Ϻ��ƶ�Ԫ�أ��������Ҫ����ʲô������ֱ�ӿ�����һ��Ԫ��
			if (a[i] < a[i - 1])
			{
				temp = a[i];// temp�����˴������Ԫ��
				j = i - 1;// jָ����֮ǰ�Ѿ�����Ķ�
				do
				{
					a[j + 1] = a[j];
					j--;

				} while (j >= left && temp < a[j]);
				a[j + 1] = temp;// ����temp
			}
		}
	}

	public static void binaryInsertSort(int arr[],int left,int right)
	{
		int i=0,j=0,temp=0,high = 0,low=0,middle=0;
		for(i=left+1;i<=right;i++)
		{
			temp = arr[i];
			low = left;
			high = i-1;
			while(low<=high)
			{
				middle = (low+high)/2;
				if(temp < arr[middle])
				{
					high = middle - 1;
				}
				else
				{
					low = middle + 1;
				}
			}
			for(j=i-1;j>=low;j--)
			{
				arr[j+1] = arr[j];
			}
			arr[low] = temp;
		}
	}
	
	public static void disArr(int a[])
	{
		int i = 0;// java�У�������for�е�int i ���������ֻ��for��
		for (i = 0; i < a.length - 1; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println(a[i]);
	}

	public static void main(String[] args)
	{
		int a[] = { 9, 14, 4, 46, 9, 10 };
		// System.out.println(-1 / 2);//��0��ӡҲ��0
		Sort.disArr(a);
		// Sort.bubbleSort(a);
		// Sort.quikSort(a, 0, a.length-1);
		// Sort.mergeSort(a, 0, a.length - 1);
		// Sort.selectSort(a);
		// Sort.heapSort(a, a.length - 1);//����С���ѣ���С�ķź��棬������������ǽ��������ˡ�
		Sort.heapSort(a);// ����С���ѣ���С�ķź��棬������������ǽ��������ˡ�
		Sort.disArr(a);
		// System.out.println(Integer.toHexString(15));//��ӡ�������ǲ����16���Ƶ�0xǰ׺
		// test(1);
		// test(a[0]);
		// test(Integer.valueOf(3));
		// short i = -3;
		// System.out.println( -3 >>> 1);
		// System.out.println(-0x8000 < 0);
		// System.out.print(Math.pow(2, 15));
	}

	// public static void test(int d)
	// {
	//
	// System.out.println("int: " + d);
	// }
	//
	// public static void test(double d)
	// {
	// System.out.println("double: " + d);
	// }
	//
	// public static void test(Integer i)
	// {
	// System.out.println("Integer: " + i.intValue());
	// }
}
