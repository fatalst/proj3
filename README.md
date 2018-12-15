Sliding Tile Puzzle Game
===
###### Taryn Chovan, Elena Murphy, Megan O'Toole 

- [1 Introduction](#1-introduction)
  - [1.1 Purpose](#11-purpose)
  - [1.4 Product Scope](#12-product-scope)
- [2 Overall Description](#2-overall-description)
  - [2.1 Product Functions](#21-product-functions)
  - [2.2 Operating Environment](#22-operating-environment)
  - [2.3 Design and Implementation Constraints](#23-design-and-implementation-constraints)
  - [2.4 User Documentation](#24-user-documentation)
- [3 External Interface Requirements](#3-external-interface-requirements)
  - [3.1 User Interfaces](#31-user-interfaces)
- [4 System Features](#4-system-features)
  - [4.1 Slide Tile Puzzle Board](#41-slide-tile-puzzle-board)
  - [4.2 Swipe Function](#42-movement-function)
  - [4.3 Reset Game](#43-reset-game)
  - [4.4 Best Player Time and Move Count](#44-best-player-time-and-move-count)
  - [4.5 Optional Features](#45-optional-features)
- [5 Other Nonfunctional Requirements](#5-other-nonfunctional-requirements)
  - [5.1 Performance Requirements](#51-performance-requirements)
  - [5.2 Security Requirements](#52-security-requirements)

1 Introduction 
===
1.1 Purpose 
---
The sliding tile puzzle challenges players to slide pieces within a 3x3 board to establish a certain end configuration. Eight of the nine squares will be filled with tile according to the corresponding end configuration. Players will only be allowed to move vertical or horizontal into the blank square to unscramble the puzzle. The first version of the sliding tile puzzle will establish an ascending number line, with later versions establishing a scrambled image.   

1.2 Product Scope 
---
Players will be presented a 3x3 game board with a scrambled number line(v1.0) or a scrambled image(v2.0). Eight of the nine squares will be filled with tile according to the corresponding end configuration. The ninth square will remain blank, allowing the player to strategically maneuver around the board. Players will only be allowed to move into the blank square vertically or horizontally. The game window will display the time passed since the start of the game and the number of moves the player has made. There will be a reset button to reset the game board, as well as a quit button. At the end of the game the player’s play time and move count will be displayed. If the player has played previous round, their top 3 past records will also be displayed in descending order. At the bottom of the screen there will be a new game and quit option. 

2 Overall Description 
===

2.1 Product Functions 
---
- Players are challenged to solve sliding tile puzzle 
- Play time and move count for each player is tracked
- Players compete against their past recorder for fastest play time and/or smallest move count

2.2 Operating Environment 
---
The game will be compatible with Apple and Android smartphones. 

2.3 Design and Implementation Constraints 
---
Internet connection will not be required. 

2.4 User Documentation 
---
There will be an instruction manual to explain the goal and rules of the game.

3 External Interface Requirements 
===
3.1 User Interfaces 
---
The app will use a graphical user interface. The interface will allow players to slide tiles into the blank square. (add screenshots later??)

![sliding tile puzzle examples](http://allerleinett.club/wp-content/uploads/2018/05/tile-puzzle-games-sliding-tile-puzzles-tile-matching-puzzle-games.jpg)

4 System Features 
===
4.1 Slide Tile Puzzle Board 
---
#### 4.1.1 Description and Priority 
The game board will display a 3x3 grid. Eight of the nine square will be filled randomly with the shuffled tiles with one of the squares being left blank. The slide tile puzzle board function is of high priority. 
#### 4.1.2 Stimulus/Response Sequence 
The grid will be filled randomly each game.

4.2 Movement Function 
---
#### 4.2.1 Description and Priority
The movement function allows user to move the tiles around the board to establish the proper end configuration. The movement function is of high priority.
#### 4.2.2 Stimulus/Response Sequences 
The movement function is dynamic to the user’s interactions. Users can move the tiles vertically or horizontally into the black square.

4.3 Reset Game
---
#### 4.3.1 Description and Priority
Player’s will be allowed to reset the puzzle board to its original state for that round if they desire. This is of lower priority.
#### 4.3.2 Stimulus/Response Sequences
Upon pressing the "Reset Board" button, the board will reset. This will not reset player’s current play time or move count.

4.4 Best Player Time and Move Count 
---
#### 4.4.1 Description and Priority 
If a player play’s multiple games, their play time and move count for each round will be tracked. At the end of each game their current play time and move count will be displayed along with their top 3 records for the two categories. The best player time and move count function is of low priority. 
#### 4.4.2 Stimulus/Response Sequences
This function will be displayed automatically after each game.

4.5 Optional Features 
---
#### 4.5.1 Resume 
Unfinished games will be saved if window is close and players will be able to resume the game when the window is reopened. 
#### 4.5.2 Hint
Players can click on the hint button for a hint at which tile to move into the blank square. 
#### 4.5.3 Give Up
Player can click on the give up button the for game to be automatically solved by the computer. 

5 Other Nonfunctional Requirements
===
5.1 Performance Requirements 
---
The app should quickly receive swap functions with no delay. The overall goal of performance is for the app to run quickly and smoothly. 

5.2 Security Requirements 
---
Usernames may be added in a later version of the app. Version 1.0 does not require it. 

6 Project Makeup/Configuration
===
6.1 Classes
---
- Menu: Building the menu and player interaction with the menu.
- Board: Building and maintaining the game board, updating it as the game goes on and displaying it.
- Game: Controlling the game, including checking for a winning board, starting a new game, and tracking movements by the player.
- Main: Main class to start the game.

6.2 Requirements List
---
1. Slide Tile Puzzle Board [see here](#41-slide-tile-puzzle-board)
2. Shuffle function: shuffling the image tiles
3. Image loading: the ability to load an image
4. Image splitting: the ability to split the image up into a 9x9 grid
5. Movement functionality [see here](#42-movement-function)
6. Blank button: a blank button acting as the blank space
7. Swap functionality: the ability to swap the blank tile with an image tile if they are touching each other
8. New game functionality: the ability to open a new game window
9. Reset game [see here](#43-reset-game)
10. Best player time and move count [see here](#44-best-player-time-and-move-count)
11. Image randomizer: the ability to randomize which image is loading
