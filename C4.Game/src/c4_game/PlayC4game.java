package c4_game;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource; 

public class PlayC4game {

	public static void main(String[] args) {

		//change the background colour of the JoptionPane window
		UIManager uim =new UIManager();  
		uim.put("OptionPane.background",new ColorUIResource(255, 255, 235));  
		uim.put("Panel.background",new ColorUIResource(255, 255, 235));  


		//declare variable Win
		boolean Win;
		int anotherGo;
		int counter = 1;


		//generate a do while loop that asks the user to enter the data as many times as he wishes
		do { 


			Game_grid PLAY = new Game_grid();

			while (Win = true)  {

				//set counter 
				counter = counter +1;


				//PLAYER 1 turn

				//set player 1 to "x"
				PLAY.setPlayer("x");

				//show the Grid
				PLAY.printGameGrid();

				//player 1 drops a piece
				PLAY.playApiece();



				//check if player 1 won
				if(PLAY.checkForWin()== false) {

					Win = false;

					//show the Grid
					PLAY.printGameGrid();

					break;

				}// end if


				//PLAYER 2 turn


				//set player 2 to "o"
				PLAY.setPlayer("o");


				//show the Grid
				PLAY.printGameGrid();

				//player 2 drops a piece
				PLAY.playApiece();


				//check if player 2 won
				if(PLAY.checkForWin()== false ) {

					Win = false;

					//show the Grid
					PLAY.printGameGrid();

					break;

				}// end if

				//check if there are any available moves in the Grid
				if(PLAY.countMoves(counter)== false ) {

					Win = false;

					//show the Grid
					PLAY.printGameGrid();

					break;

				}// end if


			}//end while loop


			//ask the users to if they want to play again
			anotherGo = JOptionPane.showConfirmDialog(null, " Do you want to play another game?", "****Connect Four****", JOptionPane.YES_NO_OPTION);

		} while (anotherGo == 0);//end do while loop



	}//end main

}//end class
