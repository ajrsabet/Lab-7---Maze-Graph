package graph;

import java.util.*;

public class MazeGenerator {
    private static final int WALL = 1;
    private static final int PATH = 0;
    private static final int[][] DIRECTIONS = {{-2, 0}, {2, 0}, {0, -2}, {0, 2}}; // Moves in 2-cell steps

    public int[][] generateMaze(int rows, int cols) {
        int[][] maze = new int[rows][cols];

        // Fill the maze with walls
        for (int[] row : maze) {
            Arrays.fill(row, WALL);
        }

        // Start from the top left corner
        int startX = 1;
        int startY = 1;

        // DFS to create paths
        Random rand = new Random();
        dfs(maze, startX, startY, rand);

        // Set the start and end points of the maze
        maze[0][1] = 2;
        maze[rows - 1][cols - 2] = PATH;

        return maze;
    }

    // depth first search for creating the maze
    private static void dfs(int[][] maze, int x, int y, Random rand) {
        maze[x][y] = PATH; // Mark current cell as a path

        // Shuffle directions to randomize the maze
        List<int[]> dirs = Arrays.asList(DIRECTIONS.clone());
        Collections.shuffle(dirs, rand);

        for (int[] dir : dirs) {
            int newX = x + dir[0], newY = y + dir[1];

            if (newX > 0 && newY > 0 && newX < maze.length - 1 && newY < maze[0].length - 1 && maze[newX][newY] == WALL) {
                // Knock down the wall between
                maze[x + dir[0] / 2][y + dir[1] / 2] = PATH;
                dfs(maze, newX, newY, rand);
            }
        }
    }

    // BFS to find the shortest path
    public static void bfs(int[][] maze, int startX, int startY) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] distance = new int[rows][cols];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right
    
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        distance[startX][startY] = 0;
    
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
    
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
    
                if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && maze[newX][newY] != WALL && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    distance[newX][newY] = distance[x][y] + 1;
    
                    // If we reach the end point, backtrack to mark the path
                    if (newX == rows - 1 && newY == cols - 2) {
                        System.out.println("Shortest path length: " + distance[newX][newY]);
                        markPath(maze, distance, newX, newY, startX, startY);
                        return; // return distance;
                    }
                }
            }
        }
        System.out.println("No path found.");
    }
    
    private static void markPath(int[][] maze, int[][] distance, int endX, int endY, int startX, int startY) {
        int x = endX;
        int y = endY;
        maze[x][y] = 3; // Mark the end point
    
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right
    
        while (x != startX || y != startY) {
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
    
                if (newX >= 0 && newY >= 0 && newX < maze.length && newY < maze[0].length && distance[newX][newY] == distance[x][y] - 1) {
                    x = newX;
                    y = newY;
                    maze[x][y] = 4; // Mark the path
                    break;
                }
            }
        }
    }
}