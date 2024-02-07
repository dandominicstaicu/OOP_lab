Based on the example you've provided, here's a design exercise for an Object-Oriented Programming (OOP) scenario that encapsulates similar complexity and requirements. The exercise will involve designing a simplified version of a board game, incorporating multiple types of entities with distinct movement patterns and interactions.

### Exercise: Mini Chess Adventure

**Scenario:**

In a chess-like game on an NxN board, different pieces are placed with specific movement rules and objectives.

- **Knight**, moves in an L-shape: two squares in one direction, then one square perpendicular to that direction.
- **Bishops**, move diagonally across the board but are limited to moving a maximum of 3 squares per move.
- **Rooks**, move horizontally or vertically across the board, limited to moving a maximum of 2 squares per move.

**Entities:**

1. **Knight**: The player controls the Knight, which aims to collect treasures and avoid traps.
2. **Bishops**: Automated pieces that move randomly within their movement constraints.
3. **Rooks**: Automated pieces that patrol predefined paths on the board.

**Objectives:**

- Collect all treasures on the board.
- Avoid being captured by Bishops or Rooks.
- Avoid traps placed randomly on the board.

**Game End Conditions:**

- The game ends if the Knight is captured by a Bishop or Rook.
- The game ends if the Knight collects all treasures.
- The Knight loses if it steps on a trap.

**Specifications:**

- N - board size, N <= 20.
- T - number of treasures, T <= N.
- B - number of Bishops, B <= N.
- R - number of Rooks, R <= N.
- Traps are placed randomly on the board, with a maximum of T traps.
- The Knight starts at a random position on the board.
- Bishops and Rooks start at random positions on the board, not overlapping with the Knight or each other.
- The Knight's movement is input by the user, specifying direction and steps within the L-shaped constraint.
- Bishops and Rooks move after the Knight's move.

**Output:**

At the end of the game (either win or lose), display the final board state with the positions of all pieces and remaining treasures. Also, display a message indicating the game's outcome (win/lose) and the reason.

**Design Requirements:**

- Use OOP principles to design the game, with classes for the Board, Pieces (Knight, Bishop, Rook), Treasures, and Traps.
- Ensure the design allows for easy addition of new piece types with unique movement patterns.
- Implement error handling for invalid moves and game state checks.
- Provide clear documentation and comments for classes and methods.
- Write test cases to cover various game scenarios and validate the correctness of the game logic.

This exercise encourages the application of OOP concepts such as inheritance (for different types of pieces), polymorphism (for movement and interaction of pieces), encapsulation (for game state management), and abstraction (simplifying the game mechanics for the user).