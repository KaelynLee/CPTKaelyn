import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTKaelynLee{
	public static void main(String[] args){
		Console con = new Console(700,700);
		
		String strName;
		String strType;
		int intCount=0;
		int intQuizCount = 0;
		int intQuestionsCount;
		int intChoice;
		
		
		con.setDrawColor(Color.WHITE);
		con.fillRect(0,0,1366,768);
		con.setTextColor(Color.BLACK); 
		Font fntTest = con.loadFont("RushfordPrintedDemoRegular.ttf", 600);
		con.setDrawFont(fntTest);
		con.setDrawColor(new Color(0, 0, 0));
		con.drawString("Math Training Game",250,80);
		
			
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
		
		}else if(intChoice == 2){
			con.println("Leaderboard");
			
		}else if(intChoice == 3){
			con.println("create new");
			
		}else if(intChoice == 4){
			con.println("CLOSE IT");
		
		}
		
		con.println("Choose a quiz by number");
		intChoice = con.readInt();
		
		if(intQuizCount == intChoice){
			String[][] strQuiz = new String[100][5];
			
			
		}
		
		
		
		
	}
}
