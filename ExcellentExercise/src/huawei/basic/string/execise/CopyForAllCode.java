package huawei.basic.string.execise;

//import java.util.*;  
//
//public class Main 
//{  
//	//������һ�����ʵĳ��ȣ������Կո����
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
//	//�ַ��������������*��������������ֲ���ֿ�
//	public static String markNum(String pInStr)
//	{
//		StringBuffer temp = new StringBuffer();
//		int code = 0;
//		char c = ' ';
//		boolean preIsChar = true;//���˼��ַ���Ӱ��*�ŵĸ���
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
//* �����ַ�����ĳ���ַ����ֵĸ����������ִ�Сд
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
//      s = s.toLowerCase();  //��Ҫ��ֵ�������У��ƺ�toLowerCû����ԭ��
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
// * �˿�����Ϸ���Ӧ�ö��Ƚ���Ϥ�ˣ�һ������54����ɣ���3~A��2��4�ţ�С��1�ţ�����1�š������С�����������ַ����ַ�����ʾ�����У�Сдjoker��ʾС������дJOKER��ʾ��������
// 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
// ���������ƣ�������֮����"-"���ӣ�ÿ���Ƶ�ÿ�����Կո�ָ���"-"����û�пո��磺4 4 4 4-joker JOKER��
// ��Ƚ������ƴ�С������ϴ���ƣ���������ڱȽϹ�ϵ�����ERROR��
// ��������
// ��1������ÿ���ƿ����Ǹ��ӡ����ӡ�˳�ӣ�����5�ţ���������ը�����ĸ����Ͷ����е�һ�֣���������������������뱣֤�����ƶ��ǺϷ��ģ�˳���Ѿ���С�������У�
// ��2������ը���Ͷ������Ժ������ƱȽ�֮�⣬�������͵���ֻ�ܸ���ͬ���͵Ĵ��ڱȽϹ�ϵ���磬���Ӹ����ӱȽϣ������������Ƚϣ��������ǲ���������磺�����Ӳ�ֳɸ��ӣ���
// ��3����С��������ƽʱ�˽�ĳ���������ͬ�����ӡ����ӡ������Ƚ������С��˳�ӱȽ���С�ƴ�С��ը������ǰ�����е��ƣ�ը��֮��Ƚ������С�������������ƣ�
// ��4������������Ʋ��������ȵ������
// 
// һ����δ����5��
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
//		OnePoker pokers[] = new OnePoker[5];//����һ����
//		OnePoker originalPokers[] = new OnePoker[5];//����ԭʼ�������
//		int level = 1;//һ���Ƶĵȼ�:1���ǵ�����2���Ƕ��ӣ�3����������4����ը����5����˳�ӣ�6������ը /*�ȼ�������if else�ıȽ�˳���б��ֳ���,Ҳ�������еĺ�������ִ��һ��Ȼ����ȼ���ֵ���ٱȽϵȼ�*/
//		int presentValue = 0;//���������Ƶ����ֵ���磺������5 ��������7��
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
//				//��Ҫ��ʼ��Ϊ�յ���,�����м������ٸ��Ǽ���
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
//			presentValue = this.pokers[4].value;//����ǵ��ŵĻ���������ǰ��ֵ����ֵ
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
//				System.out.print(this.originalPokers[i].s + " ");//ĩβ���ӡһ���ո�
//			}
//			System.out.println();
//			return true;
//		}
//		
//		//�ڲ����൱���ⲿ���һ����Ա��    ��ʲô�������η��ȽϺ��ʣ�
//		private class OnePoker
//		{
//			String s;//�����ַ���ֵ
//			int value;//ת��Ϊ����ֵ������Ƚϣ���Ϊ�Ƶ��ַ�����2�����ڡ�3��
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
//				//java7 ����case�ַ�������Ȼֻ��case int ����ת��Ϊint ��byte short char
//				switch(s)
//				{
////					case "1":
//////						{
////						
////					//case��ͬifһ�������Լ�������
//////							int j = 0;
//////						}
//////						int i  = 1;
////						break;
////					case "2":
////						//int i = 3;�ض����ˣ�����
////						//int j = 5;//���ԣ���Ϊ�ϸ�j��������������
////						break;
////				//	case "3"://�ظ���case�Ǵ���ġ�duplicate
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
//			//swap�ŵ�һ���Ƶ�������ȽϺã�����һ���Ƶ�������ȽϺ���
//			public void swap(OnePoker thePoker)
//			{
//				int tempValue = thePoker.value;
//				String tempS = thePoker.s;
//				thePoker.value = this.value;
//				thePoker.s = this.s;
//				this.value = tempValue;
//				this.s = tempS;
////				OnePoker temp = thePoker;
////				thePoker = this;//�����Բ��ԣ�
////				this = temp;//this���ܳ�Ϊ��ֵ��this���Ǳ���
//			}
//		}
//		
//		//���˿������򣬵��ǻ����ԭ���Ĵ���,��pokers�����Ͻ���
//		public void sortPokers()
//		{
//			boolean changed = false;
//			int i = 0,j = 0;
//			for(i=0;i<pokers.length;i++)
//			{
//				changed = false;
//				for(j=0;j<pokers.length-i-1;j++)
//				{
//					//��ǰ���󣬴�������ԣ�ÿ���ź�һ�����
//					if(pokers[j].value > pokers[j+1].value)
//					{
//						pokers[j].swap(pokers[j+1]);
//						changed = true;
//					}
//				}
//				if(changed == false)
//				{
////System.out.print("�����,�ȼ� " + this.presentValue + " :" );
////for(int k=0;k<this.pokers.length;k++)
////{
////	System.out.print(this.pokers[k].s + " ");
////	
////}
//					
//					break;//����return ���滹Ҫ��presentValue��ֵ
//				}
//			}
//
//			this.presentValue = this.pokers[0].value;
//		}
//		
//		//�ж��Ƿ�����ը
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
//		//�ж��Ƿ�ը��,�Ѿ������ǰ����ȥ�жϣ���ͬ����ֻ���ܳ�������ĩ��
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
//		//�ж��Ƿ�������
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
//		//�ж��Ƿ��Ƕ���
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
//		//�ж��Ƿ���˳��
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
////ctrl + shit + / ����ע�ͣ�ctrl + shit + \����б�ܣ� ȡ��ע��
//			//�ڲ�������init��������Ļ������ⲿ���ж�����ͬ���ֵģ��������������������ȷ���ú�����
//}*/
//		
//		//����һ���ƱȽϴ�С
//		public void comparePokers(Pokers anPokers)
//		{
//			//�ȿ���������û����ը
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
//				//boolean b = (this.presentValue > anPokers.presentValue) ? this.display() : anPokers.display();//������Ū�������
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
////		s.toLowerCase(Locale.ENGLISH);//Locale�����ػ���
////		System.out.println(s);//û�䣬����Title
////		System.out.println(s.toUpperCase(Locale.CHINA));//TiTLE
//		String ss[] = inString.split("-");
//		String s1[] = ss[0].split(" ");
//		String s2[] = ss[1].split(" ");
//		Main test = new Main();//�����ⲿ�࣬�����ڲ��ࡣ�����и������ӡ�
//		Pokers p1 = test.new Pokers(s1);//��ͬһ��testȥnew ��ʲô�����
//		Pokers p2 = test.new Pokers(s2);
//		p1.comparePokers(p2);
//		
//		sca.close();
//		
//		
//	}
//}




