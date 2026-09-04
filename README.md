# Algorithmic Sudoku Solver & Constraints Engine

A highly optimized puzzle-solving engine built in **Java** that solves complex 9x9 Sudoku matrices. This project is a pure implementation of advanced algorithmic principles, simulating constraint satisfaction using deep recursion and pruning mechanisms.

## 🧠 Key Features & Concepts
* **Backtracking Paradigm:** Implements a localized brute-force backtracking mechanism that systematically explores potential path selections via tree-like decision states.
* **Efficient Pruning (DFS Simulation):** Prevents exponential time complexity blowup by executing immediate validity heuristics before diving deeper into the call stack.
* **O(1) Space Constraint Optimization:** Solves the entire puzzle *in-place* by mutating a mutable primitive 2D matrix (`int[][]`), bypassing excessive memory allocation.
* **Subgrid Submatrix Mapping:** Tracks localized 3x3 quadrant boundaries mathematically using matrix indexing patterns to confirm unique board constraints.

## 🛠️ Technical Details
* **Language:** Java (JDK 8+)
* **Data Structures Used:** 2D Primitives (`int[][]` grid array)
* **Algorithmic Complexity:** 
  * **Time Complexity:** \(O(9^{N})\) where N is the number of empty cells (Worst Case). Heavily optimized via immediate constraint checks.
  * **Space Complexity:** O(N) auxiliary space required by the recursive call stack depth.

## 📊 Terminal Execution Preview

```text
=== Unsolved Sudoku Board ===
5 3 . | . 7 . | . . . 
6 . . | 1 9 5 | . . . 
. 9 8 | . . . | . 6 . 
---------------------
8 . . | . 6 . | . . 3 
4 . . | 8 . 3 | . . 1 
7 . . | . 2 . | . . 6 
---------------------
. 6 . | . . . | 2 8 . 
. . . | 4 1 9 | . . 5 
. . . | . 8 . | . 7 9 

✅ Solved Successfully by Backtracking Algorithm:
5 3 4 | 6 7 8 | 9 1 2 
6 7 2 | 1 9 5 | 3 4 8 
1 9 8 | 3 4 2 | 5 6 7 
---------------------
8 5 9 | 7 6 1 | 4 2 3 
4 2 6 | 8 5 3 | 7 9 1 
7 1 3 | 9 2 4 | 8 5 6 
---------------------
9 6 1 | 5 3 7 | 2 8 4 
2 8 7 | 4 1 9 | 6 3 5 
3 4 5 | 2 8 6 | 1 7 9 
```

## 📦 How to Run Locally

### 1. Compilation
Compile the source code using your terminal:
```bash
javac SudokuSolverApp.java
```

### 2. Execution
Run the compiled application:
```bash
java SudokuSolverApp
```
