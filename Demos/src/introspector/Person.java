package introspector;//使用内省操作bean属性
//javabean，用对象封装用户数据。字段，提供get或set方法成为属性。
//属性个数由get、set方法决定，不由字段决定。有个函数getA(),那么就有A属性，即使没有定义字段A

//所有类继承自Object，getClass()Returns the runtime class of this Object
//于是从Object继承了class属性。

//可以去掉父类属性
public class Person
{
	private String name;
	private int age;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	
}
