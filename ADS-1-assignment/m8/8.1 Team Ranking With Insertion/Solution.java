import java.util.Scanner;
/**
 * { item_description }.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        TeamAdd addTeam = new TeamAdd();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            addTeam.Add(tokens);
        }
        addTeam.SelectionSort();
        addTeam.print();

    }
}
/**
 * Class for team.
 */
class Team {
    /**
     * { var_description }.
     */
    private String name;
    /**
     * { var_description }.
     */
    private int wins;
    /**
     * { var_description }.
     */
    private int loses;
    /**
     * { var_description }.
     */
    private int draws;
    /**
     * Constructs the object.
     *
     * @param      info  The information
     */
    Team(String[] info) {
        name = info[0];
        wins = Integer.parseInt(info[1]);
        loses = Integer.parseInt(info[2]);
        draws = Integer.parseInt(info[3]);
    }
    /**
     * Gets the wins.
     *
     * @return     The wins.
     */
    public int getWins() {
        return wins;
    }
    /**
     * Gets the loses.
     *
     * @return     The loses.
     */
    public int getLoses() {
        return loses;
    }
    /**
     * Gets the draws.
     *
     * @return     The draws.
     */
    public int getDraws() {
        return draws;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }

}
/**
 * Class for team add.
 */
class TeamAdd {
    /**
     * { var_description }.
     */
    Team[] teams;
    /**
     * { var_description }.
     */
    int size  = 0;
    /**
     * Constructs the object.
     */
    TeamAdd() {
        teams = new Team[10];
    }
    /**
     * { function_description }.
     *
     * @param      info  The information
     */
    public void Add(final String[] info) {
        teams[size++] = new Team(info);
    }
    /**
     * { function_description }.
     *
     * @param      index1  The index 1
     * @param      index2  The index 2
     */
    public void swap(final int index1, final int index2) {
        Team temp;
        temp = teams[index1];
        teams[index1] = teams[index2];
        teams[index2] = temp;
    }
    /**
     * { function_description }.
     */
    public void SelectionSort() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (teams[i].getWins() < teams[j].getWins()) {
                    swap(i, j);
                } else if (teams[i].getWins() == teams[j].getWins()) {
                    if (teams[i].getLoses() > teams[j].getLoses()) {
                        swap(i, j);
                    } else if (teams[i].getLoses() == teams[j].getLoses()) {
                        if (teams[i].getDraws() < teams[j].getDraws()) {
                            swap(i, j);
                        }
                    }
                }
            }
        }
    }
    /**
     * { function_description }.
     */
    public void print() {
        for (int i = 0; i < size - 1; i++) {
            System.out.print(teams[i].getName() + ",");
        } System.out.println(teams[size - 1].getName());
    }
}
