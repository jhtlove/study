package testdate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate
{
	//java.util.Calendar
//An instant in time can be represented by a millisecond value 
//that is an offset(偏移) from the Epoch, January 1, 1970 00:00:00.000 GMT (Gregorian 罗马).
	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();//可用来统计程序运行时间
		
		String theDate = "1999-6-5 15:47:35";//月份只写了一位也没关系
//public abstract class Calendar 抽象类，所以要通过getInstance创建对象
		 Calendar cal = Calendar.getInstance();//以本地时间来创建
		// SimpleDateFormat: formatting (date -> text),format():Formats a Date into a date/time string；
		 //parsing (text -> date)
		 //此处定义的模式，需要和前面的字符串模式完全匹配，按照前面的，用 空格、冒号 和 - 分隔
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//
		 Date da = null;
		try
		{
//parse():Parses text from the beginning of the given string to produce a date.
			da = sdf.parse(theDate);//
		}
		catch (ParseException e)
		{
			System.out.println("转化有误");
			e.printStackTrace();
		}
		//Sets this Calendar's time with the given Date.
		 cal.setTime(da);//da先初始化为null，不允许未初始化就传进来;
		 System.out.println(Calendar.DAY_OF_YEAR + "月");
		 System.out.println("Millis: " + cal.getTimeInMillis());
		 System.out.println("程序运行时间： " + (System.currentTimeMillis() - start) + " ms");//可用来统计程序运行时间		 
	}

}

//模拟实现：new接口的instance；测试访问控制——修饰符的用法
 abstract class Test <A>
 {
	 public abstract void display(A a);//抽象类写法
	 
	 //泛型：?是个通配符，可以用任何由Object派生的类型代替,表示一个未知的类型
	 public static Test<?> getInstance()
	 {
		 //"new 抽象类、new接口"
			Test<?> tt = new Test<Object> (){
				@Override
				public void display(Object a)
				{
					System.out.println(a);
					
				}};
				return tt;
	 }
	 
	 //要想 protected、private 修饰符用在class上时，只能作用在内部类；
	 //内部类当然也可以public、default修饰
	 //外部类不存在static修饰
	 protected static class Test2
	 {
		 Test2(){}
	 }

 }
 
