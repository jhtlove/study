package generic;

//ʹ���Զ��巺�ͷ�ת������������
public class Reverse
{

	public <T> void  reverseArray(T[]arr)
	{
		T temp;
		for(int i=0;i<arr.length/2;i++)
		{
			temp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = temp;
		}
	}
	
	public <T> void disArr(T[]arr)
	{
		for(T a: arr)
		{
			System.out.print(a + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		String arr[];
		arr = new String[3];//����ռ�
//arr = {"abc","123c"};//����д���У�Array constants can only be used in initializers
		arr[0] = "abc";
		arr[1] = "123go!";
		arr[2] = "Hello";
		Reverse r = new Reverse();
		r.disArr(arr);
		r.reverseArray(arr);
		r.disArr(arr);
	}

}
