package ui;

import graph.MazeGenerator;
import util.TestInput;

public class GamePlay {
    Console console = new Console();
    TestInput input = new TestInput();
    MazeGenerator mazeGen = new MazeGenerator();
    

    public void play (int[][] maze){
        // int maze[][] = maze;
        int posX = 1; // starting x position
        int posY = 0; // starting y position
        int steps = 0;
        // int solveMaze[][] = new int[maze.length][maze[0].length];
        boolean gameOver = false;

        while (gameOver == false) {
            console.printMaze(maze);
            System.out.println("Controls: up(w), left(d), down(s), right(a) + ENTER");
            System.out.println("Other options: hint(h), pause(p) + ENTER");
            char chars[] = {'w', 's', 'a', 'd', 'h', 'p'};
            System.out.println("Steps: " + steps);
            char move = input.TestChar(chars);
            try {
                switch (move) {
                    case 'w' -> {
                        if (maze[posY - 1][posX] != 1) {
                            posY -= 1;
                            maze[posY][posX] = (maze[posY][posX] == 0) ? 2 : 3; // mark as path or visited
                            steps++;
                        } 
                    }
                    case 'a' -> {
                        if (maze[posY][posX - 1] != 1) {
                            posX -= 1;
                            maze[posY][posX] = (maze[posY][posX] == 0) ? 2 : 3; // mark as path or visited
                            steps++;
                        }
                    }
                    case 's' -> {
                        if (maze[posY + 1][posX] != 1) {
                            posY += 1;
                            maze[posY][posX] = (maze[posY][posX] == 0) ? 2 : 3; // mark as path or visited
                            steps++;
                        }
                    }
                    case 'd' -> {
                        if (maze[posY][posX + 1] != 1) {
                            posX += 1;
                            maze[posY][posX] = (maze[posY][posX] == 0) ? 2 : 3; // mark as path or visited 
                            steps++;
                        }
                    }
                    case 'h' -> {mazeGen.bfs(maze, posX, posY);}         
                    case 'p' -> {gameOver = true;}         
                    default -> {}
                }   
                if (posY == maze.length - 1 && posX == maze[0].length - 2) {
                    gameOver = true;
                    System.out.println("Congratulations! You've reached the end of the maze in " + steps + " steps.");
                }
                
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You hit a wall! Try again.");
            }
            
            
        }
    }
}
