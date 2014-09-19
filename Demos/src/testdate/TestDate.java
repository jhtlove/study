package testdate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate
{
	//java.util.Calendar
//An instant in time can be represented by a millisecond value 
//that is an offset(ƫ��) from the Epoch, January 1, 1970 00:00:00.000 GMT (Gregorian ����).
	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();//������ͳ�Ƴ�������ʱ��
		
		String theDate = "1999-6-5 15:47:35";//�·�ֻд��һλҲû��ϵ
//public abstract class Calendar �����࣬����Ҫͨ��getInstance��������
		 Calendar cal = Calendar.getInstance();//�Ա���ʱ��������
		// SimpleDateFormat: formatting (date -> text),format():Formats a Date into a date/time string��
		 //parsing (text -> date)
		 //�˴������ģʽ����Ҫ��ǰ����ַ���ģʽ��ȫƥ�䣬����ǰ��ģ��� �ո�ð�� �� - �ָ�
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//
		 Date da = null;
		try
		{
//parse():Parses text from the beginning of the given string to produce a date.
			da = sdf.parse(theDate);//
		}
		catch (ParseException e)
		{
			System.out.println("ת������");
			e.printStackTrace();
		}
		//Sets this Calendar's time with the given Date.
		 cal.setTime(da);//da�ȳ�ʼ��Ϊnull��������δ��ʼ���ʹ�����;
		 System.out.println(Calendar.DAY_OF_YEAR + "��");
		 System.out.println("Millis: " + cal.getTimeInMillis());
		 System.out.println("��������ʱ�䣺 " + (System.currentTimeMillis() - start) + " ms");//������ͳ�Ƴ�������ʱ��		 
	}

}

//ģ��ʵ�֣�new�ӿڵ�instance�����Է��ʿ��ơ������η����÷�
 abstract class Test <A>
 {
	 public abstract void display(A a);//������д��
	 
	 //���ͣ�?�Ǹ�ͨ������������κ���Object���������ʹ���,��ʾһ��δ֪������
	 public static Test<?> getInstance()
	 {
		 //"new �����ࡢnew�ӿ�"
			Test<?> tt = new Test<Object> (){
				@Override
				public void display(Object a)
				{
					System.out.println(a);
					
				}};
				return tt;
	 }
	 
	 //Ҫ�� protected��private ���η�����class��ʱ��ֻ���������ڲ��ࣻ
	 //�ڲ��൱ȻҲ����public��default����
	 //�ⲿ�಻����static����
	 protected static class Test2
	 {
		 Test2(){}
	 }

 }
 
