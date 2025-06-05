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
		//set the background colour to white
		con.setTextColor(Color.BLACK); 
		//set the font colour to black
		Font fntTest = con.loadFont("RushfordPrinted-MVnDe.ttf", 60);
		con.setDrawFont(fntTest);
		con.setDrawColor(new Color(0, 0, 0));
		con.drawString("Math Training Game",110,30);
		//set font and game title
		int intX = 100;
		int intY = 100;
		BufferedImage imgMath = con.loadImage("real.jpeg");
		//imgMath = bufferedImage.getScaledInstance(800, 500, imgMath.SCALE_DEFAULT);
		//RESIZE TEST
		con.drawImage(imgMath,intX,intY);
		//add game logo 
		
		
		con.println("(1)Play Game");
		con.println("(2)View Leaderboard");
		con.println("(3)Add Quiz");
		con.println("(4)Quit");
		//Main menu screen options
		
		intChoice = con.readInt();
		
		String strChooseSpecificQuiz[];
			
		// 1) PLAY GAME
		if(intChoice == 1){
			con.println("Enter Name: ");
			strName = con.readLine();
			
			TextInputFile masterfile = new TextInputFile("quizzes.txt");
			//input quiz type options onto screen for user to choose - load into 1 dimensional array
			
			strChooseSpecificQuiz = new String[100];
		
			while(masterfile.eof() == false){
				strChooseSpecificQuiz[intCount] = masterfile.readLine();
				//the number of quizzes avaliable to choose from
				con.println((intCount + 1) + ") " + strChooseSpecificQuiz[intCount]);		
				intCount++;
				//+1 -1 is due to index, since it has to start at 0
		}
		
		
		int intQuizChoice; 
		
		con.println("Choose a quiz by number");
		intQuizChoice = con.readInt();
		
		if(intQuizChoice>0 && intQuizChoice < intCount){
			
			strQuiz = new String[100][5];
			//change to 5 later
			
			TextInputFile userchoose = new TextInputFile(strChooseSpecificQuiz[intQuizChoice-1]);
			
			int intRowNumber=0;
			//int intTESTCOUNT=0;
			String strAnswer;
			
			
			while(userchoose.eof()==false){
				strQuiz[intRowNumber][0] = userchoose.readLine();
				strQuiz[intRowNumber][1] = userchoose.readLine();
				strQuiz[intRowNumber][2] = userchoose.readLine();
				strQuiz[intRowNumber][3] = userchoose.readLine();
				//bubble sort this line
				intRowNumber++;
		
				
		
				
			}
			
			con.println("Loaded " + intRowNumber + " questions.");	
			
			for(int intiam = 0; intiam < intRowNumber; intiam++) {
				con.println(strQuiz[intiam][0]);
				con.println("Answer: ");
				strAnswer = con.readLine();
				
			}
			
			
		
			/*	for(intTESTCOUNT=0; intTESTCOUNT < intRowNumber; intTESTCOUNT++){
					//bottom is trial
				con.println(strQuiz[intTESTCOUNT][0]);
				con.println("Answer: ");
				strAnswer = con.readLine();
				
				if(strAnswer.equalsIgnoreCase(strQuiz[intTESTCOUNT][1]) || strAnswer.equalsIgnoreCase(strQuiz[intTESTCOUNT][2]) || strAnswer.equalsIgnoreCase(strQuiz[intTESTCOUNT][3])){
					con.println("TEST: correct");
					//remove
					
				}else{
					con.println("TEST: wrong");
					//remove
					
				}
			
				
			
		}
		
	*/
		
	}
	
		//}else if(intChoice == 2){
		//	con.println("Leaderboard");
			
		//}else if(intChoice == 3){
		//	con.println("create new");
			
		//}else if(intChoice == 4){
		//	con.println("CLOSE IT");
		
		}
		
		
		
		
		
	}
}
