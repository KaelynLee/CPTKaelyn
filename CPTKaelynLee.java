import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

	public class CPTKaelynLee{
		public static void main(String[] args){
			Console con = new Console("Math Training Game",1280,720);
			
			//Name: Kaelyn Lee
			//Program: Math Training Game
			//Date: June 12, 2025
			//Version: 115.0.7204
			
			String strName = "";
			String strQuiz[][];
			String strType;
			int intCount=0;
			int intChoice;
			int intInterval=100;
			int intScore = 0;
			String strChooseSpecificQuiz[] = new String[100];
			int intQuizChoice = -1; 
			
			//1) MAIN MENU
			con.setDrawColor(Color.WHITE);
			con.fillRect(0,0,1366,768);
			con.setTextColor(Color.BLACK); 
			//set background colour white and font colour black
			
			Font fntTest = con.loadFont("NewminRegular-ov6aa.ttf", 70);
			con.setDrawFont(fntTest);
			con.setDrawColor(new Color(0, 0, 0));
			con.drawString("Math Training Game",345,45);
			//load new font and set game title
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
			//main menu options 
			con.setDrawColor(Color.WHITE);
			con.fillOval(0, 0, 350, 90);
			con.repaint();
			
			int intKey = con.getKey();	
				
			// 2) GAMEPLAY
			if(intKey == 'p' || intKey == 'P'){
				con.setDrawColor(Color.WHITE);
				con.fillRect(0,0,1366,768);
				con.setTextColor(Color.BLACK); 
				
				Font fntGamePlay=con.loadFont("BilonaMedium-2v6W3.ttf",60);
				con.setDrawFont(fntGamePlay);
				con.setDrawColor(new Color(0, 0, 0));
				
				con.drawString("Enter Name: ",300,300);
				con.setTextColor(Color.WHITE); 
				strName=con.readLine(); 
				//user inputs name and reads name
				con.drawString(strName,640,300);		
				con.setDrawColor(Color.WHITE);
				con.sleep(1500); 
				//wait 1500 before continue code
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
					//reward if user inputs specific name
				}
				
				TextInputFile masterfile = new TextInputFile("quizzes.txt");
				//input quiz type options onto screen for user to choose 
					
				strChooseSpecificQuiz = new String[100];
				
				con.setDrawColor(Color.WHITE);
				con.fillRect(0,0,1366,768);
				con.setTextColor(Color.BLACK); 
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
				}
		
				intQuizChoice = con.readInt();
				//read the quiz the user chooses to play - to load the info into array later
				
				if(intQuizChoice < 1){
					con.setDrawColor(Color.WHITE);
					con.fillRect(0,0,1366,768);
					Font fntPart = con.loadFont("BilonaMedium-2v6W3.ttf",100);
					con.setDrawFont(fntPart);
					con.setDrawColor(new Color(255, 0, 0));
					con.repaint();
					con.clear();
					con.drawString("Invalid Choice Selected",350,250);
					//Check whether quiz option is avaliable to choose from
				
				}else{
					con.setDrawColor(Color.WHITE);
					con.fillRect(0,0,1366,768);
					con.setTextColor(Color.BLACK);
					con.repaint();
				
					int intAnswerChecker=0;
					int intPress;
			
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
						intPress = con.getKey();
						//User click number to start the quiz 
				
			
						if(intPress == '1'){
							con.setDrawColor(Color.WHITE);
							con.fillRect(0,0,1366,768);
							con.repaint();
				
							strQuiz = new String[100][5];
							//Create a new 2D array (100 rows, 5 columns)
							//Column 0 = Question
							//Column 1 = Answer 1
							//Column 2 = Answer 2
							//Column 3 = Answer 3
							//Column 4 = Bubble Sort
					
							String strAnswer;
							String strQuestion;
							String strAnswer1;
							String strAnswer2;
							String strAnswer3;
							int intQuestion=0;
				
							TextInputFile userchoose = new TextInputFile(strChooseSpecificQuiz[intQuizChoice-1]);
							
							while(userchoose.eof() == false){
								strQuiz[intQuestion][0] = userchoose.readLine();
								strQuiz[intQuestion][1] = userchoose.readLine(); 
								strQuiz[intQuestion][2] = userchoose.readLine(); 
								strQuiz[intQuestion][3] = userchoose.readLine(); 
								intQuestion++;
								//Read and load the question and answers into array
							}
								//intBubbleCount++;
								//column 5 
								//	int intRow;
								//	intRow = strQuiz[intBubbleCount];
				
							for(intQuestion=0; intQuestion<10; intQuestion++){
								//for loop to display all 10 questions and get answer
								con.clear();
								con.setDrawColor(Color.WHITE);
								con.fillRect(0,0,1366,768);
								Font fntChecker=con.loadFont("BilonaMedium-2v6W3.ttf",50);
								con.setDrawFont(fntChecker);
								con.repaint();
								con.setDrawColor(new Color(0, 0, 0));
								Font fntTemporary=con.loadFont("BilonaMedium-2v6W3.ttf",20);
								con.setDrawFont(fntTemporary);
								con.drawString("Name: "+strName,50,50);
								con.drawString("Quiz Choice: "+strChooseSpecificQuiz[intQuizChoice - 1],200,50);
								Font fntReturn=con.loadFont("BilonaMedium-2v6W3.ttf",50);
								con.setDrawFont(fntReturn);
								con.drawString(strQuiz[intQuestion][0],10,100);	
								con.drawString("Answer: ",10,200);
								strAnswer = con.readLine();
					
								//Compare answer - Check if user answer is correct 
								//IF CORRECT:
								if(strAnswer.equalsIgnoreCase(strQuiz[intQuestion][1]) || strAnswer.equalsIgnoreCase(strQuiz[intQuestion][2]) || strAnswer.equalsIgnoreCase(strQuiz[intQuestion][3])){
									con.setDrawColor(new Color(0, 128, 0));
									con.repaint();
									con.drawString("Correct", 300,300);
									intAnswerChecker++;
									con.drawString("Current Score: "+intAnswerChecker+"/10",80,500);
									//display users current score after each question throughout the quiz
									//display correct - change into green colour 
						
								//IF INCORRECT:
								}else{
									con.setDrawColor(new Color(255, 0, 0));
									con.repaint();
									con.drawString("Wrong",300,300);
									con.drawString("Current Score: "+intAnswerChecker+"/10",100,500);
									//display users current score - no change if wrong
									//display wrong - change into red colour
								}
					
								con.sleep(1400); 
								con.clear();
				}
			}
					
			con.clear();
			con.setDrawColor(Color.WHITE);
			con.fillRect(0,0,1366,768);
			con.setDrawColor(new Color(0, 0, 225));
			con.repaint();
			con.drawString("Quiz Completed:",500,70);
			con.setDrawColor(new Color(0, 0, 0));
			con.repaint();
			con.drawString("Name: "+strName,200,200);
			con.drawString("Quiz Choice: "+strChooseSpecificQuiz[intQuizChoice - 1],200,300);
					
			if(strName.equalsIgnoreCase("statitan")){
				con.repaint();
				con.drawString("Score: "+"BONUS POINT (+1)",200,400);
				intAnswerChecker++;
				con.drawString(intAnswerChecker+"+1 BONUS"+"/10",200,500);
				intScore = Math.round(intAnswerChecker*100)/10;
				con.drawString("Percentage: "+intScore+"%",200,600);
				
				TextOutputFile endofquiz = new TextOutputFile("leaderboard.txt", true);
				endofquiz.println(strName);
				endofquiz.println(strChooseSpecificQuiz[intQuizChoice - 1]);
				endofquiz.println(intScore);
				endofquiz.close();
				//load user name, quiz name, score, and percent into leaderboard file 
				//Reward of extra point - user inputs name statitan
						
			}else if(!strName.equalsIgnoreCase("statitan")){
				con.repaint();
				con.drawString("Score: "+intAnswerChecker+"/10",200,400);
				intScore = Math.round(intAnswerChecker*100)/10;
				con.drawString("Percentage: "+intScore+"%",200,500);
				
				TextOutputFile endofquiz = new TextOutputFile("leaderboard.txt", true);
				endofquiz.println(strName);
				endofquiz.println(strChooseSpecificQuiz[intQuizChoice - 1]);
				intScore = finalscore(intAnswerChecker);
				endofquiz.println(intScore);
				endofquiz.close();
				//load all information without extra point - user didn't enter statitan as name
				}
			}
		}
		
			//3) VIEW LEADERBOARD
			}else if(intKey == 'v' || intKey == 'V'){
				con.setDrawColor(Color.WHITE);
				con.fillRect(0,0,1366,768);
				con.setTextColor(Color.BLACK); 
				con.clear();
				con.repaint();
				Font fntChecker=con.loadFont("BilonaMedium-2v6W3.ttf",80);
				con.setDrawFont(fntChecker);
				con.drawString("Leaderboard",300,100);
				
				String strLeaderboard[][];
				int intTESTCOUNT;
				int intARRAYTEST = 0;
				
				strLeaderboard  = new String[100][3];
				//Create new 2D array - 100 rows, 3 columns
				//Column 1 = User name
				//Colum 2 = Quiz name
				//Column 3 = Score 
				
				TextInputFile currentleader = new TextInputFile("leaderboard.txt");
				
				while(currentleader.eof() == false){
					strLeaderboard[intARRAYTEST][0] = currentleader.readLine();
					strLeaderboard[intARRAYTEST][1] = currentleader.readLine();
					strLeaderboard[intARRAYTEST][2] = currentleader.readLine();		
					
					intARRAYTEST++;
					//load all end of quiz information into array 
				}
				
				currentleader.close();
				
				int intCOUNTER;
				int intCOUNTER2;
				int intScore1;
				int intScore2;
				String strNameTemp;
				String strQuizTemp;
				String strScoreTemp;
				
				for(intCOUNTER=0; intCOUNTER<intARRAYTEST-1; intCOUNTER++){
					for(intCOUNTER2=0; intCOUNTER2<intARRAYTEST-intCOUNTER-1; intCOUNTER2++){
				
						intScore1=Integer.parseInt(strLeaderboard[intCOUNTER2][2].replace("%", ""));
						intScore2=Integer.parseInt(strLeaderboard[intCOUNTER2+1][2].replace("%", ""));
						//convert the users score into a integer - remove the percentage to compare
					
						if(intScore1<intScore2){
							//current score is less than the second score, then switch it
							//go through whole for loop and switch
							strNameTemp = strLeaderboard[intCOUNTER2][0];
							strLeaderboard[intCOUNTER2][0] = strLeaderboard[intCOUNTER2+1][0];
							strLeaderboard[intCOUNTER2+1][0] = strNameTemp;
								
							strQuizTemp = strLeaderboard[intCOUNTER2][1];
							strLeaderboard[intCOUNTER2][1] = strLeaderboard[intCOUNTER2+1][1];
							strLeaderboard[intCOUNTER2+1][1] = strQuizTemp;
							
							strScoreTemp = strLeaderboard[intCOUNTER2][2];
							strLeaderboard[intCOUNTER2][2] = strLeaderboard[intCOUNTER2+1][2];
							strLeaderboard[intCOUNTER2+1][2] = strScoreTemp;
						}
					}
				}
						
				for(intTESTCOUNT=0; intTESTCOUNT<intARRAYTEST; intTESTCOUNT++){
					con.println("Name: "+strLeaderboard[intTESTCOUNT][0]);	
					con.println("Quiz: "+strLeaderboard[intTESTCOUNT][1]);
					con.println("Score: "+strLeaderboard[intTESTCOUNT][2]);
					con.println("_______________________________________");
					//load the data into the console window screen to display to user 
				}
				
			//4) CREATE QUIZ
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
				//get new quiz name and create new quiz file in quizzes.txt
				
				for(intNewQuizCount=0; intNewQuizCount<=10; intNewQuizCount++){
					con.println("Question: ");
					strNewQuestion = con.readLine();
					con.println("Answer 1: ");
					strNewAnswer1 = con.readLine();
					con.println("Answer 2: ");
					strNewAnswer2 = con.readLine();
					con.println("Answer 3: ");
					strNewAnswer3 = con.readLine();
					//load through a for loop - get 10 questions each with 3 possible answers
					
					TextOutputFile newquiz = new TextOutputFile(strNewGameName +".txt");
					//enter the game name user creates and then .txt 
					newquiz.println(strNewQuestion);
					newquiz.println(strNewAnswer1);
					newquiz.println(strNewAnswer2);
					newquiz.println(strNewAnswer3);
					//save information into new game file 
			}
					
					con.clear();
					con.repaint();
					con.drawString("Quiz Saved",300,300);
					//quiz saved = new game can be played now 
		}
			
			//5) HELP
			else if(intKey == 'h' || intKey == 'H'){
				con.setDrawColor(Color.WHITE);
				con.fillRect(0,0,1366,768);
				con.setTextColor(Color.BLACK); 
				Font fntGamePlay=con.loadFont("BilonaMedium-2v6W3.ttf",30);
				con.setDrawFont(fntGamePlay);
				con.setDrawColor(new Color(0, 0, 0));
				con.repaint();
				con.drawString("Help",350,50);
				con.clear();
				con.repaint();
				con.drawString("TO PLAY: Click the key (p), enter your name, choose a quiz option, and click 1 to start quiz",5,100);
				con.repaint();
				con.drawString("TO CREATE A NEW QUIZ: Click the key (c), enter new quiz name, enter Question 1; Answer 1; Answer 2,",5,200);
				con.drawString("Answer 3..., choose and play your new game in the  play section!",5,240);
				con.repaint();
				con.drawString("TO VIEW LEADERBOARD: Click the key (v), see the current highest record",5,350);
				con.repaint();
				con.drawString("TO QUIT: Click the key (q) and it will automatically close the game",5,450);
				//help section includes tips for each function of the game
				
			//6) QUIT
			}else if(intKey == 'q' || intKey == 'Q'){
				System.exit(0);
				//quit will close console window
			
			//7) SECRET MENU
			}else if(intKey == 's' || intKey == 'S'){
				con.setDrawColor(Color.WHITE);
				//draw colour is white to hide the secret menu in the main screen - still opens if user clicks 's' key
				con.fillRect(0,0,1366,768);
				con.setTextColor(Color.BLACK); 
				Font fntGamePlay=con.loadFont("BilonaMedium-2v6W3.ttf",60);
				con.setDrawFont(fntGamePlay);
				con.setDrawColor(new Color(0, 0, 0));
				con.repaint();
				con.drawString("What do you call a sleeping T-Rex?",150,200);
				//load joke question 
				con.clear();
				con.sleep(1300);
				//clear console window and give user time to think about joke answer
				con.repaint();
				con.drawString("A dino-snore!",200,450);
				//show answer to joke after 1300
			}						
		}
	
		public static int finalscore(int intAnswerChecker){
			int intScore;
			intScore = Math.round(intAnswerChecker*100)/10;
			return intScore;
		}
	}
