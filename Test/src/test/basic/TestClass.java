package test.basic;

public class TestClass
{
	Dog d;// = new Dog("big");//ֱ�ӳ�ʼ��new���ԣ��Ժ��ʼ��newҲ����
	
	public void myDog()
	{
		//d = new Dog("little");
		d.dis();//Dog dû��new ʵ��������ôд,�������г���ָ���
	}
	
	public static void main(String[] args)
	{
		new TestClass().myDog();

	}

}

class Dog
{
	String name = null;
	
	public Dog()
	{
		name = "too";
	}
	
	public Dog(String s)
	{
		name = s;
	}
	
	public void dis()
	{
		System.out.println("dog: " + name);
	}
}
