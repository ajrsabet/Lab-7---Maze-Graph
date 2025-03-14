import graph.MazeGenerator;
import ui.GamePlay;
import util.TestInput;
import util.TypeWriter;

public class Main {
    public static void main(String[] args) {

        TypeWriter print = new TypeWriter();
        TestInput input = new TestInput();
        GamePlay game = new GamePlay();

        boolean session = true;

        print.SlowType("Welcome to the Maze Generator!");
        while (session) { 
            // menu
            print.SlowType("\nMenu");
            print.SlowType("1. Generate a new maze");
            // print.SlowType("2. Restart the current maze");
            print.SlowType("3. Exit\n");
            
            // get user input
            int menuChoice = input.TestInt(1,3);

            switch (menuChoice) {
                // generate new maze
                case 1 -> newMaze(print, input, game);  
                // reset current maze
                // case 2 -> game.play
                    
                
                // Exit
                case 3 -> session = false;  
                default -> print.SlowType("Invalid choice. Please select 1, 2, or 3.");
            }
        }
    }

    public static void newMaze(TypeWriter print, TestInput input, GamePlay game) {
        MazeGenerator mazeGen = new MazeGenerator();
        // prompt for maze size
        print.SlowType("What size of maze would you like to generate? (1. small, 2. medium, 3. large)");
            int size = input.TestInt(1, 3);
            int rows = 0, cols = 0;
            switch (size) { // small, medium, large
                case 1 -> { rows = 21; cols = 21; }
                case 2 -> { rows = 31; cols = 31; }
                case 3 -> { rows = 41; cols = 41; }
                default -> print.SlowType("Invalid choice. Please select 1, 2, or 3.");
            }

            if (size >= 1 && size <= 3) {
                int[][] maze = mazeGen.generateMaze(rows, cols);
                    game.play(maze);
            }
    }
}
