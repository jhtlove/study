package sort;

import java.util.ArrayList;
import java.util.Random;

public class Sort
{

	public static Random r = new Random();

	// public static transient ArrayList<String> arr = new
	// ArrayList<String>();//动态 transient
	// static int n;
	// public static int a[] = new int [n];//静态的数组，n也必须要静态的才能行

	// static long l = 88888l;
	// static float f = 0.12f;
	//
	/**
	 * 堆排序，建立小顶堆。 0-len是待调整的数组，k指向该次被调整子树的根结点
	 */

	public static void adjustDown(int arr[], int len, int k)
	{
		// f = l;
		int temp = arr[k];

		for (int i = 2 * k + 1; i <= len; i = 2 * i + 1)
		{
			// 只有右孩子存在，且右孩子又是小的结点，那么才会改变探索指针i的方向。（i一直指向待调整子树的孩子结点中值较小的结点，为了小顶堆的目标）
			if (i < len && arr[i] > arr[i + 1])
			{
				i++;
			}
			if (temp <= arr[i])
			{
				break;//要么break出来，要么k继续往下走
			}
			else
			{
				arr[k] = arr[i];
				k = i;// k一直指向，下一轮循环，待调整的子树 的父结点
			}
		}
		arr[k] = temp;// 待调整的k指针没动，直接break出来，没有继续向下调整
	}

