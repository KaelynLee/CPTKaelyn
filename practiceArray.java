import arc.*;
public class practiceArray{
	public static void main(String[] args){
		Console con = new Console();
		
		String strQuestion;
		String strAnswer1;
		String strAnswer2;
		String strAnswer3;
		int intQuestion=0;
		String strQuiz[][];
		int intCount;
		
		strQuiz = new String[100][4];
		
		TextInputFile linear = new TextInputFile("linear.txt");
		
		while(linear.eof() == false){
				strQuestion = linear.readLine();
				intQuestion++;
				strAnswer1 = linear.readLine();
				strAnswer2 = linear.readLine();
				strAnswer3 = linear.readLine();
				
				con.println(strQuestion);
			}
			
			
			
			for(intQuestion=0; intQuestion<10; intQuestion++){
				con.println(strQuiz[intQuestion][0]);	
				
			}
			
			linear.close();
		
	}
}
