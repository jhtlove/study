package huawei.basic.string.execise;

//import java.util.*;  
//
//public class Main 
//{  
//	//输出最后一个单词的长度，单词以空格隔开
//	public static void main(String args[])
//	{
//		Scanner sca = new Scanner(System.in);  
//	    String s = sca.nextLine();  
//	    String ss[] = s.split(" ");  
//	    System.out.println(ss[ss.length-1].length());  
//	}
//  
//    
//}  

//import java.util.*;
//public class Main
//{
//	//字符串中数字两天加*号输出，连续数字不拆分开
//	public static String markNum(String pInStr)
//	{
//		StringBuffer temp = new StringBuffer();
//		int code = 0;
//		char c = ' ';
//		boolean preIsChar = true;//两端加字符不影响*号的个数
//   		for(int i=0;i<pInStr.length();i++)
//   		{
//   			c = pInStr.charAt(i);
//   			code = (int)c;
//   			if(code >=48 && code <= 57)
//   			{
//   				if(true == preIsChar)
//   				{
//   					temp.append('*');
//   					preIsChar = false;
//   				}
//   			}
//   			else if(false == preIsChar)
//   			{
//   				temp.append('*');
//   				preIsChar = true;
//   			}
//   				temp.append(c);
//   			if(i == pInStr.length()-1 &&code >=48 && code <= 57 )
//   			{
//   				temp.append('*');
//   			}
//   			
//   		}
//   		System.out.println(temp);
//		return null;
//	}
//	
//	public static void main(String args[])
//	{
//		Scanner sca = new Scanner(System.in);
//		String s = sca.nextLine();
//		//System.out.println((int)'1');
//		markNum(s);
//	}
//}

//import java.util.*;
//
//public class Main
//{
//	public static void main(String args[])
//	{
//		String inputString = "";
//		Scanner sca = new Scanner(System.in);
//		inputString = sca.nextLine();
//		for(int i=inputString.length()-1;i>=0;i--)
//		{
//						  System.out.print(inputString.charAt(i));
//		}
//	}
//}

///**
//* 计算字符串中某个字符出现的个数，不区分大小写
//*/
//
//import java.util.*;  
//
//public class Main  
//{  
//  public static void main(String args[])  
//  {  
//      Scanner sca = new Scanner(System.in);  
//      String s = sca.nextLine();  
//      String s1 = sca.nextLine();  
//      int num = 0;  
//      s = s.toLowerCase();  //需要赋值过来才行，似乎toLowerC没有再原来
//      s1 = s1.toLowerCase();  
//          for(int i=0;i<s.length();i++)  
//          {  
//                      if(s1.charAt(0) == s.charAt(i)) 
//                  {  
//                      num++;  
//                  }  
//          }  
//          System.out.println(num);  
//      }  
//  }  


