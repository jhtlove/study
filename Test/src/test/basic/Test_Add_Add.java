package test.basic;

public class Test_Add_Add
{

	public static int f(int n)
	{
		System.out.println(n);
		return n;
	}

	public static void main(String[] args)
	{
		int i = 5;
		f(i++);//ֻ�ܱ���++
		System.out.println(i);
		f(++i);
		//f(++f(i));//���ܷ���ֵ++������ֵ���Ǳ����ˣ�ֻ��һ��ֵ
		byte b = (byte)128;//127���У�128��Ҫǿ������ת����
		System.out.println(b);//��� -128 

	}

}
