package test.basic;

public class TestClass
{
	Dog d;// = new Dog("big");//直接初始化new可以，以后初始化new也可以
	
	public void myDog()
	{
		//d = new Dog("little");
		d.dis();//Dog d没有new 实例化，这么写,不过运行出空指针错
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