	// 堆排序，先要建立初始堆（从k到0位置，反复向下调整），然后拿出堆顶（对堆的删除），从根破坏了堆性质，又从根往下调整一次即可。
	// 对堆的插入：新结点放在堆的末端，破坏了最下面子树的堆性质，故向上调整到某一次符合堆的性质即可
	public static void heapSort(int arr[], int len)
	{
		// 这个循环建立了初始堆
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
			adjustDown(arr, index, 0);// 固定从整个树的根开始向下调整
		}

	}

	// 对小顶堆的插入，插入需要向上调整--AdjustUp
	public static void insertHeap(int arr[], int k)
	{

		// k为插入结点的位置
		int index = k;
		int temp = arr[index];// n+1指向新放入的元素
		while ((index - 1) / 2 >= 0 && temp < arr[(index - 1) / 2])
		{
			arr[index] = arr[(index - 1) / 2];// 插入的元素更小，就把父节点值放到子节点中去
			index = (index - 1) / 2;// 默认父节点值与temp交换了，一直拿temp去和父辈，父辈的父辈……去比较
			if (index == 0)
				break;// 不要在根兜圈圈！减1除2，在0处就不动了
		}
		arr[index] = temp;
	}

	// 利用向上调整，建立初始堆。
	// 一边不断插入元素，一边自底（k）向上（0）调整一次。
	public static void heapSort(int arr[])
	{
		// 用直接插入法的思维，一个个点插入堆中，利用向上调整，建立初始堆
		for (int i = 0; i <= arr.length - 1; i++)
		{
			insertHeap(arr, i);
		}

		// 还是要用到向下调整，输出序列或进行排序，因为只有堆顶元素具有“最”的特性，输出堆顶元素，从顶破坏了堆的结构，自然需要向下调整。
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
		// 从第0个位置选定元素到第倒数第二个位置，最后只剩一个元素，就不用选定位置了
		for (i = 0; i < a.length - 1; i++)
		{
			// restMin = a[i];//为找到最值做准备;剩下位置中的最小值
			index = i;// 必须先初始化为当前位置,因为最值可能就是当前位置的元素嘛
			// j指向待比较的元素
			for (j = i + 1; j < a.length; j++)
			{
				// a[index]值是变化的，用index指向剩下位置中的最小值
				if (a[j] < a[index])
				{
					// restMin = a[j];//restMin保存最小值
					index = j;// 记录最值的位置，同时a[index]自然也记录了最值的大小
				}
			}
			// swap 交换最小值和当前位置元素的值
			if (index != i)
			{
				temp = a[i];
				a[i] = a[index];
				a[index] = temp;
			}

		}
	}

	// 合并段中，把mid位置的放前后和后段，会影响mid取值的计算，以及边界的控制。
	public static void merge(int a[], int left, int mid, int right)
	{
		if (left >= right)
			return;

		int index1 = 0;// 游标指向合并中的一段[0 到 mid-left-1]，检测指针
		int index2 = mid - left;// 游标指向合并中的另一段[mid-left- right - left]
		int k = left;// 指向合并后序列的位置,存放指针

		// 在a中取原数据， 在b上合并，再把最终结果保存回原来的数组a；或者copy数据到b，把合并后结果直接覆盖到a上
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
			a[k++] = b[index1++];// 没有检测完的，复制
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
	 * 交换排序之冒泡排序，结果升序排列
	 */
	public static void bubbleSort(int a[])
	{
		int i = 0, j = 0, temp = 0;
		boolean swaped = false;
		// i，控制趟数，n个元素排序，最多进行n-1趟
		for (i = 0; i < a.length - 1; i++)
		{
			swaped = false;
			// j指向待排序序列，每一趟将一个待排序列中的最大元素放到该序列的最后。会有j+1，所以注意边界控制
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
				return;// 本趟无逆序，停止处理
			}
		}
	}

	/**
	 * 交换排序之快速排序
	 */

	// public static int partition2(int a[], int left, int right)
	// {
	// // int index = left + r.nextInt(right-left+1);
	// int value = a[left];
	// // System.out.println(left + " -- " + right + " 基准元素是 : a[" +index +
	// // "]=" + a[index]);
	// while (left < right)
	// {
	// // 等于枢轴值的元素在轴的或左边或右边都没有关系，只要保证小于它的在左边，大于它的在右边
	// while (a[left] <= value && left < right)
	// left++;
	//
	// while (a[right] >= value && left < right)
	// right--;
	//
	// if (left < right)
	// {
	// // swap前后两个元素；但是已经不能保证此时的下标值还在枢轴的两侧
	// int temp = a[left];
	// a[left] = a[right];
	// a[right] = temp;
	// left++;
	// right--;
	// }
	// }
	// // a[left] = value;
	// Sort.disArr(a);
	// System.out.println("本次枢轴值的最终位置（轴的位置）是： " + left);
	// return left;
	// }

	public static int partition(int a[], int left, int right)
	{
		// 基准元素的选择对于快速排序性能影响较大；index
		int index = left + r.nextInt(right - left + 1);// 随机选基准元素，把它放到a[left]哨兵位置，然后从right开始扫描，才是正确的
		/**
		 * a[0]当哨兵，保证了，从后扫描，被调换元素一定再以该基准元素为轴的左侧！没调换，直接略过的元素，也一定是处于轴的右侧。
		 * 一定要从最两侧一步步逼近枢轴元素的最终位置
		 * 快速排序定位轴的位置，关键就看你是怎么把小于枢轴元素值的放到枢轴左边，大于枢轴元素值的放到枢轴右边
		 * ；用腾空一个位置的办法也好，有swap的想法也好
		 * ，你的代码是如何具体实现的呢？考虑使用双向链表，设置头指针和尾指针，（拔下结点）在头结点之前插入小的，在尾结点之后插入大的
		 */
		// if(index > right || index < left)
		// {
		// System.out.println("ERROR index");
		// }
		// else
		// {
		// System.out.println(left + " -- " + right + " 基准元素是 : a[" +index +
		// "]=" + a[index]);
		// }
		// int index = (left + right) / 2;
		int value = a[index];// 用value保存了当前选取的枢轴元素，就可腾空一个位置

		// 一定把枢轴元素交换至最左边（放到最左就从right开始检测，最右就应该从left开始检测），使得腾空的位置从最边上向枢轴的真正位置逼近！而不是一开始就从枢轴元素的起始位置开始移动

		int temp = a[left];
		a[left] = a[index];
		a[index] = temp;

		//
		while (left < right)
		{
			// 比较中带等号，针对重复元素如：4，3，4，检测指针才会移动，不然就死循环了

			// 先让右侧开始检测，对于4,9；选了9当value，直接开始right--就不对
			while (left < right && a[right] >= value)
			{
				right--;
			}
			a[left] = a[right];
			// index = right;
			// if(left < right)
			// {
			// //这样需要比较一次left和right是否重合；与它自己的值和自己比较，指针移动一次；效果上没有改进
			// left++;
			// }
			// left++;//错误。当left与right指针重合时，这句话执行就不对，强制的多加了一次！重合之前都是对的
			while (left < right && a[left] <= value)
			{
				left++;
			}
			a[right] = a[left];
			// index = left;
			// if(left < right)
			// {
			// //这样需要比较一次left和right是否重合；与它自己的值和自己比较，指针移动一次；效果上没有改进
			// right--;
			// }
		}
		// 必然left==right了
		a[left] = value;
		// System.out.println(" 划分点(该元素最终位置)： " + left);
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
	 * 直接插入排序，结果为升序
	 * 
	 * @param a
	 */
	public static void insertSort(int a[])
	{
		int i = 0, j = 0, temp = 0;
		//如果只有一个元素，整个for循环都不会执行，也对。
		for (i = 1; i <= a.length-1; i++)
		{
			//a[0] = a[i];// a[0]是哨兵。实际操作起来，就不能将a[0]存放待排序的元素，不太适合实际编程实现
			temp = a[i];
			// i指向带插入的元素，从第二个开始试探，如果比前一个小，就要插入
			//如果就两个元素【3,1】，也对
			if (a[i] < a[i - 1])
			{
				// 找到合适的插入位置，j指向已经有序的端;哨兵保证 最多j==1时， 一定会停下来
				j = i - 1;
				//既然能进入这个if里面，那么while中的条件第一次肯定是成立的，至少挪一下，所以使用用do……while更简洁
				while (temp < a[j] && j>=0)
				{
					a[j + 1] = a[j];
					j--;
				}
				a[j + 1] = temp;
			}
		}
	}
//两个指针，一个指向待插入元素，一个指向已经排好序的序列
	public static void insertSort(int a[], int left, int right)
	{
		int i = 0, j = 0, temp = 0;
		// i 指向待排序的元素。实际应用时：就是传入参数left = 0，right = a.lenght-1；
		for (i = left + 1; i <= right; i++)
		{
			// 如果带排序元素需要往前插入，就不断后移动元素；如果不需要，就什么不做，直接考察下一个元素
			if (a[i] < a[i - 1])
			{
				temp = a[i];// temp保存了待插入的元素
				j = i - 1;// j指向了之前已经有序的段
				do
				{
					a[j + 1] = a[j];
					j--;

				} while (j >= left && temp < a[j]);
				a[j + 1] = temp;// 插入temp
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
		int i = 0;// java中，定义在for中的int i ，作用域就只在for中
		for (i = 0; i < a.length - 1; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println(a[i]);
	}

	public static void main(String[] args)
	{
		int a[] = { 9, 14, 4, 46, 9, 10 };
		// System.out.println(-1 / 2);//负0打印也是0
		Sort.disArr(a);
		// Sort.bubbleSort(a);
		// Sort.quikSort(a, 0, a.length-1);
		// Sort.mergeSort(a, 0, a.length - 1);
		// Sort.selectSort(a);
		// Sort.heapSort(a, a.length - 1);//建立小根堆，把小的放后面，在数组里面便是降序排列了。
		Sort.heapSort(a);// 建立小根堆，把小的放后面，在数组里面便是降序排列了。
		Sort.disArr(a);
		// System.out.println(Integer.toHexString(15));//打印出来还是不会带16进制的0x前缀
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
