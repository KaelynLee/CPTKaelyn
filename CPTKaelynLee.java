import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTKaelynLee{
	public static void main(String[] args){
		Console con = new Console(700,700);
		
		String strName;
		String strQuiz[][];
		String strType;
		int intCount=0;
		int intChoice;
		
		
		con.setDrawColor(Color.WHITE);
		con.fillRect(0,0,1366,768);
		con.setTextColor(Color.BLACK); 
		Font fntTest = con.loadFont("RushfordPrinted-MVnDe.ttf", 60);
		con.setDrawFont(fntTest);
		con.setDrawColor(new Color(0, 0, 0));
		con.drawString("Math Training Game",110,30);
		int intX = 100;
		int intY = 100;
		BufferedImage imgMath = con.loadImage("real.jpeg");
		imgMath = bufferedImage.getScaledInstance(800, 500, imgMath.SCALE_DEFAULT);
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
			
			strQuiz = new String[100][5];
			
			TextInputFile linearquiz = new TextInputFile("linear.txt");
			
			
			int intBubble;
			int intRowNumber=0;
			String strAnswer;
			
			
			while(linearquiz.eof()==false){
				strQuiz[intRowNumber][0] = linearquiz.readLine();
				strQuiz[intRowNumber][1] = linearquiz.readLine();
				strQuiz[intRowNumber][2] = linearquiz.readLine();
				strQuiz[intRowNumber][3] = linearquiz.readLine();
				//bubble sort this line
	
				
				//print the question, wait for user to answer, use if statement to check if correct
				
				con.println(strQuiz[intRowNumber][0]);
				con.println("Your Answer: ");
				strAnswer = con.readLine();
				
				if(strAnswer.equalsIgnoreCase(strQuiz[intRowNumber][1]) || strAnswer.equalsIgnoreCase(strQuiz[intRowNumber][2]) || strAnswer.equalsIgnoreCase(strQuiz[intRowNumber][3])){
					con.println("TEST: correct");
					//remove
					
				}else{
					con.println("TEST: wrong");
					//remove
					
				}
			
				intRowNumber++;
			
		}
		
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
