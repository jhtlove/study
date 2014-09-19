package huawei.basic.string.execise;
/***
 * 
 * 选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。现在，修改过的那个单词死于字母表的下面，如下所示：
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。

 *
 */
/***
 * 
 * 优化：记录key最大，密码本中受影响的只在最大之前，之后的，原数据与密文相同；
 * 那么生成密码本（记录不受影响的区间，不到z）和加密，应该写到一个函数里面；
 * 函数的功能划分需要仔细谨慎考虑！！！此处这个划分太细致，有不好的地方
 * 写的这个程序并没有具体实现
 *
 */


public class EncryptString
{
	//去除字符串中重复字母，大小写的重复也要去掉 ：A与a也算重复，但是又有不同？貌似不用理会密钥的大小写，只需要确保data大小写与密文一致
	//原文与密文对应性：大写要用大写替换，小写要用小写替换
	
	//直接返回密码本，去除密钥中重复字母就已经统计了一些信息，就可以直接产生密码本
	public static String createAlp(String inputed)
	{
System.out.println("原始密钥：  " + inputed);
		String input = inputed.toLowerCase();
		int biggestEffected = 0;
		int code = 0;
		boolean inAlp1[] = new boolean[26];//记录input字母(key?)情况，true表示在里面,大小写字符分别记录
//		boolean inAlp2[] = new boolean[26];//记录大写字母
//		for(int i=0;i<26;i++)
//		{
//			inAlp1[i] = false;//初始化
//			inAlp2[i] = false;
//		}
		String output = "";
		for(int i=0;i<input.length();i++)
		{
			code = (int)input.charAt(i);
			if(biggestEffected < code )
			{
				biggestEffected = code;//记录最后一个受影响的字母
			}
			//大写
//			if(code >= 65 && code <= 90)
//			{
//				//大写字母第一次被统计到
//				if(inAlp2[code-65] == false)
//				{
//					inAlp2[code-65] = true;
//					output = output + input.charAt(i);
//				}
//				
//			}
			//小写
			if(code >= 97 && code <= 122)
			{
				if(inAlp1[code-97] == false)
				{
					inAlp1[code-97] = true;
					output = output + input.charAt(i);
				}
			}
			else
			{
				output = output + input.charAt(i);
			}
		}
System.out.println("去重后密钥：  " + output);
		for(int j=0;j<inAlp1.length;j++)
		{
			if(inAlp1[j] == false)
			{
				output = output + (char)(j + 97);
			}
		}
System.out.println("字母表：  " + "abcdefghijklmnopqrstuvwxyz");
System.out.println("密码本：  " + output);
		return output;
	}

	public static String encrypt(String key,String data)
	{
System.out.println("明文：  " + data);
		String encrypted = "";
		String alp = createAlp(key);//表中都是小写字母,密码本
		int code = 0;
		for(int i=0;i<data.length();i++)
		{
			code = (int)data.charAt(i);
			//原数据是小写字母的，直接查表
			if(code >= 97 && code <= 122)
			{
				//if(code > biggestEffected)
//				{
//					encrypted += data.charAt(i)；//密文直接和明文相同
//				}
				encrypted += alp.charAt(code-97);
			}
			//原数据是大写字母的
			else if(code >=65 && code <= 90)
			{
				//表中都是小写字母
				encrypted += (char)(alp.charAt(code - 65) - 32);
			}
			//原数据时其它字符的，保持原样
			else
			{
				encrypted += data.charAt(i);
			}
		}
System.out.println("密文：  " + encrypted);
		return encrypted;
	}

	public static void main(String[] args)
	{
		String data = "hi LiLy";
		String key = "sksiS";
		encrypt(key,data);
	}

}
