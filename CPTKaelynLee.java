import arc.*;

public class CPTKaelynLee{
	public static void main(String[] args){
		Console con = new Console();
		
		String strName;
		String strType;
		int intCount=0;
		int intQuizCount = 0;
		int intQuestionsCount;
		int intChoice;
		
		con.println("Give me your name");
		strName = con.readLine();
		
		con.println("(1)Play Game");
		
		con.println("(2)View Leaderboard");
		
		con.println("(3)Add Quiz");
		
		con.println("(4)Quit");
		
		intChoice = con.readInt();
		
		if(intChoice == 1){
	
		TextInputFile masterfile = new TextInputFile("quizzes.txt");
		while(masterfile.eof() == false){
			strType = masterfile.readLine();
			intCount++;
			con.println(intCount + ") " + strType);		
	
		}
		}
		
		con.println("Choose a quiz by number");
		intChoice = con.readInt();
		
		if(intQuizCount == intChoice){
			String[][] strQuiz = new String[100][5];
			
			
		}
		
		
		
		
	}
}
