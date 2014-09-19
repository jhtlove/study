package generic;

//自定义类上声明的泛型，只作用在非静态成员方法上，可定义多个泛型;便于多个方法都用到了泛型
public class MyGeneric  <T,T1,A>
{
	//自定义带有泛型的方法；先声明泛型T再使用;调用方法的时候，赋予具体类型
	//static要单独声明泛型
	public static <T> T getValue(T value)
	{
		return value;
	}
	
	//泛型声明在void前，返回值类型前，访问控制public……和static后
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
