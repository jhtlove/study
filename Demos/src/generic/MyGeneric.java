package generic;

//�Զ������������ķ��ͣ�ֻ�����ڷǾ�̬��Ա�����ϣ��ɶ���������;���ڶ���������õ��˷���
public class MyGeneric  <T,T1,A>
{
	//�Զ�����з��͵ķ���������������T��ʹ��;���÷�����ʱ�򣬸����������
	//staticҪ������������
	public static <T> T getValue(T value)
	{
		return value;
	}
	
	//����������voidǰ������ֵ����ǰ�����ʿ���public������static��
	public  <A,B,C> void display(A a,B b,C sum)
	{
		System.out.println(a + "+" + b + "=" + sum);
	}
	
	public static void main(String[] args)
	{
		System.out.println(getValue(123));
		System.out.println(getValue("abc"));

		
	}

}
