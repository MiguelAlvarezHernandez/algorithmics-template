package algstudent.s7;


import java.util.ArrayList;
import java.util.UUID;

import algstudent.s7.utils.BranchAndBound;
import algstudent.s7.utils.Node;

public class NumericSquareBaB extends BranchAndBound {	
//	private int counterNodes;
	/**
	 * Constructor for Pyramid Puzzle objects
	 * @param board Representation of the board for playing the puzzle
	 */
    public NumericSquareBaB(SquareBoard board) {
    	rootNode = board; //we create the puzzle to start playing
//    	counterNodes = board.getCounterNodes();
    	}
//	public int getCounterNodes() {
//		return counterNodes;
//	}
//	public void setCounterNodes(int counterNodes) {
//		this.counterNodes = counterNodes;
//	}
    
}
	
class SquareBoard extends Node {
	private String[][] board; 
	private int row; 
	private int col; 
	private static int size; 

//	private int counterNodes;
	


	
	public SquareBoard(int size) { //Generates an empty board
		SquareBoard.size = size;	 	
		board = new String[size][size];
		row = 0;
		col = 0;
//		counterNodes = 1;
		
		//isEditable = new boolean[size][size];
	}
	
	
//	public int getCounterNodes() {
//		
//	return counterNodes;
//	}

	
	public void insertValues(String[] values, int row) {
		
		if(isStartingByNumber(values[0])) {
			for(int col = 0; col < values.length; col++) {
				board[row][col] = values[col];
//				if(board[row][col].equals("?")) {
//					isEditable[row][col] = true;
//				}
			}	
		}
		else {
			//2 by 2 to align the board
			int alignmetIncrementer = 0;
			for(int col = 0; col < values.length; col++) {
				board[row][alignmetIncrementer] = values[col];
				alignmetIncrementer += 2;
			}
			
		}
	}
	
	public void insertResultsRow(String[] values) {
		int alignmetIncrementer = 0;
		for(int j = 0; j<values.length; j++) {
			board[board.length-1][alignmetIncrementer] = values[j];
			alignmetIncrementer += 2;
		}	
	}
		
