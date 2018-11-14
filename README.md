Sliding Tile Puzzle Game
===
###### Taryn Chovan, Elena Murphy, Megan O'Toole 

- [1 Introduction](#1-introduction)
  - [1.1 Purpose](#11-purpose)
  - [1.2 Document Conventions](#12-document-conventions)
  - [1.3 Intended Audience and Reading Suggestions](#13-intended-audience-and-reading-suggestions)
  - [1.4 Product Scope](#14-product-scope)
- [2 Overall Description](#2-overall-description)
  - [2.1 Product Perspective](#21-product-perspective)
  - [2.2 Product Functions](#22-product-functions)
  - [2.3 User Classes and Characteristics](#23-user-classes-and-characteristics)
  - [2.4 Operating Environment](#24-operating-environment)
  - [2.5 Design and Implementation Constraints](#25-design-and-implementation-constraints)
  - [2.6 User Documentation](#26-user-documentation)
  - [2.7 Assumptions and Dependencies](#27-assumptions-and-dependencies)
- [3 External Interface Requirements](#3-external-interface-requirements)
  - [3.1 User Interfaces](#31-user-interfaces)
  - [3.2 Software Interfaces](#32-software-interfaces)
- [4 System Features](#4-system-features)
  - [4.1 Slide Tile Puzzle Board](#41-slide-tile-puzzle-board)
  - [4.2 Swipe Function](#42-swipe-function)
  - [4.3 Best Player Time and Move Count](#43-best-player-time-and-move-count)
- [5 Other Nonfunctional Requirements](#5-other-nonfunctional-requirements)
  - [5.1 Performance Requirements](#51-performance-requirements)
  - [5.2 Security Requirements](#52-security-requirements)
  - [5.3 Software Quality Attributes](#53-software-quality-attributes)

1 Introduction 
===
1.1 Purpose 
---
The sliding tile puzzle challenges players to slide pieces within a 3x3 board to establish a certain end configuration. Eight of the nine squares will be filled with tile according to the corresponding end configuration. Players will only be allowed to move vertical or horizontal into the blank square to unscramble the puzzle. The first version of the sliding tile puzzle will establish an ascending number line, with later versions establishing a scrambled image.   

1.2 Document Conventions 
---
Coming soon.

1.3 Intended Audience and Reading Suggestions 
---
Coming soon.

1.4 Product Scope 
---
Players will be presented a 3x3 game board with a scrambled number line(v1.0) or a scrambled image(v2.0). Eight of the nine squares will be filled with tile according to the corresponding end configuration. The ninth square will remain blank, allowing the player to strategically maneuver around the board. Players will only be allowed to move into the blank square vertically or horizontally. The game window will display the time passed since the start of the game and the number of moves the player has made. There will be a reset button to reset the game board, as well as a quit button. At the end of the game the player’s play time and move count will be displayed. If the player has played previous round, their top 3 past records will also be displayed in descending order. At the bottom of the screen there will be a new game and quit option. 

2 Overall Description 
===
2.1 Product Perspective 
---
Coming soon.

2.2 Product Functions 
---
- Players are challenged to solve sliding tile puzzle 
- Play time and move count for each player is tracked
- Players compete against their past recorder for fastest play time and/or smallest move count

2.3 User Classes and Characteristics 
---
Coming soon.

2.4 Operating Environment 
---
The game will be compatible with Apple and Android smartphones. 

2.5 Design and Implementation Constraints 
---
Internet connection will not be required. 

2.6 User Documentation 
---
There will be an instruction manual to explain the goal and rules of the game. 

2.7 Assumptions and Dependencies 
---
Coming soon.

3 External Interface Requirements 
===
3.1 User Interfaces 
---
The app will use a graphical user interface. The interface will allow players to slide tiles into the blank square. (add screenshots later??)

![sliding tile puzzle examples](http://allerleinett.club/wp-content/uploads/2018/05/tile-puzzle-games-sliding-tile-puzzles-tile-matching-puzzle-games.jpg)

3.2 Software Interfaces 
---
Coming soon.

4 System Features 
===
4.1 Slide Tile Puzzle Board 
---
#### 4.1.1 Description and Priority 
The game board will display a 3x3 grid. Eight of the nine square will be filled randomly with the shuffled tiles with one of the squares being left blank. The slide tile puzzle board function is of high priority. 
#### 4.1.2 Stimulus/Response Sequence 
The grid will be filled randomly each game. Player’s will be allowed to reset the puzzle board to its original state for that round if they desire. This will not reset to player’s current play time or move count. 

4.2 Movement Function 
---
#### 4.2.1 Description and Priority
The movement function allows user to move the tiles around the board to establish the proper end configuration. The movement function is of high priority.
#### 4.2.2 Stimulus/Response Sequences 
The movement function is dynamic to the user’s interactions. Users can move the tiles vertically or horizontally into the black square.

4.3 Best Player Time and Move Count 
---
#### 4.3.1 Description and Priority 
If a player play’s multiple games, their play time and move count for each round will be tracked. At the end of each game their current play time and move count will be displayed along with their top 3 records for the two categories. The best player time and move count function is of low priority. 
#### 4.3.2 Stimulus/Response Sequences
This function will be displayed automatically after each game.

5 Other Nonfunctional Requirements
===
5.1 Performance Requirements 
---
The app should quickly receive swipe functions with no delay. The overall goal of performance is for the app to run quickly and smoothly. 

5.2 Security Requirements 
---
Usernames may be added in a later version of the app. Version 1.0 does not require it. 

5.3 Software Quality Attributes 
---
Coming soon.

6 Project Makeup/Configuration
===
6.1 Classes
---
- Menu: Building the menu and player interaction with the menu.
- Board: Building and maintaining the game board, updating it as the game goes on and displaying it.
- Game: Controlling the game, including checking for a winning board, starting a new game, and tracking movements by the player.
- Main: Main class to start the game.


