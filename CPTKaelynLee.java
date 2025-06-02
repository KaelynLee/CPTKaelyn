import arc.*;

public class CPTKaelynLee{
	public static void main(String[] args){
		Console con = new Console();
		
		String strName;
		String strType;
		int intCount=0
		
		con.println("Give me your name");
		strName = con.readLine();
		
		con.println("Play Game");
		
		con.println("View Leaderboard");
		
		con.println("Add Quiz");
		
		con.println("Quit");
		
		
		TextInputFile masterfile = new TextInputFile("quizzes.txt");
		while(masterfile.eof() == false){
			strType = masterfile.readLine();
			intCount++;
			con.println(strType);
		
		if(intCount = 1){
			con.println
			
			
			}
		}
		
	}
}
