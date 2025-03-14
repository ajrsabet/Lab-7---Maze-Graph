# Maze Graph

This project implements a maze generator and solver using Depth-First Search (DFS) and Breadth-First Search (BFS) algorithms. The maze is generated randomly, and the shortest path can be found using BFS.

## Project Structure

- `graph/MazeGenerator.java`: Contains the maze generation and BFS algorithm to find the shortest path.
- `ui/GamePlay.java`: Handles the user interface and gameplay logic.
- `util/TestInput.java`: Utility class for handling user input.
- `Console.java`: Utility class for printing the maze.

## How to Run

1. Compile the Java files:
    ```sh
    javac graph/MazeGenerator.java ui/GamePlay.java util/TestInput.java Console.java
    ```

2. Run the `GamePlay` class:
    ```sh
    java ui.GamePlay
    ```

## Controls

- `w`: Move up
- `a`: Move left
- `s`: Move down
- `d`: Move right
- `h`: Get a hint (find the shortest path using BFS)
- `p`: Pause the game

## Example

When you run the game, you will see the maze printed in the console. Use the controls to navigate through the maze. Press `h` to get a hint and see the shortest path marked in the maze.

## BFS Algorithm

The BFS algorithm is used to find the shortest path in the maze. It explores all possible paths level by level and marks the shortest path with the value `3`.
