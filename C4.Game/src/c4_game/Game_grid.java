package c4_game;

//import libraries
import javax.swing.JOptionPane;

public class Game_grid {


	//declare variables
	final static int ARRAY_HEIGHT = 6;
	final static int ARRAY_WIDTH = 7;	
	public String Player = "";
	int countMoves = 1;

											//rows	 6	//columns 7
	static String [] [] Grid = new String[ARRAY_HEIGHT] [ARRAY_WIDTH];

	//constructor
	public Game_grid() {

		//print welcome message
		JOptionPane.showMessageDialog(null,null, toString(),JOptionPane.PLAIN_MESSAGE); 

		//initialise grid by giving value " " to all the positions
		for (int outerLoop = 0; outerLoop <ARRAY_HEIGHT; outerLoop++){
			for(int innerLoop = 0; innerLoop < ARRAY_WIDTH; innerLoop++) {
				this.Grid[outerLoop] [innerLoop] = "  ";

			}//end for
		}//end for	
	}//end constructor

	//String to String - generates the output of the welcome message
	public String toString() {

		String output = "Play Connect four !" + "\n";

		return output;

	}//end toString

	//get Player
	public String getPlayer() {

		return this.Player;

	}//end getPlayer

	//set player
	public void setPlayer(String chosePlayer) {

		this.Player = chosePlayer;

	}//end setPlayer

	//this method generates the required grid and displays it in a JOptioPane window
	public static void printGameGrid() {

		String strBoard = " ";

		System.out.print("  1  •  2  •  3  •  4  •  5  •  6  •  7  " + "\n");	

		strBoard = ("   1      2      3     4     5     6     7  " + "\n" + "–––––––––––––––––––––––––––––––" + "\n");
		for(int outerLoop  = 0; outerLoop < ARRAY_HEIGHT; outerLoop++) {
			for(int innerLoop = 0; innerLoop < ARRAY_WIDTH; innerLoop++) {
				if(innerLoop  == 0 ) {

					System.out.print("| ");	
					strBoard =  strBoard + "|  ";
				}

				System.out.print(Grid[outerLoop] [innerLoop] +" |  " );
				strBoard = strBoard  + Grid[outerLoop] [innerLoop] +"  |  " ;

			}//end inner loop

			strBoard = strBoard +  "\n" +  "–––––––––––––––––––––––––––––––" + "\n";
			System.out.println("");

		}//end outer for loop

		System.out.println("===========================================");

		JOptionPane.showMessageDialog(null,strBoard, "****Connect - 4****",JOptionPane.PLAIN_MESSAGE); 


	}//end printGameGrid

	//this method creates the conditions under witch the each player drops a piece in the grid
	public void playApiece() {


		//Player chooses the column
		String chosseCol = JOptionPane.showInputDialog("Player " + "-[" + this.Player + "]-" + " your turn!" );

		//convert from string to integer
		int intChosseCol = Integer.parseInt(chosseCol);



		//creating an if statement that places the peace in the first available empty square (ARRAY_HEIGHT - 1 so that rows start from 1 and not 0)
		for (int row = ARRAY_HEIGHT -1; row >= 0; row--) {


			//validate the player input to input pieces between the columns 1-7
			while(intChosseCol > ARRAY_WIDTH || intChosseCol <= 0 || Grid[0][intChosseCol-1] != "  "){	

				//ask from the player to input a valid number
				chosseCol = JOptionPane.showInputDialog("Player " + "-[" + this.Player + "]-" + "\n" + "Invalid move!" + "\n" + "Please choose another column.");

				//convert from string to integer
				intChosseCol = Integer.parseInt(chosseCol);

			}//end while


			//Using intChosseCol-1 in order to be easer for the user to Place the piece
			if (Grid[row][intChosseCol-1] == "  " ) {

				Grid[row][intChosseCol-1]= this.Player;

				return;

			}//end if    

		}// end for



	}//end playApeace

	//this method checks under witch conditions a player can win
	public Boolean checkForWin() {

		//declare variable Win that equals true if there is no winner
		Boolean Win = true;

		//check horizontally for PLAYER
		for(int row = 0; row < ARRAY_HEIGHT; row++) {

			for(int column = 0; column < ARRAY_WIDTH - 3; column++) {

				if(this.Grid[row][column] != "  " && 
						this.Grid[row][column] == this.Player && 
						this.Grid[row][column] == this.Grid[row][column+1] && 
						this.Grid[row][column] == this.Grid[row][column+2] && 
						this.Grid[row][column] == this.Grid[row][column+3]) {


					JOptionPane.showMessageDialog(null,"PLAYER  " + "-[" + this.Player + "]-" , "WINNER!" ,JOptionPane.PLAIN_MESSAGE); 
					Win = false;
					break;

				}//end if
			}//end for column
		}//end for row



		//check vertically for PLAYER

		for(int column = 0; column < ARRAY_WIDTH; column++) {

			for(int row = 0; row < ARRAY_HEIGHT-3;row++) {

				if(this.Grid[row][column] != "  " &&
						this.Grid[row][column] == this.Player && 
						this.Grid[row][column] == this.Grid[row+1][column] && 
						this.Grid[row][column] == this.Grid[row+2][column] && 
						this.Grid[row][column] == this.Grid[row+3][column]) {

					JOptionPane.showMessageDialog(null,"PLAYER  " + "-[" + this.Player + "]-" , "WINNER!" ,JOptionPane.PLAIN_MESSAGE); 
					Win = false;
					break;

				}//end if
			}//end for column
		}//end for row


		//check left to right diagonally for PLAYER
		for (int row = 0; row < ARRAY_HEIGHT - 3 ; row++ ) {

			for(int column = 0; column < ARRAY_WIDTH- 3 ; column++ ) {

				if(this.Grid[row][column] != "  " && 
						this.Grid[row][column] == this.Player && 
						this.Grid[row][column] == this.Grid[row+1][column+1] && 
						this.Grid[row][column] == this.Grid[row+2][column+2] && 
						this.Grid[row][column] == this.Grid[row+3][column+3]) {

					JOptionPane.showMessageDialog(null,"PLAYER  " + "-[" + this.Player + "]-" , "WINNER!" ,JOptionPane.PLAIN_MESSAGE); 
					Win = false;
					break;

				}//end if
			}//end for column
		}//end for row

		//check right to left diagonally for PLAYER1
		for (int row = 0; row < ARRAY_HEIGHT - 3 ; row++ ) {

			for(int column = 3; column < ARRAY_WIDTH  ; column++ ) {

				if(this.Grid[row][column] != "  " && 
						this.Grid[row][column] == this.Player && 
						this.Grid[row][column] == this.Grid[row+1][column-1] && 
						this.Grid[row][column] == this.Grid[row+2][column-2] && 
						this.Grid[row][column] == this.Grid[row+3][column-3]) {

					JOptionPane.showMessageDialog(null,"PLAYER  " + "-[" + this.Player + "]-" , "WINNER!" ,JOptionPane.PLAIN_MESSAGE); 
					Win = false;
					break;

				}//end if
			}//end for column
		}//end for row

		return Win;	

	}//end checkForWinner

	// this method is being used to ensure that ehen the board is full the game will end
	public boolean countMoves(int counter) {

		boolean Win = true;

		if(counter*2 > 42) {

			JOptionPane.showMessageDialog(null,"There are no more available moves", "GAME OVER!" ,JOptionPane.PLAIN_MESSAGE); 
			Win = false;

		}// end if
		return Win;


	}//end countMoves
}//end class







