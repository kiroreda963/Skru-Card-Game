
# Skru - A JavaFX Game

## Description
Skru is a strategic card game for 4 players that uses a standard 52-card deck. The objective is to end each round with the lowest possible card value. The game consists of 5 rounds, and the player with the lowest total score at the end wins. Developed using Java and JavaFX, Skru follows Object-Oriented Programming (OOP) principles, providing an engaging and visually appealing user experience.

## Features
- **Object-Oriented Design:** Implements encapsulation, inheritance, and polymorphism.
- **JavaFX UI:** A dynamic and visually appealing user interface.
- **Event Handling:** Smooth user interactions through  mouse controls.
- **Game Logic:** Well-structured game mechanics for an engaging experience.
- **Scalability:** Modular codebase allowing for future enhancements.

## Technologies Used
- Java (OOP principles)
- JavaFX (for GUI and game rendering)

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/skru.git
   ```
2. Navigate to the project directory:
   ```sh
   cd skru
   ```
3. Compile and run the project:
   ```sh
   javac -d bin src/*.java
   java -cp bin Main
   ```
   *(Modify the commands based on your project structure)*

## Game Overview
Skru is a turn-based card game played by four players. The goal is to have the lowest total score after five rounds. 

### Setup
1. **Deal Cards:** Each player is dealt 4 cards face down.
2. **Look at Your Cards:** At the start of each round, players may look at their two rightmost cards but must keep them hidden from others.
3. **Place Remaining Deck:** The remaining cards form the draw pile, with the top card placed face up to start the discard pile.

### Gameplay
Players take turns in clockwise order and can choose to:

1. **Replace a Card:**
   - Draw a card from the draw pile.
   - Either replace one of their face-down cards with the drawn card (keeping it face down) or discard the drawn card.

2. **Replicate a Card:**
   - Discard a card that matches the face-up discard pile card.
   - If matched, the player reduces their hand size; otherwise, they take both cards.

3. **Use Special Cards:**
   - **7 or 8:** Peek at one of your own cards.
   - **9 or 10:** Look at an opponent's card.
   - **Eye Master Card:** Look at one card from each player, including yourself.
   - **Swap Card:** Swap one of your cards with an opponent's card without revealing them.
   - **Replica Card:** Discard any card.
   - **Give Card:** Give one of your cards to any opponent.

### Ending a Round: Declaring "Skru"
- A player may declare "Skru" after at least three turns, signaling the round's end.
- All players reveal their cards.
- The player with the lowest score wins the round.
- If the player who declared "Skru" does not have the lowest score, their round score is doubled.

### Scoring
- **Lowest Score:** The player with the lowest score for the round gets 0 points.
- **Other Players:** Score the sum of their card values.
- **Action Cards (7-10, Special Cards):** Add 10 points each.
- **Red Skru Card:** Adds 25 points.
- **Green Skru Card:** Subtracts 1 point.
- **Ties:** If multiple players have the lowest score, they all score 0 points.

### Winning the Game
The game consists of 5 rounds. The player with the lowest total score at the end is the winner.

## Screenshots
*(Include releva![Screenshot 2025-03-28 132531](https://github.com/user-attachments/assets/f53a561d-dcf7-48f9-919b-8eca5129ee16)
![Screenshot 2025-03-28 133039](https://github.com/user-attachments/assets/68cee380-b981-4944-a9a5-ec3c34ff932e)

nt screenshots of the game here)*

## Contributing
Contributions are welcome! Feel free to fork the repository, create a feature branch, and submit a pull request.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

