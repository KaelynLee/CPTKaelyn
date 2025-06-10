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
		int intInterval=100;
		
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
	
		Font fntOption=con.loadFont("NewminRegular-ov6aa.ttf",40);
		con.setDrawFont(fntOption);
		con.drawString("[p]Play Game",510,400);
		con.drawString("[v]View Leaderboard",420,460);
		con.drawString("[c]Create Quiz",508,520);
		con.drawString("[q]Quit",560,580);
		con.drawString("[h]Help",560,640);
		con.drawString("[s]Secret Menu",0,0);
		con.setDrawColor(Color.WHITE);
		con.fillOval(0, 0, 350, 90);
		//Main menu screen options
		con.repaint();
		
		int intKey = con.getKey();
		String strName1;
		String strChooseSpecificQuiz[];
			
		// 1) PLAY GAME
		if(intKey == 'p' || intKey == 'P'){
			con.setDrawColor(Color.WHITE);
			con.fillRect(0,0,1366,768);
			con.setTextColor(Color.BLACK); 
			//clear previous 
			Font fntGamePlay=con.loadFont("BilonaMedium-2v6W3.ttf",60);
			con.setDrawFont(fntGamePlay);
			con.setDrawColor(new Color(0, 0, 0));
			con.drawString("Enter Name: ",300,300);
			strName = con.readLine();			
			con.setDrawColor(Color.WHITE);
			con.fillRect(0,0,1366,768);
			con.setDrawColor(new Color(0, 0, 0));
			con.setDrawFont(fntGamePlay);
			con.drawString((strName),600,300);
			con.repaint();
			con.clear();
		
		if(strName.equalsIgnoreCase("statitan")){
			con.clear();
			con.repaint();
			con.drawString("YAY",300,400);
			
			
			}
			
			
			
			//WAIT TIME
				
			TextInputFile masterfile = new TextInputFile("quizzes.txt");
			//input quiz type options onto screen for user to choose - load into 1 dimensional array
			
			strChooseSpecificQuiz = new String[100];
		
			con.setDrawColor(Color.WHITE);
			con.fillRect(0,0,1366,768);
			con.setTextColor(Color.BLACK); 
			//clear previous 
			Font fntSelection=con.loadFont("BilonaMedium-2v6W3.ttf",40);
			con.setDrawFont(fntSelection);
			con.setDrawColor(new Color(0, 0, 0));
			
			while(masterfile.eof() == false){
				strChooseSpecificQuiz[intCount] = masterfile.readLine();
				//the number of quizzes avaliable to choose from
				con.repaint();
				con.drawString("Choose a Quiz:",600,80);
				con.drawString((intCount + 1) + ") " + strChooseSpecificQuiz[intCount],150,50+intInterval);		
				intCount++;
				intInterval = intInterval+65;
				//+1 -1 is due to index, since it has to start at 0
				
				//USE A KEY HERE - NEED TO ADD
		}
		
		int intQuizChoice; 
		intQuizChoice = con.readInt();
		con.setDrawColor(Color.WHITE);
		con.fillRect(0,0,1366,768);
		con.setTextColor(Color.BLACK);
		con.repaint();
		
		int intAnswerChecker=0;
		int intScore;
			
		if(intQuizChoice>0 && intQuizChoice < intCount){
			con.setDrawColor(Color.WHITE);
			con.fillRect(0,0,1366,768);
			con.setTextColor(Color.BLACK); 
			Font fntStart=con.loadFont("BilonaMedium-2v6W3.ttf",100);
			con.setDrawFont(fntStart);
			con.setDrawColor(new Color(0, 0, 0));
			con.clear();
			con.repaint();
			con.drawString("(1)Start Quiz", 400,300);
			con.repaint();
			int intPress = con.getKey();
			
		
			if(intPress == '1'){
			
			con.setDrawColor(Color.WHITE);
			con.fillRect(0,0,1366,768);
			con.repaint();
			
			strQuiz = new String[100][4];
			
			String strAnswer;
			String strQuestion;
			String strAnswer1;
			String strAnswer2;
			String strAnswer3;
			int intQuestion=0;
			
			TextInputFile userchoose = new TextInputFile(strChooseSpecificQuiz[intQuizChoice-1]);
		
			intQuestion =0;
			
			while(userchoose.eof() == false){
				strQuiz[intQuestion][0] = userchoose.readLine();
				strQuiz[intQuestion][1] = userchoose.readLine(); 
				strQuiz[intQuestion][2] = userchoose.readLine(); 
				strQuiz[intQuestion][3] = userchoose.readLine(); 
				intQuestion++;
			}
			
			
			for(intQuestion=0; intQuestion<10; intQuestion++){
				con.println(strQuiz[intQuestion][0]);	
				con.println("Answer: ");
				strAnswer = con.readLine();
				
				if(strAnswer.equalsIgnoreCase(strQuiz[intQuestion][1]) || strAnswer.equalsIgnoreCase(strQuiz[intQuestion][2]) || strAnswer.equalsIgnoreCase(strQuiz[intQuestion][3])){
					con.println("Correct");
					intAnswerChecker++;
					con.println(intAnswerChecker+"/10");
					
				}else{
					con.println("Wrong");
					con.println(intAnswerChecker+"/10");
					
				}
				
				con.clear();
					
			}
			
		}
				
		//write user name, quiz name, score, 
		//new screen(MAKE SURE) - NOT DONE YET|
				con.println(strName);
				con.println(strChooseSpecificQuiz[intQuizChoice - 1]);
				con.println(intAnswerChecker+"/10");
				intScore = Math.round(intAnswerChecker/10*100)/100;
				con.println(intScore);
	}
		}else if(intKey == 'v'){
			con.println("Leaderboard");
			
			//Output user score, quiz name, and user name to the file, arrange based on highest to lowest
			//create a 2d array 3 columns, sort by percent column(3)
			
			TextOutputFile endofQuiz = new TextOutputFile("leaderboard.txt");
		//	endofQuiz.println();
		//	endofQuiz.println();
		//	endofQuiz.println();
			
		
		}else if(intKey == 'c' || intKey == 'C'){
			
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
				
				TextOutputFile newquiz = new TextOutputFile(strNewGameName +".txt");
				//MAKE SURE THE GAME NAME and then .txt (CURRENTLY WRONG)
				newquiz.println(strNewQuestion);
				newquiz.println(strNewAnswer1);
				newquiz.println(strNewAnswer2);
				newquiz.println(strNewAnswer3);
		
		}
	}
		
		else if(intKey == 'h' || intKey == 'H'){
			
			con.setDrawColor(Color.WHITE);
			con.fillRect(0,0,1366,768);
			con.setTextColor(Color.BLACK); 
			Font fntGamePlay=con.loadFont("BilonaMedium-2v6W3.ttf",60);
			con.setDrawFont(fntGamePlay);
			con.setDrawColor(new Color(0, 0, 0));
			con.repaint();
			con.drawString("Help",300,300);
		
		}else if(intKey == 'q' || intKey == 'Q'){
			System.exit(0);
		
		}else if(intKey == 's' || intKey == 'S'){
			con.setDrawColor(Color.WHITE);
			con.fillRect(0,0,1366,768);
			con.setTextColor(Color.BLACK); 
			Font fntGamePlay=con.loadFont("BilonaMedium-2v6W3.ttf",80);
			con.setDrawFont(fntGamePlay);
			con.setDrawColor(new Color(0, 0, 0));
			con.repaint();
			con.drawString("Write joke",300,300);
			
		}
							
	}
}
