# Sliding Tile Puzzle Game

Taryn Chovan, Elena Murphy, Megan O'Toole 

- [1 Introduction](#Introduction)
  - [1.1 Purpose](#Purpose)
  - [1.2 Document Conventions](#DocumentConventions)
  - [1.3 Intended Audience and Reading Suggestions](#Intended)
  - [1.4 Project Scope](#ProjectScope)
- [2 Overall Description](#OverallDescription)
  - [2.1 Product Perspective](#ProjectPerspective)
  - [2.2 Product Functions](#ProductFunctions)
  - [2.3 User Classes and Characteristics](#UserClasses)
  - [2.4 Operating Environment](#OperatingEnviro)
  - [2.5 Design and Implementation Constraints](#Constraints)
  - [2.6 User Documentation](#UserDoc)
  - [2.7 Assumptions and Dependencies](#Assumptions)
- [3 External Interface Requirements](#ExternalInterfaceReq)
  - [3.1 User Interface](#UserInterface)
  - [3.2 Software Interface](#SoftwareInterface)
- [4 System Features](#SystemFeatures)
  - [4.1 Slide Tile Puzzle Board](#Board)
  - [4.2 Swipe Function](#SwipeFunction)
  - [4.3 Best Player Time and Move Count](#TimeAndCount)
- [5 Other Nonfunctional Requirements](#NonFunc)
  - [5.1 Performance Requirements](#PerformanceReq)
  - [5.2 Security Requirements](#Security)
  - [5.3 Software Quality Attributes](#SQA)

## 1 Introduction <a name="Introduction"></a>

### 1.1 Purpose <a name="Purpose"></a>
The sliding tile puzzle challenges players to slide pieces within a 3x3 board to establish a certain end configuration. Eight of the nine squares will be filled with tile according to the corresponding end configuration. Players will only be allowed to move vertical or horizontal into the blank square to unscramble the puzzle. The first version of the sliding tile puzzle will establish an ascending number line, with later versions establishing a scrambled image.   
### 1.2 Document Conventions <a name="DocumentConventions"></a>

### 1.3 Intended Audience and Reading Suggestions <a name="Intended"></a>

### 1.4 Project Scope <a name="ProjectScope"></a>
Players will be presented a 3x3 game board with a scrambled number line(v1.0) or a scrambled image(v2.0). Eight of the nine squares will be filled with tile according to the corresponding end configuration. The ninth square will remain blank, allowing the player to strategically maneuver around the board. Players will only be allowed to move into the blank square vertically or horizontally. The game window will display the time passed since the start of the game and the number of moves the player has made. There will be a reset button to reset the game board, as well as a quit button. At the end of the game the player’s play time and move count will be displayed. If the player has played pervious round, their top 3 past records will also be displayed in descending order. At the bottom of the screen there will be a new game and quit option. 

## 2 Overall Description <a name="OverallDescription"></a>
### 2.1 Product Perspective <a name="ProjectPerspective"></a>

### 2.2 Product Functions <a name="ProductFunctions"></a>
- Players are challenged to solve sliding tile puzzle 
- Play time and move count for each player is tracked
- Players compete against their past recorder for fastest play time and/or smallest move count
### 2.3 User Classes and Characteristics <a name="UserClasses"></a>

### 2.4 Operating Environment <a name="OperatingEnviro"></a>
The game will be compatible with Apple and Android smartphones. 
### 2.5 Design and Implementation Constraints <a name="Constraints"></a>
Internet connection will not be required. 
### 2.6 User Documentation <a name="UserDoc"></a>
There will be an instruction manual to explain the goal and rules of the game. 
### 2.7 Assumptions and Dependencies <a name="Assumptions"></a>


## 3 External Interface Requirements <a name="ExternalInterfaceReq"></a>
### 3.1 User Interface <a name="UserInterface"></a>
The app will use a graphical user interface. The interface will allow players to slide tiles into the blank square. (add screenshots later??)

![sliding tile puzzle examples](http://allerleinett.club/wp-content/uploads/2018/05/tile-puzzle-games-sliding-tile-puzzles-tile-matching-puzzle-games.jpg)
### 3.2 Software Interfaces <a name="SoftwareInterface"></a>

## 4 System Features <a name="SystemFeatures"></a>
### 4.1 Slide Tile Puzzle Board <a name="Board"></a>
#### 4.1.1 Description and Priority 
The game board will display a 3x3 grid. Eight of the nine square will be filled randomly with the shuffled tiles with one of the squares being left blank. The slide tile puzzle board function is of high priority. 
#### 4.1.2 Stimulus/Response Sequence 
The grid will be filled randomly each game. Player’s will be allowed to reset the puzzle board to its original state for that round if they desire. This will not reset to player’s current play time or move count. 
### 4.2 Swipe Function <a name="SwipeFunction"></a>
#### 4.2.1 Description and Priority
The swipe function allows user to move the tiles around the board to establish the proper end configuration. The swipe function is of high priority.
#### 4.2.2 Stimulus/Response Sequences 
The swipe function is dynamic to the user’s interactions. Users can swipe vertically or horizontally into the black square. 
### 4.3 Best Player Time and Move Count <a name="TimeAndCount"></a>
#### 4.3.1 Description and Priority 
If a player play’s multiple games, their play time and move count for each round will be tracked. At the end of each game their current play time and move count will be displayed along with their top 3 records for the two categories. The best player time and move count function is of low priority. 
#### 4.3.2 Stimulus/Response Sequences
This function will be displayed automatically after each game. 

## 5 Other Nonfunctional Requirements <a name="NonFunc"></a>
### 5.1 Performance Requirements <a name="PerformanceReq"></a>
The app should quickly receive swipe functions with no delay. The overall goal of performance is for the app to run quickly and smoothly. 
### 5.2 Security Requirements <a name="Security"></a>
Usernames may be added in a later version of the app. Version 1.0 does not require it. 
### 5.3 Software Quality Attributes <a name="SQA"></a>

## 6 Market Research --- idk if we need to do this, what would we even research? 




