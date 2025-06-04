import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTKaelynLee{
	public static void main(String[] args){
		Console con = new Console(700,700);
		
		String strName;
		String strQuizName[][];
		String strType;
		int intCount=0;
		int intChoice;
		
		
		con.setDrawColor(Color.WHITE);
		con.fillRect(0,0,1366,768);
		con.setTextColor(Color.BLACK); 
		Font fntTest = con.loadFont("RushfordPrinted-MVnDe.ttf", 65);
		con.setDrawFont(fntTest);
		con.setDrawColor(new Color(0, 0, 0));
		con.drawString("Math Training Game",110,30);
		int intX = 100;
		int intY = 100;
		BufferedImage imgMath = con.loadImage("mathlogo.jpeg");
		con.drawImage(imgMath,intX,intY);
		
		
			
		
		
		con.println("(1)Play Game");
		
		con.println("(2)View Leaderboard");
		
		con.println("(3)Add Quiz");
		
		con.println("(4)Quit");
		
		intChoice = con.readInt();
		
		if(intChoice == 1){
			con.println("Give me your name");
			strName = con.readLine();
			TextInputFile masterfile = new TextInputFile("quizzes.txt");
			
			while(masterfile.eof() == false){
				strType = masterfile.readLine();
				//the number of quizzes avaliable to choose from
				intCount++;
				con.println(intCount + ") " + strType);		
	
		}
		
		
		con.println("Choose a quiz by number");
		intChoice = con.readInt();
		
		if(intChoice>0 && intChoice<= intCount){
			
			
			strQuizName = new String[100][5];
			strQuizName[0][0] = ("What is 2+2");
			strQuizName[0][1] = ("4");
			strQuizName[0][2] = ("Four");
			strQuizName[0][3] = ("+4");
			
			con.println(strQuizName[0][0]);
			 con.println("A) " + strQuizName[0][1]);
			
		}
		
		}else if(intChoice == 2){
			con.println("Leaderboard");
			
		}else if(intChoice == 3){
			con.println("create new");
			
		}else if(intChoice == 4){
			con.println("CLOSE IT");
		
		}
		
		
		
		
		
	}
}
