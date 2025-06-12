import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTKaelynLee{
	public static void main(String[] args){
		Console con = new Console("Math Training Game",1280,720);
		
		String strName = "";
		String strQuiz[][];
		String strType;
		int intCount=0;
		int intChoice;
		int intInterval=100;
		int intScore = 0;
		String strChooseSpecificQuiz[] = new String[100];
		int intQuizChoice = -1; 
		
		
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
			con.setTextColor(Color.WHITE); 
			strName = con.readLine(); 
			con.drawString(strName,640,300);		
			con.setDrawColor(Color.WHITE);
			con.sleep(1500); 
			con.setTextColor(Color.BLACK);
			con.fillRect(0,0,1366,768);
			con.setDrawColor(new Color(0, 0, 0));
			con.setDrawFont(fntGamePlay);
			con.drawString((strName),600,300);
			con.repaint();
			con.clear();
		
		if(strName.equalsIgnoreCase("statitan")){
			con.clear();
			con.repaint();
			con.drawString("BONUS POINT",300,400);
			
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
		

		intQuizChoice = con.readInt();
		
		if(intQuizChoice < 1){
			con.setDrawColor(Color.WHITE);
			con.fillRect(0,0,1366,768);
			Font fntPart = con.loadFont("BilonaMedium-2v6W3.ttf",100);
			con.setDrawFont(fntPart);
			con.setDrawColor(new Color(255, 0, 0));
			con.repaint();
			con.clear();
			con.drawString("Invalid Choice Selected",350,250);
			
		}else{
			con.setDrawColor(Color.WHITE);
			con.fillRect(0,0,1366,768);
			con.setTextColor(Color.BLACK);
			con.repaint();
		
		int intAnswerChecker=0;
		
			
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
			
			
			//intBubbleCount++;
		//	int intRow;
			
		//	intRow = strQuiz[intBubbleCount];
			
			
			
			
			
			
			for(intQuestion=0; intQuestion<10; intQuestion++){
				con.println(strQuiz[intQuestion][0]);	
				con.println("Answer: ");
				strAnswer = con.readLine();
				
				if(strAnswer.equalsIgnoreCase(strQuiz[intQuestion][1]) || strAnswer.equalsIgnoreCase(strQuiz[intQuestion][2]) || strAnswer.equalsIgnoreCase(strQuiz[intQuestion][3])){
					con.println("Correct");
					intAnswerChecker++;
					con.println("Current Score: "+intAnswerChecker+"/10");
					
				}else{
					con.println("Wrong");
					con.println("Current Score: "+intAnswerChecker+"/10");
					
				}
				
			con.sleep(1400); 
			con.clear();
					
			}
			
		}
				
				con.println(strName);
				con.println(strChooseSpecificQuiz[intQuizChoice - 1]);
				
				if(strName.equalsIgnoreCase("statitan")){
					con.drawString("BONUS POINT (+1)",300,400);
					intAnswerChecker++;
					con.println(intAnswerChecker+"+1 BONUS"+"/10");
					intScore = Math.round(intAnswerChecker*100)/10;
					con.println(intScore+"%");
					TextOutputFile endofquiz = new TextOutputFile("leaderboard.txt", true);
					endofquiz.println(strName);
					endofquiz.println(strChooseSpecificQuiz[intQuizChoice - 1]);
					endofquiz.println(intScore + "%");
					endofquiz.close();
					
				}else if(!strName.equalsIgnoreCase("statitan")){
					con.println(intAnswerChecker+"/10");
					intScore = Math.round(intAnswerChecker*100)/10;
					con.println(intScore+"%");
					TextOutputFile endofquiz = new TextOutputFile("leaderboard.txt", true);
					endofquiz.println(strName);
					endofquiz.println(strChooseSpecificQuiz[intQuizChoice - 1]);
					endofquiz.println(intScore + "%");
					endofquiz.close();
				}
		}
	}
	
		}else if(intKey == 'v' || intKey == 'V'){
			
			con.setDrawColor(Color.WHITE);
			con.fillRect(0,0,1366,768);
			con.setTextColor(Color.BLACK); 
			con.clear();
			con.repaint();
			con.println("Leaderboard");
			
			String strLeaderboard[][];
			int intTESTCOUNT;
			int intARRAYTEST = 0;
			
			strLeaderboard  = new String[100][3];
			TextInputFile currentleader = new TextInputFile("leaderboard.txt");
			
			while(currentleader.eof() == false){
				strLeaderboard[intARRAYTEST][0] = currentleader.readLine();
				strLeaderboard[intARRAYTEST][1] = currentleader.readLine();
				strLeaderboard[intARRAYTEST][2] = currentleader.readLine();
				intARRAYTEST++;
			
			}
			
			currentleader.close();
			
			//con.repaint();
			con.clear();
			
			for(intTESTCOUNT=0; intTESTCOUNT<intARRAYTEST; intTESTCOUNT++){
				con.println("Name: "+strLeaderboard[intTESTCOUNT][0]);	
				con.println("Quiz: "+strLeaderboard[intTESTCOUNT][1]);
				con.println("Score: "+strLeaderboard[intTESTCOUNT][2]);
				con.println("_______________________________________");
				
			}
			
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
			con.clear();
			con.repaint();
			con.println("TO PLAY: Click the key (p), enter your name, choose a quiz option, and click 1 to start quiz");
			con.println("TO CREATE A NEW QUIZ: Click the key (c), enter new quiz name, enter Question 1; Answer 1; Answer 2; Answer 3..., choose and play your new game in the  play section!");
			con.println("TO VIEW LEADERBOARD: Click the key (v), see the current highest record");
			con.println("TO QUIT: Click the key (q) and it will automatically close the game");
		
		}else if(intKey == 'q' || intKey == 'Q'){
			System.exit(0);
		
		}else if(intKey == 's' || intKey == 'S'){
			con.setDrawColor(Color.WHITE);
			con.fillRect(0,0,1366,768);
			con.setTextColor(Color.BLACK); 
			Font fntGamePlay=con.loadFont("BilonaMedium-2v6W3.ttf",60);
			con.setDrawFont(fntGamePlay);
			con.setDrawColor(new Color(0, 0, 0));
			con.repaint();
			con.drawString("What do you call a sleeping T-Rex?",150,200);
			con.clear();
			con.sleep(1300);
			con.repaint();
			con.drawString("A dino-snore!",200,450);
			
		}
							
	}
}
