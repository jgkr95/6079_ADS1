import java.util.Scanner;
class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
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
class Team {
	private String name;
	private int wins;
	private int loses;
	private int draws;

	Team(String[] info) {
		name = info[0];
		wins = Integer.parseInt(info[1]);
		loses = Integer.parseInt(info[2]);
		draws = Integer.parseInt(info[3]);
	}
	public int getWins() {
		return wins;
	}
	public int getLoses() {
		return loses;
	}
	public int getDraws() {
		return draws;
	}
	public String getName() {
		return name;
	}

}
class TeamAdd {
	Team[] teams;
	int size  = 0;
	TeamAdd() {
		teams = new Team[10];
	}
	public void Add(String[] info) {
		teams[size++] = new Team(info);
	}
	public void swap(int index1, int index2) {
		Team temp;
		temp = teams[index1];
		teams[index1] = teams[index2];
		teams[index2] = temp;
	}
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
	public void print() {
		for (int i = 0; i < size - 1; i++) {
			System.out.print(teams[i].getName() + ",");
		} System.out.println(teams[size - 1].getName());
	}
}
