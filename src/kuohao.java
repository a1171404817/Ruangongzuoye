
public class kuohao {

	public String init(String s,int fn)//fn>=3
	{			
		for(int j=0;j<fn-2;j++){
			
		char[] cs = s.toCharArray();
			//qu 2ge 
			int k=j+2;
			
			String subs="";
			 int suijin=((int) (Math.random() * 10000)%(fn-1));
			 int fuhaon=0;
//			 System.out.println("随机数是:"+suijin);
			 if(suijin==0){  //从首个开始，从符号开始要分开判断
			for(int i=0;i<cs.length;i++) //不考虑括号 有多少左括号 就要多添加多少个右括号
			{		 
				if(k>0){
					
					if((!(cs[i]>=48&&cs[i]<=57))&&cs[i]!='('&&cs[i]!=')')
					{
						k--;
					}
					if(k<=0)break;
					subs+=cs[i];
				}	
			}
			 }else {
				 		
					for(int i=0;i<cs.length;i++) //不考虑括号 有多少左括号 就要多添加多少个右括号
					{	if((!(cs[i]>=48&&cs[i]<=57))&&cs[i]!='('&&cs[i]!=')')
						fuhaon++;
						if(fuhaon>=suijin){	 
							int l=i+1;
						if(k>0&&i!=cs.length-1){
							if((!(cs[l]>=48&&cs[l]<=57))&&cs[l]!='('&&cs[l]!=')')
							{
								k--;
							}
							if(k<=0)break;
							subs+=cs[l];
						}	
					}
					}
			}
				boolean isOK=true;
				
		

			
			//筛选
		
			char[] pdcs = s.toCharArray();
		
			for(int i=0;i<pdcs.length;i++)
			{
				if(pdcs[i]=='(')
				{
					for(int l=i+1;l<pdcs.length;l++)
					{	if(pdcs[l]==')'){isOK=false;}
						if(pdcs[l]=='×'||pdcs[l]=='÷'||pdcs[l]=='+'||pdcs[l]=='-')
						{	
							break;
						}
						
					}
					
					
				}
			}
	
			String khsubs="("+subs+")";
//			String rssubs=new caculate().judges(subs);
//			if(rssubs!="error"){
			s=s.replace(subs, khsubs);
//			
//			System.out.println(subs);
//			System.out.println(khsubs);
////			System.out.println(rssubs);
//			System.out.println(s);
		
		}
		boolean isOK=true;
		
		

		
		//筛选
	
		char[] pdcs = s.toCharArray();
	
		for(int i=0;i<pdcs.length;i++)
		{
			if(pdcs[i]=='(')
			{
				for(int l=i+1;l<pdcs.length;l++)
				{	if(pdcs[l]==')'){isOK=false;}
					if(pdcs[l]=='×'||pdcs[l]=='÷'||pdcs[l]=='+'||pdcs[l]=='-')
					{	
						break;
					}
					
				}
				
				
			}
		}
		pdcs = s.toCharArray();
		for(int i=0;i<pdcs.length;i++)
		{if(i+3<pdcs.length){
			if(pdcs[i]=='('&&pdcs[i+1]=='(')
			{	int mk=0;
				for(int l=i+2;l<pdcs.length;l++)
				{	if(l+1<pdcs.length){
					if(pdcs[l]==')'&&pdcs[l+1]==')'&&mk==0)
					{
					isOK=false;
					}
					if(pdcs[l]=='(')mk++;
					if(pdcs[l]==')')mk--;
				}
					
				}
			}
			
		}
		}
		pdcs = s.toCharArray();
		if(pdcs[0]=='('&&pdcs[pdcs.length-1]==')')
			isOK=false;
		if(isOK==false){
			return "error";
		}
		return s;
		
	

	}
	
	public String jieshi(String s)
	{
		char[] cs = s.toCharArray();
		
		while(true)
		{	
//			System.out.println("我在循环1我的字符串是"+s);
			boolean havakuohao=havakuohao(s);
			if(havakuohao==false)break;

//			System.out.println("我在循环2");
			
			
//			System.out.println("原始"+s);
			String subsString="";
			int lastzk=-1;
			for(int i=0;i<cs.length;i++)
			{
				if(cs[i]=='(')
				{
					lastzk=i;
				}
			}
			for(int i=lastzk+1;i<cs.length;i++)
			{
				subsString+=cs[i];
				if(cs[i+1]==')')
					break;
			}
		
//			System.out.println("提取出的子串"+subsString);
			
			String hksubString="("+subsString+")";
			String rString=new caculate().judges(subsString);///////////////注意要处理'error'
//			System.out.println("rString的值是"+rString+" "+rString.equals("error"));
		
			if(rString.equals("error")){return "error";}
		
			s=s.replace(hksubString, rString);
			cs = s.toCharArray();
			
			
		}
		
		return s;
	}
	
	public static boolean havakuohao(String s)
	{	
//		System.out.println("我在循环3-1");
		char[] cs = s.toCharArray();
		for(int i=0;i<cs.length;i++)
		{
			if(cs[i]=='(')
			{	
//				System.out.println("我在循环3-2");
				return true;
			}
		}
//		System.out.println("我在循环3-3");
		return false;
	}
}
