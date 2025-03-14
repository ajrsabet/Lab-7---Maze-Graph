package ui;

public class Console {
    public void printMaze(int[][] maze) {
        System.out.print("\033[H\033[2J"); // clear console

        System.out.println("START");
        for (int[] row : maze) {
            for (int cell : row) {
                switch (cell) {
                    case 0 -> { System.out.print("  ");} // Unicode block for walls
                    case 2 -> { System.out.print("<>");} // Unicode block for walls
                    case 3 -> { System.out.print("XX");} // Unicode block for walls
                    case 4 -> { System.out.print("..");} // Unicode block for walls
                    default -> System.out.print("██"); // Unicode block for walls
                }
                }
            System.out.println();
        }
        
        for (int i = 0; i < maze[0].length - 2; i++) {
            System.out.print("  ");
        }
        System.out.println("END");
    }
}
