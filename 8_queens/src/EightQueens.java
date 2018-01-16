public class EightQueens{
	
	//check to see if any queens are on the board initially
	public static boolean initial = true;
	
	//Represent an empty point on the board
	public static boolean empty = false; 
	
	//Represent a queen on the point
	public static boolean queen = true;
	
	
	public static int newRow;
	public static int newCol;
	
	//Board logic representation
	public static boolean[][] board = new boolean[8][8];
	
	
	
	public EightQueens() {
		//Create the 8x8 board
		for (int row = 0; row < board.length; row ++) {
			for (int col = 0; col < board[0].length; col++) {
				board[row][col] = empty;
			}
		}
		
		initial = true; //No queens on the board initially
	}
	
	public Boolean placeQueens(int row, int col) {
		System.out.println("row:" + Integer.toString(row) + "col:" + Integer.toString(col));
		
		//System.out.println(col);
		boolean totalQueensPlaced = false;
		
		if (initial == true) {
			board[row][col] = queen;
			initial = false;
			newRow = row + 1;
			newCol = 0;
		}
		else {
			if (row >= 8) {
				return true;
			}
			
			
			else if (col >= 8) {
				for (int i = 0; i< board.length; i++) {
					if (board[row - 1][i] == queen) {
						removeQueen(row - 1, i);
						newRow = row - 1;
						newCol = i + 1;
					}
				}
			}
			else if (isAttQueen(row,col)) {
				newRow = row;
				newCol = col + 1;
			}
			
			else {
				putSingleQueen(row, col);
				newRow = row + 1;
				newCol = 0;
			}
		}
		totalQueensPlaced = placeQueens(newRow, newCol);
		
		
		return totalQueensPlaced;
		
	}
	
	
	
	public void putSingleQueen(int row, int col) {
		board[row][col] = queen;
	}
	
	public void removeQueen(int row, int col) {
		board[row][col] = empty;
	}
	
	//Function to check if the queen is being attacked
	public boolean isAttQueen(int row, int col) {
		Boolean isAtt = false;
		
		//Check Column
		for (int checkCol = 0; checkCol < board.length; checkCol++) {
			if (board[row][checkCol] == true ) {
				isAtt = true;
			}
		}
		//Check Row
		for (int checkRow = 0; checkRow < board.length; checkRow++) {
			if (board[checkRow][col] == true) {
				isAtt = true;
			}
		}
		
		//Check Diagonal
		//Diagonal going downwards right
		for (int diagRow = row, diagCol = col; diagRow < 8 && diagCol < 8; diagRow++, diagCol++) {
			if (board[diagRow][diagCol] == true) {
				isAtt = true;
			}
		}
		//Diagonal going upwards right
		for (int diagRow = row, diagCol = col; diagRow < 8 && diagCol >= 0; diagRow++, diagCol--) {
			if (board[diagRow][diagCol] == true) {
				isAtt = true;
			}
		}
		//Diagonal going upwards left
		for (int diagRow = row, diagCol = col; diagRow >= 0 && diagCol >= 0; diagRow--, diagCol--) {
			if (board[diagRow][diagCol] == true) {
				isAtt = true;
			}
		}
		//Diagonal going downwards left
		for (int diagRow = row, diagCol = col; diagRow >= 0 && diagCol < 8; diagRow--, diagCol++) {
			if (board[diagRow][diagCol] == true) {
				isAtt = true;
			}
		}
		return isAtt;
	}
	
	public void dispBoard () {
		for (int i = 0; i < board.length; i++){
		      for (int j = 0; j <board[i].length ; j++){
		    	  if (board[i][j] == queen) {
		    		  System.out.print("Q" + " ");
		    	  }
		    	  else {
		    		  System.out.print("E" + " ");
		    	  }
		      }
		      System.out.println();
		}
		
		
	}
	
	
	
	
	public static void main(String[] s) {
		
		//Set up the board
		EightQueens findSolution = new EightQueens();
		//Place one queen to get a 8 queen solution
		findSolution.placeQueens(0,0);
		findSolution.dispBoard();
	}
	
	
	
	
}
 