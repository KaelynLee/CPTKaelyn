import arc.*;
public class practiceArray{
	public static void main(String[] args){
		Console con = new Console();
		
		String strQuestion;
		String strAnswer1;
		String strAnswer2;
		String strAnswer3;
		int intCount=1;
		int intQuestion=0;
		String strQuiz[][];
		
		TextInputFile linear = new TextInputFile("linear.txt");
			
			while(linear.eof() == false){
				strQuestion = linear.readLine();
				intQuestion++;
				strAnswer1 = linear.readLine();
				intCount++;
				strAnswer2 = linear.readLine();
				intCount++;
				strAnswer3 = linear.readLine();
				intCount++;
				
				
			}
			
			linear.close();
			strQuiz = new String [100][3];
			con.println("The number of students: "+intQuestion);
		
		
		
		
		
		
	}
}
