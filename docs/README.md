## LDTS_l01g06 - Space Invaders

Space Invaders is a fixed shooter in which the player moves a laser cannon horizontally across the bottom of the screen and fires at aliens overhead.
The aliens progressively move towards the bottom of screen.
The goal is to eliminate all the aliens by shooting them. While the player has three lives, the game ends immediately if the invaders reach the bottom of the screen.
The aliens attempt to destroy the player's cannon by firing projectiles.

This project was developed by *João Tomás Teixeira* (*up202108738*@edu.fe.up.pt), *Pedro Lima* (*up202108806*@edu.fe.up.pt) and *Pedro Januário* (*up202108768*@edu.fe.up.pt) for LDTS 2022/23.

### IMPLEMENTED FEATURES

The player controls the ship and only the ship.
We have implemented the ship's capacity to move itself to the right or to the left (within the limits of the window/arena) in the bottom of the window and to fire shots.
The player can move the ship left pressing the 'A' key or the left arrow key, move the ship right pressing the 'D' key or the right arrow key and fire a shot
pressing space or the up arrow key.
In the top of the window, our game draws 50 aliens (shown as the chars X, Y and &). Each alien dies (and disappears) when it's hit by a shot fired by the ship.
We have also implemented three protections that will act as a shield of the ship. They have their own number of lives, which is decremented when hit by a shot fired
by anyone (the ship or an alien, although the aliens are not firing yet). They disappear when their lives reach 0. This feature can be tested by shooting at them.

**Arena**:

- **CreateAliens** - Creates three different types of aliens arranged by five rows of ten aliens.
- **CheckCollisions** - Checks if a shot hit an element.
- **ProcessKey** - Receives an input from the user, if it is the "q" key the game screen closes.

**Element**:

- **Draw** - Draws the arena where the game will be played and calls specific draw methods to all its elements including the aliens, the ship, the shots and the protections.
- **Damage and isAlive method** - Takes some amount of life from the element and subsequently checks if it is still alive.

**Position**:

- **Position methods** - Several methods to set and get a position of an element.

**Ship**:

- **UpdateShots** - Updates the list where the shots are stored whenever the ship fires.
- **canIMove** - Verifies if an element can move or if it already hit the walls (his limits).
- **ShipShot** - Creates a new shot fired by the ship.
- **ProcessKey** - Receives an input from the user. If it is the right arrow the ship moves to the right and the opposite for the left arrow and finally when the up arrow is pressed the ship shoots.


**Protection**:

- **DrawNumber** - Draws the life of the protections.

<img alt="start" src="https://i.ibb.co/Zf0KwrD/Start.png" height="400" />
<p>Fig.1 - Beginning of the Game</p>

<img alt="middle" src="https://i.ibb.co/NSJTJXf/Middle.png" height="400" />
<p>Fig.2 - Middle of the Game</p>

### PLANNED FEATURES

- **Moving aliens** - The aliens shall move together to one side of the screen (continuously, one side or the other) and slowly be moving towards the bottom of 
the screen. If they reach it, the player shall lose.
- **Shooting aliens** - The aliens shall fire shots at the ship randomly.
- **Score** - The game shall count the player's score and store it in a file which will be read when the user wants to view the highest scores.
- **User Menu** - When the game starts, the user shall be presented a menu with the option to play, to view the highest scores and to quit the game.
- **Lives** - The ship shall have 3 lives and lose one whenever it's hit by an alien's shot. The player shall lose the game when the ship's lives reach 0.
- **Make the user always press a key to move the ship** - The player shall be forced to always press a key to make the ship move one position, instead of pressing it continuously to move the ship in the same direction.

<img src="https://i.ibb.co/fDGpTGB/menu-mockup.png" height="400" />
<p>Fig. 3 - Main Menu mockup</p>

<img src="https://i.ibb.co/M6tv8Qz/ingame-mockup.png" height="400" />
<p>Fig. 4 - Mockup of the in-game lives and score features</p>

<img src="https://i.ibb.co/0cfHy7m/scores-mockup.png" height="400" />
<p>Fig. 5 - Mockup of the highest scores feature.</p>

### DESIGN

- **Problem in Context.** - We needed a way to communicate to [arena](../src/main/java/spaceinvaders/Arena.java) that the [ship has fired a shot](https://github.com/FEUP-LDTS-2022/project-l01gr06/blob/70c3ae42ed8ec87b2767c2d0a6b8ab4207517a21/src/main/java/spaceinvaders/Ship.java#L93-L95), so [arena](../src/main/java/spaceinvaders/Arena.java) could draw it.
- **The Pattern** - Observer Pattern
- **Implementation.** - The [ship](../src/main/java/spaceinvaders/Ship.java) is the subject, so it implements the [ShotSubject](../src/main/java/spaceinvaders/ShotSubject.java) interface, and the [arena](../src/main/java/spaceinvaders/Arena.java) is the observer, so it implements the [ShotObserver](../src/main/java/spaceinvaders/ShotObserver.java) interface. The ShotSubject, and subsequently the [ship](../src/main/java/spaceinvaders/Ship.java), has a [list of observers](https://github.com/FEUP-LDTS-2022/project-l01gr06/blob/70c3ae42ed8ec87b2767c2d0a6b8ab4207517a21/src/main/java/spaceinvaders/ShotSubject.java#L6) and whenever it fires a shot, it notifies all the [observers](../src/main/java/spaceinvaders/ShotObserver.java), including [arena](../src/main/java/spaceinvaders/Arena.java). You can see this in the following UML.
- **Consequences.** - The consequence of this design is that the [ship](../src/main/java/spaceinvaders/Ship.java) doesn't need to know anything about the [arena](../src/main/java/spaceinvaders/Arena.java), and the [arena](../src/main/java/spaceinvaders/Arena.java) doesn't need to know anything about the [ship](../src/main/java/spaceinvaders/Ship.java). This is a good design because it makes the code more modular and easier to understand.

<img alt="Observer UML" src="../UMLs/Observer.png" height="400" />
<p>Fig.3 - Observer Pattern UML</p>

------

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.

- John Doe: 40%
- Jane Doe: 60%

### UML DIAGRAM

![UML Geral](../UMLs/project-l01gr06.png)
