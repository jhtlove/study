package division_recursion;
/**
 * 
 * 全排列
 */
//泛型与static：自定义类上声明的泛型，只作用在非静态成员方法上，static要单独声明泛型
public class Permutation <T>
{

	public  void swap(T arr[],int a,int b)
	{
		T temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public  void perm(T arr[],int k,int m)
	{
		//k到m都是前缀，打印，初始值，k=0
		if(k == m)
		{
			//从0到m打印整个序列
			for(int i=0;i<=m;i++)
			{
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		else
		{
			//注意边界检查，如 <= 对吗？
			for(int j=k;j<=m;j++)
			{
				swap(arr,k,j);//j最大值为m，能交换到最后一个元素
				perm(arr,k+1,m);//j<=m,k+1最大值为m+1
//还原到原来的基本数列上，为下一次的j++后做准备
//比如1 2 3,swap后成2 1 3,下一次还是先还原成1,2,3,再1和3交互，而不是直接在2 1 3基础上，2和3交换
//两次都是原数列的1以此与后面的元素交互，这样保证前缀用到了所有元素，不然有可能，你1和5交换后，不还原，后面5把1换回来当前缀，让1的前缀重复排列了
				swap(arr,k,j);
			}
		}
	}
	
	public static void main(String[] args)
	{
		Integer arr[] = {1,2,3};//int 基础数据类型，对泛型,不行
		//String arr[] = {"a","b","c"};
		Permutation<Integer> p = new Permutation<Integer>();//泛型声明在类上，new对象的时候指定泛型类型
		p.perm(arr, 0, arr.length-1);

	}

}