	private boolean isStartingByNumber(String boardElement) {
		if(boardElement.length() > 1) {
			return Character.isDigit(boardElement.charAt(1)) || boardElement.charAt(0) == '?';
		}
		return Character.isDigit(boardElement.charAt(0)) || boardElement.charAt(0) == '?';
	}
	

	
	public boolean checkCol(int col) {
    	int result = Integer.parseInt(board[board[col].length - 1][col]);
    	int sum = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != null) {
                if (board[i][col].equals("+")) {
                	
                		sum += Integer.parseInt(board[i+1][col]);
                		
                	
                	
                    i++;
                } else if (board[i][col].equals("-")) {
                	
                		sum -= Integer.parseInt(board[i+1][col ]);
                	
                	
                    i++;
                } else if (board[i][col].equals("*")) {
                	
                		sum *= Integer.parseInt(board[i+1][col ]);
                	
                	
                    i++;
                } else if (board[i][col].equals("/")) {
                	if (board[i+1][col].equals("0")) {
                		return false;
                	}else {
                		if(sum % Integer.parseInt(board[i+1][col])== 0)
                			sum /= Integer.parseInt(board[i+1][col]);
            			else return false;
                		//sum /= Integer.parseInt(board[i+1][col]);
                	}
                    i++;
                } else if (board[i][col].equals("=")) {
                	break;
                } else {
                	
                		sum += Integer.parseInt(board[i][col]);
                	
                }
            }
        }
        if (sum != result) {
        return false;
        	}
        
        return true;
    }


	
	public boolean checkRow(int row) {
    	int resultRow = Integer.parseInt(board[row][board[row].length - 1]);
        int sumRow = 0;
        for (int j = 0; j < board[row].length; j++) {
            if (board[row][j] != null) {
                if (board[row][j].equals("+")) {
                    sumRow += Integer.parseInt(board[row][j + 1]);
                    j++;
                } else if (board[row][j].equals("-")) {
                    sumRow -= Integer.parseInt(board[row][j + 1]);
                    j++;
                } else if (board[row][j].equals("*")) {
                    sumRow *= Integer.parseInt(board[row][j + 1]);
                    j++;
                } else if (board[row][j].equals("/")) {
                	if (board[row][j + 1].equals("0")) {
                		return false;
                	}else {
                		if(sumRow % Integer.parseInt(board[row][j + 1])== 0)
                			sumRow /= Integer.parseInt(board[row][j + 1]);
            			else return false;
                		//sumRow /= Integer.parseInt(board[row][j + 1]);
                	}
                    j++;
                } else if (board[row][j].equals("=")) {
                	break;
                } else {
                    sumRow += Integer.parseInt(board[row][j]);
                }
            }
        }
        if (sumRow != resultRow) {
            return false;
        }
        return true;
    }
	
    @Override
    public String toString() {
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < board.length-1 ; i++) {
			for(int j = 0; j < board[i].length ; j++) {
				if(board[i][j] != null) {
					if(isStartingByNumber(board[i][0]))
						sb.append(board[i][j] + " ");
					else
						sb.append(board[i][j] + "  ");
					
				}
			}
			sb.append("\n");
		}
    	
		for(int j = 0; j<board[board.length-1].length; j++) {
			
			if(board[board.length-1][j] != null) {
				sb.append(board[board.length-1][j] + "  ");
			}
		}
		sb.append("\n");
		return sb.toString();
    }


    //@Override
    public void calculateHeuristicValue() {
    	int counter = 0;
    	if(prune()) {
    		heuristicValue = Integer.MAX_VALUE;
    	}
    	else {
    		for(int i = 0; i < board.length - 2; i++) {
    			for(int j = 0; j < board[i].length - 2; j++) {
    				if(board[i][j] != null && board[i][j].equals("?")) 
    					counter++; 
    			}
    		}
    		heuristicValue = counter;
    	}
    }
    
 
    

	private boolean prune() {
		if(row >= size-3) {
			if(!checkCol(col)) 
				return true;
		}
		if(col >= size-3) {
			if(!checkRow(row)) 
				return true;
		}
		return false;
	}
	
	@Override
	public boolean isSolution() {
		return heuristicValue == 0;
	}
    
	
	@Override
	public ArrayList<Node> expand() {
		ArrayList<Node> result = new ArrayList<Node>();
		String[][] newBoard;
		SquareBoard createdSquareBoard;
		
		while(board[row][col] != null  && row < board.length-2 && col < board.length-2) { //!isNumber(board[row][column])/*
			
			if(board[row][col].equals("?")) {
				for(int newValue = 0; newValue <= 9; newValue++) {
					newBoard = copyBoardWithInputValue(row, col, newValue);
					createdSquareBoard = new SquareBoard(newBoard, depth+1, this.getID(), row, col);
					result.add(createdSquareBoard);
					
					
				}
				
				break;
			}
			else {
				if(col < size-3 ) {
					if(row == size-3 && !checkCol(col)) 
						break;
					col+=2;
				}
				else {
					if(col == size-3 && !checkRow(row)) 
						break;
					row+=2;
					col = 0;
				}
			}
		}
		System.out.println(result.size());
		return result;
	}
	
	
	private String[][] copyBoardWithInputValue(int row, int column, int newValue) {
		
		String[][] boardWithValue = new String[size][size];
		
		for (int i=0; i < board.length; i++) {
			
			for (int j=0; j < board[i].length; j++) {
				
				boardWithValue[i][j] = board[i][j];	
				
			}
		}
		
		boardWithValue[row][column] = Integer.toString(newValue);	
		
		return boardWithValue;
	}
	
	
    public SquareBoard(String[][] newBoard, int depth, UUID parentID, int row, int column) {
    	this.board = newBoard;
    	this.depth = depth;
    	this.parentID = parentID;
    	this.row = row;
    	this.col = column;
    	
    	calculateHeuristicValue();
    
    	
    }
	

	
}

    
    
