/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
import java.util.Arrays;
import java.util.Scanner;

public class SportsTeamApp{
    public static void main(String[] args) {
    Team[] teamArray = new Team[100];
  

    Scanner input = new Scanner(System.in);
    System.out.println("  Welcome to the Sports Team App");
    System.out.println();
    
    String teamLoopContinue = "y";
    while (teamLoopContinue.compareToIgnoreCase("y")==0){
   
    System.out.print("  Enter a team name:  ");
    int teamIndex = 0;
    String teamName = input.next();
    teamArray[teamIndex] = new Team(teamName);
    String  players = "";

    System.out.println();
    System.out.println("  Enter the player names:  ");
    System.out.print("    hint: use commas for multiple players; no spaces:  ");
        
    players = input.next();

    String[] playersArray = players.split(",");
  
    for(int b = 0;b < playersArray.length;b++)
    {
        teamArray[teamIndex].addPlayer(playersArray[b]);
    }
    String printPlayers = "";
    String[] returnedArray = teamArray[teamIndex].getPlayers();

    for(int b = 0; b < teamArray[teamIndex].getplayerCount();b++){
       
        printPlayers = printPlayers + returnedArray[b];
        
        
        if( b < teamArray[teamIndex].getplayerCount() - 1)
        {
             printPlayers = printPlayers + ",";
         }
     }


    System.out.println();
    System.out.println("  --Team Summary--");
    System.out.println("  Number of players in team:  " + teamArray[teamIndex].getplayerCount());

    System.out.println("  Players on team:  " + printPlayers);
    System.out.println();
  System.out.print("  Continue?  (y/n):  ");
    teamLoopContinue = input.next();
    teamIndex++;
}
System.out.println();
System.out.println("  End of line...");
}

}
