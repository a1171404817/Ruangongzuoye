
public class caculate {

	public String judges(String s) //返回对应表达式的字符串结果，如果出错返回error 进行了判断，如果为负数泽返回error
	{	String origins=s;
		
			if(s.indexOf("×")==-1&&s.indexOf("÷")==-1)
			{	
				
				int resultn=Integer.parseInt(caluJiajian(s));
				if(resultn<0) return "error";
				return String.valueOf(resultn);
				
			}
			else {
				
				s=caculaChenChu(s);
				if(!s.equals("error")){
					int resultn;
					try{
					 resultn=Integer.parseInt(caluJiajian(s));
					}catch (NumberFormatException e) {
						// TODO: handle exception
						return "error";
					}
					if(resultn<0) return "error";
					return String.valueOf(resultn);
				}
				else
				{
					return "error";
				}
			}
		
				
	}
	public String caluJiajian(String s) //注意：并不返回error 返回直接值进行判断 //返回结果的字符串
	{	char[] cs = s.toCharArray();
		String[] arr=new String[10];
		for(int i=0;i<arr.length;i++) arr[i]="";
		int arrc=0;
		char[] fuhao=new char[10];
		int fuhaoc=0;
		for(int i=0;i<cs.length;i++)
		{
			if(cs[i]>=48&&cs[i]<=57)
			{
				arr[arrc]+=String.valueOf(cs[i]);
			}
			else
			{
				arrc++;
				fuhao[fuhaoc]=cs[i];
				fuhaoc++;
			}
		}
		arrc++;	
//		for(int i=0;i<arrc;i++) //用来测试数组对字符串数字的提取是否正确
//		{
//			System.out.println(arr[i]);
//			
//		}
//		
//		for(int i=0;i<fuhaoc;i++)
//		{
//			System.out.println(fuhao[i]);
//		}
		int sumn=Integer.parseInt(arr[0]);
		
		for(int i=0;i<fuhaoc;i++)
		{
			if(fuhao[i]=='+')
			{
				sumn+=Integer.parseInt(arr[i+1]);
			}
			else
			{
				sumn-=Integer.parseInt(arr[i+1]);
				if(sumn<0)
					return String.valueOf(sumn);
			}
		}
		
		return String.valueOf(sumn);
	
	}
	
	public String caculaChenChu(String s) //返回加减表达式，如果存在非整数除法或分母为0返回error
	{	
		
		
		while(true){
		
		char[] cs = s.toCharArray();
		String[] twonum=new String[2];
		for(int i=0;i<2;i++) twonum[i]="";
		
		
				
		for(int i=0;i<cs.length;i++)
		{
			if(cs[i]=='×'||cs[i]=='÷')
			{	char temp=cs[i];
				twonum[0]+=String.valueOf(cs[i+1]);
				int j=i+2;
				while(true)
				{	if(j>=cs.length)break;
					if((cs[j]=='×'||cs[j]=='÷'||cs[j]=='+'||cs[j]=='-')){
						break;
					
					}else
					{
						twonum[0]+=String.valueOf(cs[j]);
						j++;
					}
			
				}
				twonum[1]+=String.valueOf(cs[i-1]);
				int k=i-2;
				while(true)
				{
					if(k<0)break; //判断是否越界
					if(cs[k]=='×'||cs[k]=='÷'||cs[k]=='+'||cs[k]=='-'){ //判断是否是数字
						
						break;
					}
					{
						twonum[1]+=String.valueOf(cs[k]);
						k--;
					}
					
				}
			
				
				twonum[1]=new StringBuilder(twonum[1]).reverse().toString();//反转字符串
			
				if(temp=='×'){
				String beReplce=twonum[1]+"×"+twonum[0];
				String sum;
				try{
				 sum=String.valueOf(Integer.parseInt(twonum[1])*Integer.parseInt(twonum[0]));
				}catch (NumberFormatException e) {
					// TODO: handle exception
					return "error";
					
				}
				
				s=s.replace(beReplce, sum);
//			System.out.println("此算式合法"+"替换的字符串是："+sum+"被替换的字符串是"+beReplce+"替换之后的结果是"+s);
				}
				else
				{
					if(twonum[0].equals("0")){
//						System.out.println("此算式不合法");
						return "error";
					
					}
					String beReplce=twonum[1]+"÷"+twonum[0];
					
				
					int tempn=Integer.valueOf(twonum[1])%Integer.valueOf(twonum[0]);
					if(tempn==0){
						String sum=String.valueOf(Integer.valueOf(twonum[1])/Integer.valueOf(twonum[0]));
					s=s.replace(beReplce, sum);
//					
//				System.out.println("此算式合法"+"替换的字符串是："+sum+"被替换的字符串是"+beReplce+"替换之后的结果是"+s);

					}
					else
					{		
//						System.out.println("此算式不合法");
						return "error";
					}
				
				}
				
				break;
			}
		}

			if(s.indexOf("×")==-1&&s.indexOf("÷")==-1)
			{
				break;
			}
}
		
		return s;
		
	}
	private char[] Integer(Double tempn) {
		// TODO Auto-generated method stub
		return null;
	}

}
