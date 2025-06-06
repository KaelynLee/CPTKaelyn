import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTKaelynLee{
	public static void main(String[] args){
		Console con = new Console("Math Training Game",1280,720);
		
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
		
		Font fntTest = con.loadFont("NewminRegular-ov6aa.ttf", 70);
		con.setDrawFont(fntTest);
		con.setDrawColor(new Color(0, 0, 0));
		con.drawString("Math Training Game",345,45);
		//set font and game title
		con.repaint();
		BufferedImage imgMath = con.loadImage("real15b.jpg");
		con.drawImage(imgMath,530,165);
		//add game logo 
		con.repaint();
	
		Font fntOption=con.loadFont("NewminRegular-ov6aa.ttf",45);
		con.setDrawFont(fntOption);
		con.drawString("(1)Play Game",498,420);
		con.drawString("(2)View Leaderboard",410,490);
		con.drawString("(3)Add Quiz",508,560);
		con.drawString("(4)Quit",560,630);
		//Main menu screen options
		con.repaint();
		int intKey = con.getKey();
		
		String strChooseSpecificQuiz[];
			
		// 1) PLAY GAME
		if(intKey == '1'){
			con.setDrawColor(Color.WHITE);
			con.fillRect(0,0,1366,768);
			con.setTextColor(Color.BLACK); 
			//clear previous 
			Font fntGamePlay=con.loadFont("BilonaMedium-2v6W3.ttf",30);
			con.setDrawFont(fntGamePlay);
			con.drawString("Enter Name:",600,300);
			strName = con.readLine();
			con.repaint();
			//con.clear();
			
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
		
		con.clear();
		
		if(intQuizChoice>0 && intQuizChoice < intCount){
			con.println("(1)Start Quiz");
			int int1 = con.getKey();
			strQuiz = new String[100][4];
			//temporary row number, change to 5 later
			
			TextInputFile userchoose = new TextInputFile(strChooseSpecificQuiz[intQuizChoice-1]);
			
			int intRowNumber=0;
			//int intTESTCOUNT=0;
			String strAnswer;
			
			
			while(userchoose.eof()==false){
				strQuiz[intRowNumber][0] = userchoose.readLine();
				strQuiz[intRowNumber][1] = userchoose.readLine();
				strQuiz[intRowNumber][2] = userchoose.readLine();
				strQuiz[intRowNumber][3] = userchoose.readLine();
				//bubble sort this next line
				
				
				intRowNumber++;
				
			}
			
			//con.println("Loaded " + intRowNumber + " questions.");
			//remove this line = TEST	
			
			for(int intiam = 0; intiam < intRowNumber; intiam++) {
				con.println(strQuiz[intiam][0]);
				//print each question based on how many were counted above
				con.println("Answer: ");
				strAnswer = con.readLine();
				
				if(strAnswer.equalsIgnoreCase(strQuiz[intiam][1]) || strAnswer.equalsIgnoreCase(strQuiz[intiam][2]) || strAnswer.equalsIgnoreCase(strQuiz[intiam][3])){
					con.println("TEST: correct");
					//remove?
					
				}else{
					con.println("TEST: wrong");
					//remove?
					
				}
				
			}
			
		}
				
		//write user name, quiz name, score, 
		//new screen(MAKE SURE) - NOT DONE YET|
				con.println(strName);
				con.println(strChooseSpecificQuiz[intQuizChoice - 1]);
	
		}else if(intKey == '2'){
			con.println("Leaderboard");
			
			//Output user score, quiz name, and user name to the file, arrange based on highest to lowest
			//create a 2d array 3 columns, sort by percent column(3)
			
			TextOutputFile endofQuiz = new TextOutputFile("leaderboard.txt");
		//	endofQuiz.println();
		//	endofQuiz.println();
		//	endofQuiz.println();
			
		
		}else if(intKey == '3'){
			
			String strNewGameName;
			String strNewQuestion;
			String strNewAnswer1;
			String strNewAnswer2;
			String strNewAnswer3;
			int intNewQuizCount=1;
			
			con.println("Quiz Name: ");
			strNewGameName = con.readLine();
			TextOutputFile quizzes = new TextOutputFile("quizzes.txt", true);
			quizzes.println(strNewGameName);
			
			for(intNewQuizCount=0; intNewQuizCount<=10; intNewQuizCount++){
				con.println("Question: ");
				strNewQuestion = con.readLine();
				con.println("Answer 1: ");
				strNewAnswer1 = con.readLine();
				con.println("Answer 2: ");
				strNewAnswer2 = con.readLine();
				con.println("Answer 3: ");
				strNewAnswer3 = con.readLine();
				
				TextOutputFile newquiz = new TextOutputFile("strNewGameName.txt");
				//MAKE SURE THE GAME NAME and then .txt (CURRENTLY WRONG)
				newquiz.println(strNewQuestion);
				newquiz.println(strNewAnswer1);
				newquiz.println(strNewAnswer2);
				newquiz.println(strNewAnswer3);
		
		}
	}
		
		
		else if(intKey == '4'){
			System.exit(0);
			
			//mouse input - clik quit to go back 
			
		
		}
	}
}
