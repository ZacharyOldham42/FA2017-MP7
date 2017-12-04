import java.util.Scanner;

public class GameOfLife {
	private boolean[][] grid = new boolean[0][0];
	private int height = 0;
	private int width = 0;
	private Scanner scan = new Scanner(System.in);
	
	// TODO: Driving main method
	public static void main(String[] args) {
	}

	// TODO: Method to draw grid
	// Example of a grid with height 2 and width 3
	//   1 2 3
	// 1| | | |
	// 2| | | |
	public void drawGrid(boolean[][] grid) {
		
	}	
	
	// TODO: Method to return the next 'frame' of the game
	public boolean[][] getNextFrame(boolean[][] grid) {
		return grid;
	}
	
	// TODO: Method to determine whether a space should be alive or dead next frame
	public boolean isAlive(boolean[][] grid, int x, int y) {
		return false;
	}
	
	// Method to get user input
	public void getUserInput() {
		System.out.println("Please enter the desired grid width: ");
		width = scan.nextInt();
		System.out.println("Please enter the desired grid height: ");
		height = scan.nextInt();
		grid = new boolean[height][width];
		System.out.println("Please enter starting coordinates of the form '(h1,w1) (h2,w2)': ");
		String temp = scan.nextLine();
		String[] splitted = temp.split(" ", 0);
		for (String tuple: splitted) {
			String[] secondSplit = tuple.split(",", 0);
			int tempHeight = Integer.parseInt(secondSplit[0].substring(1, secondSplit[0].length()));
			int tempWidth = Integer.parseInt(secondSplit[1].substring(0, secondSplit[1].length() - 1));
			grid[tempHeight][tempWidth] = true;
		}
		// At this point we are done gathering user input
	}
}