package division_recursion;

import java.util.Random;

/***
 * 
 * 线性选择;找到第k大的元素;
 * 如何能划分出两个子数组a1和a2使得a1的每个元素都小于等于a2中的？利用quickSort思想中的position；
 *比一个元素大的都放后面，小的都放前面
 *有重复元素怎么办？
 */
public class LinearSelect
{
	private static Random rad = new Random();
	private static final int  level = 1;
	public static void display(int a[])
	{
		for(int temp:a)
		{
			System.out.print(temp + " ");
		}
		System.out.println();
	}
	
	//找出划分位置
	public static int position(int arr[],int l,int r)
	{
//int temp = arr[rad.nextInt(r-l+1) + l];//nexInt  0=< r < specified value
		int temp = arr[l];
		int left = l;
		int right = r;
		
		
		//里面while条件都带上=temp的，有用！为什么呢？
		//因为等于它还会移动？例如对于【3,3】,如果不加等于，position一直定位在index=1，加了把相同元素当成有大小区别的数
		//如果某一步position没有缩小范围，比如定位在该次搜索的  右边界，或者左边界，randomsizedSelect则会一直递归
		while(left < right)
		{
			//如果arr[0]是最小的元素，遇到它自己还是会停住，不会越界
			while(arr[right] >= temp && left < right)
			{
				right--;
			}
			if(left < right)
			{
				arr[left] = arr[right];
				left++;
			}
			while(arr[left] <= temp && left < right)
			{
				left++;
			}
			if(left < right)
			{
				arr[right] = arr[left];
				right--;
			}
		}
		arr[left] = temp;
		return left;
	}
		
	

	
	private static int randomsizedSelect(int a[],int p,int r,int k)
	{
//System.out.println(p + "-" + r + "找" + k + "个");
		if(p == r) 
		{
			System.out.println("第" + level + "大的元素为： " + a[p]);
			return a[p];
		}
		int i = position(a,p,r);
System.out.println("划分位置：" + i);
		if(i-p+1 >= k)
		{
System.out.println(p + "-" + i + "找" + k + "个");
			return randomsizedSelect(a,p,i,k);//这里不会从[p至i-1]找
		}
		else
		{
			int j = k - (i - p + 1);
System.out.println(i+1 + "-" + r + "找" + j + "个");
			return randomsizedSelect(a,i+1,r,j);
		}
	}
	
	public static void main(String[] args)
	{
		int a[] = {3,3};//不加等于temp，position划分一直指向1，并且randomsizedSelect一直在0-1中找第1大的
		display(a);
		randomsizedSelect(a,0,a.length-1,level);
		display(a);
		
	}

}
