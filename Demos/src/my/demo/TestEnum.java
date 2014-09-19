package my.demo;

//枚举
public class TestEnum
{

	//若枚举只有一个值，可以当做单态设计模式
	enum C
	{
		A
	}
	
	enum WeekDay
	{
		MON("xingqiyi")
		{
			public void display()
			{
				System.out.println("星期一");
			}
		},TUE
		{
			public void display()
			{
				System.out.println("星期二");
			}
		},WED
		{
			public void display()
			{
				System.out.println("星期三");
			}
		},THU
		{
			public void display()
			{
				System.out.println("星期四");
			}
		},FRI("xingqiwu")
		{
			public void display()
			{
				System.out.println("星期五");
			}
		},SAT
		{
			public void display()
			{
				System.out.println("星期六");
			}
		},SUN
		{
			public void display()
			{
				System.out.println("星期天");
			}
		};
		
		String value;
		
		public String getValue()
		{
			return this.value;
		}
		
		private WeekDay()
		{
			
		}
		
		private WeekDay(String value)
		{
			this.value = value;
		}
		
		public abstract void display();

	}
	
	enum Grade{
		A("100-80")
		{
			//实现抽象方法 getLocal()
			public  String getLocal()
			{
				return("优");
			}
		},//必须用逗号分隔A，B，C
		B("79-60")
		{
			//实现抽象方法 getLocal()
			public  String getLocal()
			{
				return("中");
			}
		},
		C("59-0")
		{
			//实现抽象方法 getLocal()
			public  String getLocal()
			{
				return("差");
			}
		};//分号必须有
		
		private String value;
		
		//私有构造函数！使得别人不可用new A B C 之外的对象
		private Grade(String s)
		{
			value = s;
		}
		
		public String getValue()
		{
			return this.value;
		}
		
		public abstract String getLocal();//抽象方法没有方法体，必须加分号；
		//A,B,C类似new出来的对象，抽象方法能保证new不同对象，实现不同的方法getLocal
		}
	
	public static void main(String[] args)
	{
		//把字符串转成枚举，可以用来检验用户提交值是否合法
		Grade.valueOf("B");//转成Grade类型的对象
		//便利枚举值，返回一个数组
		Grade g[] = Grade.values();
		for(Grade gg: g)
		{
			System.out.println(gg);
		}
		
		WeekDay w = WeekDay.FRI;
		w.display();
		System.out.println(w.value);
		
		System.out.println(WeekDay.MON.getValue());
	}

}
