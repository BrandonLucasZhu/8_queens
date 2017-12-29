public class EightQueens{
	
	//Represent an empty point on the board
	public static boolean empty = false; 
	
	//Represent a queen on the point
	public static boolean queen = true;
	
	//Board representation
	public static boolean[][] board = new boolean[8][8];
	
	
	public EightQueens() {
		//Create the 8x8 board
		for (int row = 0; row < board.length; row ++) {
			for (int col = 0; col < board.length; col++) {
				board[row][col] = empty; 
			}
		}
	}
	
	public void placeQueen(int row, int col) {
		board[row][col] = queen; 
	}
	
	
	
	
	public static void main(String[] s) {
		
		//Set up the board
		EightQueens findSolution = new EightQueens();
		//Place one queen initially at a specific location
	}
	
	
	
	
}
 