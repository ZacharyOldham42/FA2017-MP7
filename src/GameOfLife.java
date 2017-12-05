import java.io.IOException;
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
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				System.out.println();
			}
			game.drawGrid();
			game.grid = game.getNextFrame();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
					fill = 0x2588;
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
	public boolean isAlive(int spaceX, int spaceY) {
		int[] neighborsX = {-1,  0,  1, 1, 1, 0, -1, -1}; //top left to mid left clockwise
        int[] neighborsY = {-1, -1, -1, 0, 1, 1,  1,  0}; //top left to mid left clockwise
        boolean cell = false;
        int numalive = 0;
        boolean alive = grid[spaceX][spaceY];
        for (int i = 0; i < neighborsX.length; i++) {
            if (spaceX + neighborsX[i] >= 0 && spaceX + neighborsX[i] <= width-1) {
                if (spaceY + neighborsY[i] >= 0 && spaceY + neighborsY[i] <= height-1) {
                    cell = grid[spaceX + neighborsX[i]][spaceY + neighborsY[i]];
                    if (cell) {
                        numalive++;
                    }
                }
            }
        }
        if (alive && numalive < 2) {
            return false; //underpopulation
        } else if (alive && (numalive == 2 || numalive == 3)) {
            return true; //lives on
        } else if (alive && numalive > 3) {
            return false; //overpopulation
        } else if (!alive && numalive == 3) {
            return true;
        }
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
