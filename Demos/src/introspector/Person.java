package introspector;//ʹ����ʡ����bean����
//javabean���ö����װ�û����ݡ��ֶΣ��ṩget��set������Ϊ���ԡ�
//���Ը�����get��set���������������ֶξ������и�����getA(),��ô����A���ԣ���ʹû�ж����ֶ�A

//������̳���Object��getClass()Returns the runtime class of this Object
//���Ǵ�Object�̳���class���ԡ�

//����ȥ����������
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