///**
// * 扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A、2各4张，小王1张，大王1张。牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）：
// 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
// 输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如：4 4 4 4-joker JOKER。
// 请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR。
// 基本规则：
// （1）输入每手牌可能是个子、对子、顺子（连续5张）、三个、炸弹（四个）和对王中的一种，不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
// （2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）；
// （3）大小规则跟大家平时了解的常见规则相同，个子、对子、三个比较牌面大小；顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
// （4）输入的两手牌不会出现相等的情况。
// 
// 一手牌未必是5张
// */
//
////import java.util.Locale;
//
//import java.util.Scanner;
//
//public class Main
//{
//	class Pokers
//	{
//		OnePoker pokers[] = new OnePoker[5];//保存一手牌
//		OnePoker originalPokers[] = new OnePoker[5];//保存原始输入的牌
//		int level = 1;//一手牌的等级:1级是单个，2级是对子，3级是三个，4级是炸弹，5级是顺子，6级是王炸 /*等级可以在if else的比较顺序中表现出来,也可以所有的函数试着执行一遍然后给等级赋值，再比较等级*/
//		int presentValue = 0;//代表这手牌的最大值，如：是三个5 还是三个7？
//		
//		public Pokers()
//		{
//			
//		}
//		
//		public Pokers(String ss[])
//		{
//			if(ss.length < 5)
//			{
//				//需要初始化为空的牌,后面有几张牌再覆盖几张
//				for(int i=0;i<5;i++)
//				{
//					pokers[i] = new OnePoker();
//					this.originalPokers[i] = new OnePoker();
//				}
//			}
//			for(int i=0;i<ss.length;i++)
//			{
//				pokers[i] = new OnePoker(ss[i]);
//				this.originalPokers[i] = new OnePoker(ss[i]);
//			}
//			this.sortPokers();
//			presentValue = this.pokers[4].value;//如果是单张的话，所有提前赋值最大的值
//			if(this.isJokers())
//			{
//				this.level = 6;
//			}
//			else if(this.isBoom())
//			{
//				this.level = 4;
//			}
//			else if(this.isTriple())
//			{
//				this.level = 3;
//			}
//			else if(this.isPair())
//			{
//				this.level = 2;
//			}
//			else if(this.isStraight())
//			{
//				this.level = 5;
//			}
//			else
//			{
//				this.level = 1;
//			}
//			
//		}
//		
//		public boolean display()
//		{
//			for(int i=0;i<this.originalPokers.length;i++)
//			{
//				System.out.print(this.originalPokers[i].s + " ");//末尾多打印一个空格咯
//			}
//			System.out.println();
//			return true;
//		}
//		
//		//内部类相当于外部类的一个成员？    用什么访问修饰符比较合适？
//		private class OnePoker
//		{
//			String s;//牌面字符串值
//			int value;//转化为整数值，方便比较，因为牌的字符串”2“大于“3”
//			
//			public OnePoker()
//			{
//				this.s = "";
//				this.value = 0;
//			}
//			
//			public OnePoker(String s,int value)
//			{
//				this.s = s;
//				this.value = value;
//			}
//			
//			public OnePoker(String s)
//			{
//				this.s = s;
//				//java7 才能case字符串，不然只能case int 和能转化为int 的byte short char
//				switch(s)
//				{
////					case "1":
//////						{
////						
////					//case如同if一样，可以加中括号
//////							int j = 0;
//////						}
//////						int i  = 1;
////						break;
////					case "2":
////						//int i = 3;重定义了，不行
////						//int j = 5;//可以，因为上个j作用域在括号内
////						break;
////				//	case "3"://重复的case是错误的。duplicate
////						//break;
////					case "3":
////						break;
//					case "3":
//						value = 1;
//						break;
//					case "4":
//						value = 2;
//						break;
//					case "5":
//						value = 3;
//						break;
//					case "6":
//						value = 4;
//						break;
//					case "7":
//						value = 5;
//						break;
//					case "8":
//						value = 6;
//						break;
//					case "9":
//						value = 7;
//						break;
//					case "10":
//						value = 8;
//						break;
//					case "J":
//						value = 9;
//						break;
//					case "Q":
//						value = 10;
//						break;
//					case "K":
//						value = 11;
//						break;
//					case "A":
//						value = 12;
//						break;
//					case "2":
//						value = 13;
//						break;
//					case "joker":
//						value = 14;
//						break;
//					case "JOKER":
//						value = 15;
//						break;
//					default:
//						value = 0;
//			
//				}
//			}
//			
//			//swap放到一张牌的类里面比较好，还是一手牌的类里面比较合理？
//			public void swap(OnePoker thePoker)
//			{
//				int tempValue = thePoker.value;
//				String tempS = thePoker.s;
//				thePoker.value = this.value;
//				thePoker.s = this.s;
//				this.value = tempValue;
//				this.s = tempS;
////				OnePoker temp = thePoker;
////				thePoker = this;//这样对不对？
////				this = temp;//this不能成为左值，this不是变量
//			}
//		}
//		
//		//对扑克牌排序，但是会打乱原来的次序,在pokers数组上进行
//		public void sortPokers()
//		{
//			boolean changed = false;
//			int i = 0,j = 0;
//			for(i=0;i<pokers.length;i++)
//			{
//				changed = false;
//				for(j=0;j<pokers.length-i-1;j++)
//				{
//					//从前往后，大的往后仍，每趟排好一个大的
//					if(pokers[j].value > pokers[j+1].value)
//					{
//						pokers[j].swap(pokers[j+1]);
//						changed = true;
//					}
//				}
//				if(changed == false)
//				{
////System.out.print("排序后,等级 " + this.presentValue + " :" );
////for(int k=0;k<this.pokers.length;k++)
////{
////	System.out.print(this.pokers[k].s + " ");
////	
////}
//					
//					break;//不能return 后面还要给presentValue赋值
//				}
//			}
//
//			this.presentValue = this.pokers[0].value;
//		}
//		
//		//判断是否是王炸
//		public boolean isJokers()
//		{
//			boolean hasJoker = false;
//			boolean hasJOKER = false;
//			for(int i=0;i<pokers.length;i++)
//			{
//				if(pokers[i].value == 15)
//				{
//					hasJoker = true;
//				}
//				if(pokers[i].value == 15)
//				{
//					hasJOKER = true;
//				}
//			}
//			return hasJoker && hasJOKER;
//		}
//		
//		//判断是否炸弹,已经排序的前提下去判断，不同的牌只可能出现在首末端
//		public boolean isBoom()
//		{
//			if(pokers[1].value == 0)
//			{
//				return false;
//			}
//			if(pokers[0].value == pokers[3].value)
//			{
//				presentValue = pokers[0].value;
//				return true;
//			}
//			if(pokers[1].value == pokers[4].value)
//			{
//				presentValue = pokers[1].value;
//				return true;
//			}
//			
//			return false;
//		}
//		
//		//判断是否是三张
//		public boolean isTriple()
//		{
//			if(pokers[2].value ==0)
//			{
//				return false;
//			}
//			if(pokers[0].value == pokers[2].value)
//			{
//				this.presentValue = this.pokers[0].value;
//				return true;
//			}
//			if(pokers[1].value == pokers[3].value)
//			{
//				this.presentValue = this.pokers[1].value;
//				return true;
//			}
//			if(pokers[2].value == pokers[4].value)
//			{
//				this.presentValue = this.pokers[2].value;
//				return true;
//			}
//			return false;
//		}
//		
//		//判断是否是对子
//		public boolean isPair()
//		{
//			for(int i=4;i>=1;i--)
//			{
//				if(this.pokers[i].value == this.pokers[i-1].value && this.pokers[i].value != 0)
//				{
//					this.presentValue = this.pokers[i].value;
//					return true;
//				}
//			}
//			return false;
//		}
//		
//		//判断是否是顺子
//		public boolean isStraight()
//		{
//			//sortPokers();
//			for(int i=0;i<pokers.length-1;i++)
//			{
//				if(pokers[i].value !=0)
//				{
//					return false;
//				}
//				if(pokers[i+1].value - pokers[i].value != 1)
//				{
//					return false;
//				}
//			}
//			this.presentValue = this.pokers[0].value;
//			return true;
//		}
//		
///*public void init(String s)
//{
////ctrl + shit + / 这种注释，ctrl + shit + \（反斜杠） 取消注释
//			//内部类中有init这个函数的话，在外部类中定义相同名字的，不会有重名。那如何正确调用函数？
//}*/
//		
//		//和另一手牌比较大小
//		public void comparePokers(Pokers anPokers)
//		{
//			//先看两手牌有没有王炸
//		
//			
//			if(this.level == 6)
//			{
//				this.display();
//				return;
//			}
//			
//			if(anPokers.level == 6)
//			{
//				anPokers.display();
//				return;
//			}
//			
//			if(this.isBoom())
//			{
//				if(anPokers.isBoom())
//				{
//					if(this.presentValue > anPokers.presentValue)
//					{
//						this.display();
//					}
//					else
//					{
//						anPokers.display();
//					}
//				}
//				else
//					this.display();
//				return;
//			}
//			
//			if(anPokers.isBoom())
//			{
//				anPokers.display();
//				return;
//			}
//			
//			if(this.level == anPokers.level)
//			{
//				//boolean b = (this.presentValue > anPokers.presentValue) ? this.display() : anPokers.display();//还必须弄个左变量
//				if(this.presentValue > anPokers.presentValue)
//				{
//					this.display();
//				}
//				else
//				{
//					anPokers.display();
//				}
//			}
//			else
//			{
//				System.out.println("ERROR");
//			}
//		}
//	}
//	
//	
//	public static void main(String args[])
//	{
//		Scanner sca = new Scanner(System.in);
//		String inString = sca.nextLine();
////		String s = "Title";
////		s.toLowerCase(Locale.ENGLISH);//Locale：本地环境
////		System.out.println(s);//没变，还是Title
////		System.out.println(s.toUpperCase(Locale.CHINA));//TiTLE
//		String ss[] = inString.split("-");
//		String s1[] = ss[0].split(" ");
//		String s2[] = ss[1].split(" ");
//		Main test = new Main();//现有外部类，再有内部类。“先有父再有子”
//		Pokers p1 = test.new Pokers(s1);//用同一个test去new 是什么情况？
//		Pokers p2 = test.new Pokers(s2);
//		p1.comparePokers(p2);
//		
//		sca.close();
//		
//		
//	}
//}




