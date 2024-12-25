# Text-Based Adventure Game

## Overview

This project is a **Text-Based Adventure Game** built using Java, with a Maven-based web application structure. The game allows users to create and manage players, interact with a database to store player data, and experience an interactive adventure game.

### Technologies Used:
- **Java**: Core programming language for implementing the game logic.
- **Maven**: Dependency management and build tool.
- **MySQL**: Database for storing player information.
- **Servlets**: Java servlets for handling HTTP requests.
- **JSP**: Java Server Pages for the user interface.
- **Bootstrap**: Frontend framework for responsive design.
- **CSS**: Styling for the user interface.
- **JavaScript**: Client-side form validation and interactivity.

## Features:
- **Player Creation**: Players can create their characters by entering details such as name, health, location, and inventory.
- **Player Management**: Admin users can view, update, or delete player data from the database.
- **Interactive Game**: Once a player is created, they can engage with a text-based adventure game where the player's status is saved and retrieved from the database.

---

## Setup Instructions

### Prerequisites:
1. **JDK 11 or higher**: Ensure you have JDK 11 or a compatible version installed.
2. **MySQL Database**: Set up a MySQL database and configure your connection string in the `DatabaseConnection.java` file.
3. **Maven**: You need Maven installed to manage dependencies and build the project.

### Steps to Run:
1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/text-based-adventure-game.git
    cd text-based-adventure-game
    ```

2. Configure the database connection in `DatabaseConnection.java` with your MySQL credentials.

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

4. Deploy the generated `.war` file in a servlet container like **Apache Tomcat** or **Jetty**.

5. Open your browser and navigate to:

    ```
    http://localhost:8080/text-based-adventure-game/
    ```

    The game will be available for you to play and manage.

---

### Database Setup:
1. Create a MySQL database (e.g., `game_db`).
2. Run the following SQL to create the `players` table:

    ```sql
    CREATE TABLE players (
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        health INT NOT NULL,
        location VARCHAR(255) NOT NULL,
        inventory TEXT
    );
    ```

---

### Usage:
- **Create a Player**: Navigate to the "Create Player" page, input player details, and click "Submit" to create a new player.
- **View Players**: Go to the "View Players" page to see a list of all players.
- **Start Game**: After creating a player, you can start the game to interact with the game world.

---

## Contributing
Contributions are welcome! If you'd like to improve the project or fix bugs, feel free to submit a pull request.

### License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Thank you for checking out the Text-Based Adventure Game! Feel free to explore, play, and contribute to the project!

---
