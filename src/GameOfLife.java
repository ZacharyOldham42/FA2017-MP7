import java.util.Scanner;

public class GameOfLife {
	private boolean[][] grid = new boolean[0][0];
	private int height = 0;
	private int width = 0;
	private Scanner scan = new Scanner(System.in);
	
	public GameOfLife() {
		getUserInput();
	}
	
	// TODO: Driving main method
	public static void main(String[] args) {
		GameOfLife game = new GameOfLife();
		game.drawGrid();
	}

	// TODO: Method to draw grid
	// Example of a grid with height 2 and width 3
	//   1 2 3
	// 1| |0| |
	// 2| | |0|
	public void drawGrid() {
		// Print the two space buffer for the first row
		System.out.print("  ");
		// Print the column numbers
		for(int i = 1; i <= width; i++) {
			System.out.print(i);
			System.out.print(' ');
		}
		System.out.println();
		// Print the rows
		for(int i = 1; i <= height; i++) {
			System.out.print(i);
			System.out.print('|');
			for(int j = 0; j < width; j++) {
				char fill = ' ';
				if (grid[i - 1][j]) {
					fill = '0';
				}
				System.out.print(fill);
				System.out.print('|');
			}
			System.out.println();
		}
	}	
	
	// TODO: Method to return the next 'frame' of the game
	public boolean[][] getNextFrame() {
		boolean[][] temp = new boolean[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				temp[i][j] = isAlive(i, j);
			}
		}
		return temp;
	}
	
	// TODO: Method to determine whether a space should be alive or dead next frame
	public boolean isAlive(int tempHeight, int tempWidth) {
		return false;
	}
	
	// Method to get user input
	public void getUserInput() {
		System.out.println("Please enter the desired grid height: ");
		height = scan.nextInt();
		System.out.println("Please enter the desired grid width: ");
		width = scan.nextInt();
		grid = new boolean[height][width];
		scan.nextLine();
		System.out.println("Please enter starting coordinates of the form '(h1,w1) (h2,w2)': ");
		String temp = scan.nextLine();
		String[] splitted = temp.split(" ", 0);
		for (String tuple: splitted) {
			String[] secondSplit = tuple.split(",", 0);
			int tempHeight = Integer.parseInt(secondSplit[0].substring(1, secondSplit[0].length()));
			int tempWidth = Integer.parseInt(secondSplit[1].substring(0, secondSplit[1].length() - 1));
			grid[tempHeight - 1][tempWidth - 1] = true;
		}
	}
}
