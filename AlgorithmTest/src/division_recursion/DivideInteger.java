package division_recursion;
//������
public class DivideInteger
{
	public static final int max = 5;//��󻮷���
    public static final int resouceInt = 5;//���ֽ��ԭ��
	public static void divideInt(int n,int m,String s)
	{
		if(n<1 || m<1)
		{
			return;
		}
		//�ֽ�Ϊȫ1���,�ҵ�ǰ���ֽ���Ϊn�Ŵ�ӡ ��Ϊʲô����Ҫ�ˣ�
//		if(m == 1)
//		{
//			for(int i=0;i<m;i++)
//				System.out.print("1");
//		}
//System.out.println("(" + n + "," + m + ")");
//		if(n == resouceInt)
//		{
//		}
		if(m < n)
		{
			
			System.out.print(s + m + " + ");
			divideInt(n-m,m,s + m + " + ");//����������m�Ļ���
			divideInt(n,m-1,s);//������С��m�Ļ���
			
		}
		if(m == n)
		{
			//if(m == DivideInteger.max)
			System.out.println(m + "  ;");//������Ϊn���Ǿ���� n=n
			divideInt(n,n-1,s);//����һ��divideInt ��ӡ�������⣡��Ҫ����֮ǰ�Ĵ�ӡ��Ϣ
		}
		if(m > n)
		{
			divideInt(n,n,s);
		}

	}
	
	public static void main(String[] args)
	{
		divideInt(DivideInteger.resouceInt,DivideInteger.max,"");

	}

}
