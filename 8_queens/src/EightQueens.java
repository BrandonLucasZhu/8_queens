public class EightQueens{
	
	//check to see if any queens are on the board initially
	public static boolean initial;
	
	//Represent an empty point on the board
	public static boolean empty = false; 
	
	//Represent a queen on the point
	public static boolean queen = true;
	
	//Board logic representation
	public static boolean[][] board = new boolean[8][8];
	
	
	
	public EightQueens() {
		//Create the 8x8 board
		for (int row = 0; row < board.length; row ++) {
			for (int col = 0; col < board.length; col++) {
				board[row][col] = empty;
			}
		}
		
		initial = true; //No queens on the board initially
	}
	
	public Boolean placeQueen(int row, int col) {
		if (initial == true) {
			board[row][col] = queen;
			initial = false;
		}
		
		if (isAttQueen(row,col)) {
			col++
			tryNext = placeQueen(row,col);
		}
		else if (col > board.length) {
			
		}
		
		
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
		for (int diagRow = row, diagCol = col; diagRow < 8 && diagCol > 0; diagRow++, diagCol--) {
			if (board[diagRow][diagCol] == true) {
				isAtt = true;
			}
		}
		//Diagonal going upwards left
		for (int diagRow = row, diagCol = col; diagRow > 0 && diagCol > 0; diagRow--, diagCol--) {
			if (board[diagRow][diagCol] == true) {
				isAtt = true;
			}
		}
		//Diagonal going downwards left
		for (int diagRow = row, diagCol = col; diagRow > 0 && diagCol < 8; diagRow--, diagCol++) {
			if (board[diagRow][diagCol] == true) {
				isAtt = true;
			}
		}
		
	}
	
	
	
	
	
	
	public static void main(String[] s) {
		
		//Set up the board
		EightQueens findSolution = new EightQueens();
		//Place one queen to get a 8 queen solution
		findSolution.placeQueen(0,0);
	}
	
	
	
	
}
 