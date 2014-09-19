package recursion;

public class HanTower
{
	//把a处的第一个的放到c上
	public void put(String a,String c)
	{
		System.out.println("把" + a + "柱子上第一个移动到" + c + "柱子上" );
	}
	//汉诺塔高度height；从A移到C，经过B
	public void move(int height,String a,String b ,String c)
	{
		if(height == 1) 
			put(a,c);
		else
		{
			move(height-1,a,c,b);//这样传参数后，put（a,c）做的是把a的n-1个都挪到B（第四个参数）上，而不是C上
			put(a,c);//把最底下的挪到C上
			move(height-1,b,a,c);//把n-1个从B经过a挪到C上
		}
		
	}
	
	public static void main(String[] args)
	{
		new HanTower().move(3, "A", "B", "C");
	}

}
