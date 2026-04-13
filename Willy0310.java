import java.util.*;

public class Willy0310 {

    static class Player {
        int id;
        String role;
        boolean alive = true;

        Player(int id, String role) {
            this.id = id;
            this.role = role;
        }

        void kill() {
            alive = false;
        }

        void revive() {
            alive = true;
        }
    }

    static void printAlive(Player[] players) {
        for (Player p : players) {
            if (p.alive) {
                System.out.println("Player " + p.id);
            }
        }
    }

    static int find(Player[] players, String role) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].alive && players[i].role.equals(role)) {
                return i;
            }
        }
        return -1;
    }

    static boolean villagersWin(Player[] players) {
        for (Player p : players) {
            if (p.alive && p.role.equals("Werewolf"))
                return false;
        }
        return true;
    }

    static boolean werewolfWin(Player[] players) {
        int wolf = 0, good = 0;
        for (Player p : players) {
            if (p.alive) {
                if (p.role.equals("Werewolf")) wolf++;
                else good++;
            }
        }
        return wolf >= good;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int n = 6;
        Player[] players = new Player[n];

        boolean antidote = true;
        boolean poison = true;

        int wolf = rand.nextInt(n);
        int seer, witch;

        do { seer = rand.nextInt(n); } while (seer == wolf);
        do { witch = rand.nextInt(n); } while (witch == wolf || witch == seer);

        for (int i = 0; i < n; i++) {
            if (i == wolf) players[i] = new Player(i + 1, "Werewolf");
            else if (i == seer) players[i] = new Player(i + 1, "Seer");
            else if (i == witch) players[i] = new Player(i + 1, "Witch");
            else players[i] = new Player(i + 1, "Villager");
        }

        System.out.println("==== 6人狼人殺 ====");
        System.out.println("角色：狼人1、預言家1、女巫1、村民3");

        sc.nextLine();

        // 顯示角色
        for (int i = 0; i < n; i++) {
            System.out.println("\n玩家 " + (i + 1) + " 按 Enter 看身分");
            sc.nextLine();
            System.out.println("你的角色是：" + players[i].role);
            sc.nextLine();
            for (int j = 0; j < 20; j++) System.out.println();
        }

        int round = 1;

        while (true) {
            System.out.println("\n===== 第 " + round + " 回合 =====");

            int target = -1;

            // 狼人
            int w = find(players, "Werewolf");
            if (w != -1) {
                System.out.println("\n狼人行動");
                printAlive(players);

                while (true) {
                    System.out.print("選擇要殺的人：");
                    target = sc.nextInt();

                    if (target >= 1 && target <= n &&
                        players[target - 1].alive &&
                        target != players[w].id)
                        break;

                    System.out.println("錯誤，重選");
                }

                players[target - 1].kill();
            }

            // 預言家
            int s = find(players, "Seer");
            if (s != -1) {
                System.out.println("\n預言家行動");
                printAlive(players);

                int check;
                while (true) {
                    System.out.print("查驗玩家：");
                    check = sc.nextInt();

                    if (check >= 1 && check <= n && players[check - 1].alive)
                        break;
                }

                System.out.println("他是：" + players[check - 1].role);
            }

            // 女巫
            int wt = find(players, "Witch");
            if (wt != -1) {
                System.out.println("\n女巫行動");

                if (target != -1 && antidote) {
                    System.out.print("是否救人(y/n)：");
                    String c = sc.next();
                    if (c.equalsIgnoreCase("y")) {
                        players[target - 1].revive();
                        antidote = false;
                    }
                }

                if (poison) {
                    System.out.print("是否毒人(y/n)：");
                    String c = sc.next();

                    if (c.equalsIgnoreCase("y")) {
                        printAlive(players);
                        int p;
                        while (true) {
                            System.out.print("毒誰：");
                            p = sc.nextInt();
                            if (p >= 1 && p <= n && players[p - 1].alive)
                                break;
                        }
                        players[p - 1].kill();
                        poison = false;
                    }
                }
            }

            if (villagersWin(players)) {
                System.out.println("好人勝利！");
                break;
            }
            if (werewolfWin(players)) {
                System.out.println("狼人勝利！");
                break;
            }

            // 白天
            System.out.println("\n白天投票");
            printAlive(players);

            int vote;
            while (true) {
                System.out.print("投誰：");
                vote = sc.nextInt();
                if (vote >= 1 && vote <= n && players[vote - 1].alive)
                    break;
            }

            players[vote - 1].kill();

            if (villagersWin(players)) {
                System.out.println("好人勝利！");
                break;
            }
            if (werewolfWin(players)) {
                System.out.println("狼人勝利！");
                break;
            }

            round++;
        }

        System.out.println("\n最終角色：");
        for (Player p : players) {
            System.out.println("玩家 " + p.id + " → " + p.role);
        }

        sc.close();
    }
}