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
            addTeam.add(tokens);
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
        int i = 0;
        name = info[i];
        wins = Integer.parseInt(info[++i]);
        loses = Integer.parseInt(info[++i]);
        draws = Integer.parseInt(info[++i]);
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
    private Team[] teams;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    TeamAdd() {
        final int ten = 10, zero = 0;
        teams = new Team[ten];
        size = zero;
    }
    /**
     * { function_description }.
     *
     * @param      info  The information
     */
    public void add(final String[] info) {
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
