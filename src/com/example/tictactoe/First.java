package com.example.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class First extends Activity {

	// Representing the game state:
	private boolean noughtsTurn = false; // Who's turn is it? false=X true=O
	// private char board[][] = new char[3][3];
	char b1[][] = new char[3][3];
	char b2[][] = new char[3][3];
	char b3[][] = new char[3][3];
	char b4[][] = new char[3][3];
	char b5[][] = new char[3][3];
	char b6[][] = new char[3][3];
	char b7[][] = new char[3][3];
	char b8[][] = new char[3][3];
	char b9[][] = new char[3][3];
	Button New;
	boolean s0 = true, s1 = true, s2 = true, s3 = true, s4 = true, s5 = true,
			s6 = true, s7 = true, s8 = true;
	boolean isSelectable[] = { s0, s1, s2, s3, s4, s5, s6, s7, s8 };
	char Board[][][] = { b1, b2, b3, b4, b5, b6, b7, b8, b9 };
	char mainB[][] = new char[3][3];
	int X, Y, boardNo, a, b, toBePlayedBoard;
	char winner;
	int x1, y1, l1, l2;

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ultimatelay);

		setupOnClickListeners();
		resetButtons();
	}

	public void newGame(View view) {
		noughtsTurn = false;
		// board = new char[3][3];
		resetButtons();
	}

	/**
	 * Reset each button in the grid to be blank and enabled.
	 */
	private void resetButtons() {
		TableLayout T = (TableLayout) findViewById(R.id.tableLayout1);
		for (int y = 0; y < T.getChildCount(); y++) {
			if (T.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setText("");
						B.setEnabled(true);
					}
				}
			}
		}
		// TextView t = (TextView) findViewById(R.id.titleText);
		// t.setText("Tic Tac Toe");
	}

	/**
	 * Method that returns true when someone has won and false when nobody has.<br />
	 * It also display the winner on screen.
	 * 
	 * @param board1
	 * 
	 * @return
	 */
	private boolean checkWin(char[][] board1) {

		winner = '\0';
		if (checkWinner(board1, 3, 'X')) {
			winner = 'X';
		} else if (checkWinner(board1, 3, 'O')) {
			winner = 'O';
		}

		if (winner == '\0') {

			return false; // nobody won
		} else {
			// display winner
			mainBoardValue();

			return true;
		}
	}

	private void mainBoardValue() {
		// TODO Auto-generated method stub
		switch (boardNo) {
		case 0:
			mainB[0][0] = winner;
			break;
		case 1:
			mainB[0][1] = winner;
			break;
		case 2:
			mainB[0][2] = winner;
			break;
		case 3:
			mainB[1][0] = winner;
			break;
		case 4:
			mainB[1][1] = winner;
			break;
		case 5:
			mainB[1][2] = winner;
			break;
		case 6:
			mainB[2][0] = winner;
			break;
		case 7:
			mainB[2][1] = winner;
			break;
		case 8:
			mainB[2][2] = winner;

		}

	}

	/**
	 * This is a generic algorithm for checking if a specific player has won on
	 * a tic tac toe board of any size.
	 * 
	 * @param board
	 *            the board itself
	 * @param size
	 *            the width and height of the board
	 * @param player
	 *            the player, 'X' or 'O'
	 * @return true if the specified player has won
	 */
	private boolean checkWinner(char[][] board, int size, char player) {
		// check each column
		for (int x = 0; x < size; x++) {
			int total = 0;
			for (int y = 0; y < size; y++) {
				if (board[x][y] == player) {
					total++;
				}
			}
			if (total >= size) {
				return true; // they win
			}
		}

		// check each row
		for (int y = 0; y < size; y++) {
			int total = 0;
			for (int x = 0; x < size; x++) {
				if (board[x][y] == player) {
					total++;
				}
			}
			if (total >= size) {
				return true; // they win
			}
		}

		// forward diag
		int total = 0;
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				if (x == y && board[x][y] == player) {
					total++;
				}
			}
		}
		if (total >= size) {
			return true; // they win
		}

		// backward diag
		total = 0;
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				if (x + y == size - 1 && board[x][y] == player) {
					total++;
				}
			}
		}
		if (total >= size) {
			return true; // they win
		}

		return false; // nobody won
	}

	/**
	 * Disables all the buttons in the grid.
	 * 
	 * @param board2
	 */
	private void disableButtons() {
		TableLayout T = (TableLayout) findViewById(R.id.tableLayout1);
		int i, j;
		setSmallBoardCo(boardNo);
		for (i = y1; i < l2; i++) {
			if (T.getChildAt(i) instanceof TableRow) {
				TableRow R = (TableRow) T.getChildAt(i);
				for (j = x1; j < l1; j++) {
					if (R.getChildAt(j) instanceof Button) {
						Button B = (Button) R.getChildAt(j);
						B.setEnabled(false);
					}
				}
			}
		}
		isSelectable[boardNo] = false;
	}

	private void setSmallBoardCo(int bNum) {
		// TODO Auto-generated method stub
		switch (bNum) {
		case 0:
			x1 = 0;
			y1 = 0;
			break;
		case 1:
			x1 = 3;
			y1 = 0;
			break;
		case 2:
			x1 = 6;
			y1 = 0;
			break;
		case 3:
			x1 = 0;
			y1 = 3;
			break;
		case 4:
			x1 = 3;
			y1 = 3;
			break;
		case 5:
			x1 = 6;
			y1 = 3;
			break;
		case 6:
			x1 = 0;
			y1 = 6;
			break;
		case 7:
			x1 = 3;
			y1 = 6;
			break;
		case 8:
			x1 = 6;
			y1 = 6;
			break;

		}
		l1 = x1 + 3;
		l2 = y1 + 3;

	}

	/**
	 * This will add the OnClickListener to each button inside out TableLayout
	 */
	private void setupOnClickListeners() {
		TableLayout T = (TableLayout) findViewById(R.id.tableLayout1);
		for (int y = 0; y < T.getChildCount(); y++) {
			if (T.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each
												// button on the grid
					V.setOnClickListener(new PlayOnClick(x, y));
				}
			}
		}
	}

	/**
	 * Custom OnClickListener for Noughts and Crosses<br />
	 * Each Button for Noughts and Crosses has a position we need to take into
	 * account
	 * 
	 * 
	 */
	private class PlayOnClick implements View.OnClickListener {

		private int x = 0;
		private int y = 0;

		public PlayOnClick(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public void onClick(View view) {
			if (view instanceof Button) {
				valueOfMainBoardCo();
				valueOfSmallBoardCo();
				boardNo = (Y) * 3 + X;
				toBePlayedBoard = 3 * b + a;
				System.out.println("toBePlayedBoard " + toBePlayedBoard);
				System.out.println("boardNo " + boardNo);

				Button B = (Button) view;

				Board[boardNo][b][a] = noughtsTurn ? 'O' : 'X';
				//B.setBackgroundDrawable(R.drawable.circle);
				B.setText(noughtsTurn ? "O" : "X");
				B.setEnabled(false);
				noughtsTurn = !noughtsTurn;

				// check if any board has been won
				if (checkWin(Board[boardNo])) {
					disableButtons();
				}
				if (isSelectable[toBePlayedBoard]) {
					disableRemainingBoards(toBePlayedBoard);
					enableToBePlayedBoard(toBePlayedBoard);
				}
				if (!isSelectable[toBePlayedBoard]) {
					enableAllBoard(toBePlayedBoard);
				}
				if (checkWin(mainB)) {
					if (winner == '\0') {
						Toast.makeText(First.this, "It's a draw!!",
								Toast.LENGTH_LONG).show();
					} else {
						Toast.makeText(First.this, "Winner is" + winner,
								Toast.LENGTH_LONG).show();
					}
				}
			}

		}

		private void enableAllBoard(int toBePlayedBoard) {
			// TODO Auto-generated method stub
			for (int i = 0; i < 9; i++) {
				if (isSelectable[i]) {
					enableToBePlayedBoard(i);

				}
			}

		}

		private void enableToBePlayedBoard(int toBePlayedBoard) {
			// TODO Auto-generated method stub
			TableLayout T = (TableLayout) findViewById(R.id.tableLayout1);
			int i, j, l = 0, m = 0;
			setSmallBoardCo(toBePlayedBoard);
			System.out.println("y1 " + y1);
			System.out.println("x1 " + x1);
			for (i = y1; i < l2; i++) {
				if (T.getChildAt(i) instanceof TableRow) {
					TableRow R = (TableRow) T.getChildAt(i);
					for (j = x1; j < l1; j++) {
						if (R.getChildAt(j) instanceof Button) {
							Button B = (Button) R.getChildAt(j);
							if (i < 3) {
								l = i;
							} else if (i < 6) {
								l = i - 3;
							} else if (i < 9) {
								l = i - 6;
							}
							if (j < 3) {
								m = j;
							} else if (j < 6) {
								m = j - 3;
							} else if (j < 9) {
								m = j - 6;
							}
							if (Board[toBePlayedBoard][l][m] == 'X'
									|| Board[toBePlayedBoard][l][m] == 'O') {
								B.setEnabled(false);
							} else
								B.setEnabled(true);
						}
					}
				}
			}

		}

		private void disableRemainingBoards(int toBePlayedBoard) {
			// TODO Auto-generated method stub

			for (int i = 0; i < 9; i++) {
				if (i != toBePlayedBoard) {
					if (isSelectable[i]) {

						// setSmallBoardCo(i);
						disableOtherBoards(i);
					}
				}
			}

		}

		private void disableOtherBoards(int N) {
			// TODO Auto-generated method stub

			TableLayout T = (TableLayout) findViewById(R.id.tableLayout1);
			int i, j;
			setSmallBoardCo(N);
			System.out.println("N " + N);
			for (i = y1; i < l2; i++) {
				if (T.getChildAt(i) instanceof TableRow) {
					TableRow R = (TableRow) T.getChildAt(i);
					for (j = x1; j < l1; j++) {
						if (R.getChildAt(j) instanceof Button) {
							System.out.println("dy1 " + y1);
							System.out.println("dx1 " + x1);
							Button B = (Button) R.getChildAt(j);
							B.setEnabled(false);
						}
					}
				}
			}

		}

		private void valueOfSmallBoardCo() {
			// TODO Auto-generated method stub
			if (x < 3)
				a = x;
			else if (x < 6)
				a = x - 3;
			else if (x < 9)
				a = x - 6;
			if (y < 3)
				b = y;
			else if (y < 6)
				b = y - 3;
			else if (y < 9)
				b = y - 6;

		}

		private void valueOfMainBoardCo() {
			// TODO Auto-generated method stub
			if (x < 3 && y < 3) {
				X = 0;
				Y = 0;

			} else if (x < 6 && y < 3) {
				X = 1;
				Y = 0;

			} else if (x < 9 && y < 3) {
				X = 2;
				Y = 0;

			} else if (x < 3 && y < 6) {
				X = 0;
				Y = 1;

			} else if (x < 6 && y < 6) {
				X = 1;
				Y = 1;

			} else if (x < 9 && y < 6) {
				X = 2;
				Y = 1;

			} else if (x < 3 && y < 9) {
				X = 0;
				Y = 2;

			} else if (x < 6 && y < 9) {
				X = 1;
				Y = 2;

			} else if (x < 9 && y < 9) {
				X = 2;
				Y = 2;

			}
		}
	}
}
