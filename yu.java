public class TeachingWerewolfGame {
    static class player (

        private int id;
        private string role;
        private boolean alive;
        
        public piayer() {
            this.id = id;
            this.role = role;
            this.alive = true;
        }

        public int getID() {
            return this.id;
        }

        public int getRole() {
            return role;
        }

        public int isAlive() {
            return alive;
        }

        public void kill() {
            alive = false;
        }

        public string getpublicInfo() {
            if(alive){
                return "player " + id + "[Alive]";
            }else{
                return "player " + id + "[Dead]";
            }
        }
        public static void main(string[] args) {
            Scanner sc = new Scanner(system.in);
            Random rand = new Random;

            System.out.printIn("wolfGame");
            System.out.printIn("Enter5 number of players(4~10)");
            int n = sc.nextInt();
            sc.nextLine();

            while (n < 4 || n >10  ) {
                system.out.printIn()
            }
            player[] players = new piayer[n];
            int wolfIndex = rand.nextInt();

            for (int i= 0;i< n; i++) {
                if (i == wolfIndex) {
                    players[i] = new player(i+1,role = "Werewolf");   
                }else{
                    players[i] = nwe player(i+1,role = "Villager");
                }
                
            }

            system.out.println();
            system.out.print("Role assignment start.");
            system.out.print("Each player take turn to role");
            for(int i = 0; i < n ; i++){
                system.out.printIn();
                system.out.printIn("player",+(i + 1),"please Enter");
                sc.nextLine();
                system.out.printIn("You Role:" + players[i].getRole());
                system.out.print("Memorize your role,then turn");
                sc.nextLine();
                for(int line = 0; line < 30; line++) {
                    system.out.printIn();
                }
            }
            boolean gameOver = false;
            int round = 1;

            while(gameOver){
                system.out.printIn("Round",+round);
                system.out.printIn();
                
                System.out.printIn("Night falls. Werewolf wakes up.");
                int aliveWolf = findAliveWereWolf(players);
                if(aliveWereWolf ! = -1;){
                    System.OUT.printIn("Werewolf is your turn.");
                    system.out.printIn("Alive player");
                    printAlivePlayers(Players);

                    int tsrget = -1;

                    while(turn){System.out.println("choose a player to kill");
    if(sc.hasNext()){
        targetId = sc.nextInt();
        System.out.println();

        if(isValidTarget(targetId, players[aliveWerewolf].getID())){
            break;
        }else{
            System.out.println("Invalid target. Please choose an alive player.");
            sc.nextLine();
        }
    }
}

players[targetId - 1].kill();
System.out.println("Night results: Player" + targetId + "has been killed.");
}else{
    System.out.println("No werewolf alive. Skipping night phase.");
}

if(checkKillvillagerwin(players)){
    System.out.println("Villagers win! All werewolves have been killed.");
    gameOver = true;
}else if(checkKillwerewolfwin(players)){
    System.out.println();
    System.out.println("Werewolf win! All villagers have been killed.");
    gameOver = true;
}

if(gameOver){
    break;
}

int voteId = -1;

public static void printAlivePlayers(Player[] players){
    for(int i = 0; i < players.length; i++){
        if(players[i].isAlive() && players[i].getRole().equals("Werewolf")){
            return i;
        }
    }
    return -1;
}

public static void printAlivePlayers(Player[] players){
    for(int i = 0; i < players.length; i++){
        System.out.println(players[i].getPublicInfo());
    }
}}
                }
            }
        
    
