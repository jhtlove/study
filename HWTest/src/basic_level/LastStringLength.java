package basic_level;

public class LastStringLength
{
	private String s = "hello world sunny day";
	private int num = 0;
	
	public int count()
	{
		String ss[] = s.split(" ");
		String temp = ss[ss.length - 1];
		num = temp.length();
		System.out.println(num);
		return num;
	}
	
	public static void main(String[] args)
	{
		new LastStringLength().count();

	}

}
