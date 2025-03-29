/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
package SportsTeamApp;
public class Team {
    private String teamName = "";
    private String[] players = new String[20];
    private int playerCount=0;
    
    public Team(String teamName){
        this.teamName = teamName;
    }
    
    public void addPlayer(String player){
        players[playerCount] = player;
        playerCount++;
    }

    public String[] getPlayers(){
        return players;
    }

    public int getplayerCount(){
        return playerCount;
    }
    public String getTeamName(){
        return teamName;
    }

    
}
