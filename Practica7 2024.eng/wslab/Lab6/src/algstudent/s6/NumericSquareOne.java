package algstudent.s6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NumericSquareOne {

    private static String[][] board;
    private static String[][] boardVertical;

    private static int size;
    
    static boolean solutionFound = false;
	private static int numNodes;

    public static void main(String[] args) {
    	long t1 = 0, t2 = 0;
        try {
            readBoardFromFile("src/algstudent/s6/test03.txt"); // Change the filename accordingly
//            printBoard(board, size);
//            System.out.println();
            verticalizeBoard();
//            printBoard(board, size);
            t1 = System.currentTimeMillis();
            solve();
            t2 = System.currentTimeMillis();
            //printBoard(board, size);
            System.out.println(numNodes);
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        System.out.println("\t Time: " + (t2 - t1));
       // printBoard();
    }

//    private static void printBoard() {
//    	for (int i = 0; i < board.length; i++) {
//    		for (int j = 0; j < board[i].length; j++) {
//    			System.out.println(board[i][j] + " ");
//    		}
//    	}
//		
//	}

	private static void readBoardFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
        size = Integer.parseInt(reader.readLine()) * 2 + 1;
        board = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                board[i][j] = line[j];
            }
        }

        reader.close();
    }
	
	public static void solve() {
        backtrack( 0, 0);
        if (!solutionFound) {
            System.out.println("No solution found.");
        }
    }

    public static void backtrack( int row, int col) {
    	numNodes++;
        if (solutionFound) {
            return;
        }

        if (row > board.length - 3) {
        	if (checkSolutionsRow() && checkSolutionsCol()) {
                printBoard(board, size);
                solutionFound = true;
            }
//        	if (!checkSolutionsRow(board, size)) {
//                return;
//            }
           return;
        }

        if (col > board.length - 3) {
//        	if (!checkCol(col - 2)) {
//       		 backtrack(board, size, row, col -2);
//       	}
        	//verticalizeBoard();
//        	if (checkSolutionsCol(boardVertical, size)) {
//                printBoard(boardVertical, size);
//                solutionFound = true;
//            }
        	if (checkRow(row)) {
        		backtrack( row + 2, 0);
        	}
            
            return;
        }
//        }if (board[row][col] != null && board[row][col].equals("?") ) {
//            for (int num = 1; num <= 9; num++) {
//            	String aux = String.valueOf(num);
//                board[row][col] = aux;
//                if (row == board.length - 3) {
//                	if (checkCol(col))
//                    	backtrack(board, size, row + 2, 0);
//                    else 
//                    	return;
//                }
//                else 
//                	backtrack(board, size, row, col + 2);
//                board[row][col] = "?";
//            }
//        } else {
//            backtrack(board, size, row, col + 2);
//        }
//        

        if (board[row][col] != null && board[row][col].equals("?") ) {
            for (int num = 0; num <= 9; num++) {
            	String aux = String.valueOf(num);
                board[row][col] = aux;
                backtrack( row, col + 2);
                board[row][col] = "?";
            }
        } else {
            backtrack( row, col + 2);
        }
    }
    
    public static boolean checkSolutionsRow() {
        for (int i = 0; i < board.length -1; i+=2) {
            int resultRow = Integer.parseInt(board[i][board[i].length - 1]);
            int sumRow = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null) {
                    if (board[i][j].equals("+")) {
                        sumRow += Integer.parseInt(board[i][j + 1]);
                        j++;
                    } else if (board[i][j].equals("-")) {
                        sumRow -= Integer.parseInt(board[i][j + 1]);
                        j++;
                    } else if (board[i][j].equals("*")) {
                        sumRow *= Integer.parseInt(board[i][j + 1]);
                        j++;
                    } else if (board[i][j].equals("/")) {
                    	if (board[i][j + 1].equals("0")) {
                    		return false;
                    	}else {
                    		sumRow /= Integer.parseInt(board[i][j + 1]);
                    	}
                        j++;
                    } else if (board[i][j].equals("=")) {
                    	break;
                    } else {
                        sumRow += Integer.parseInt(board[i][j]);
                    }
                }
            }
            if (sumRow != resultRow) {
                return false;
            }
            
        }
        return true;
    }
    
    public static void verticalizeBoard() {
    	boardVertical = new String[size][size];
    	 for (int i = 0; i < board.length ; i++) {
    		 if (i == board.length - 1) {
    			 for (int j = 0; j < board[i].length/2; j++) {
	            	 boardVertical[size-1][2*j] = board[i][j];
	            	 
	             }
    		 }
    		 else if (i%2 == 0) {
    			 boardVertical[i] = board[i];
    		 }else {
	             for (int j = 0; j < board[i].length/2; j++) {
	            	 boardVertical[i][2*j] = board[i][j];
	            	 
	             }
    		 }
    }
    	 board = boardVertical;
    }
    
    public static boolean checkSolutionsCol() {
      for (int j = 0; j < size - 2; j+=2) {
      int result = Integer.parseInt(board[board[j].length - 1][j]);
      int sum = 0;
      for (int i = 0; i < size - 2; i++) {
          if (board[i][j] != null) {
              if (board[i][j].equals("+")) {
              	
              		sum += Integer.parseInt(board[i+1][j]);
              	
              	
                  i++;
              } else if (board[i][j].equals("-")) {
              	
              		sum -= Integer.parseInt(board[i+1][j ]);
              	
              	
                  i++;
              } else if (board[i][j].equals("*")) {
              	
              		sum *= Integer.parseInt(board[i+1][j]);
              	
              	
                  i++;
              } else if (board[i][j].equals("/")) {
              	
              		if (board[i+1][j].equals("0")) {
              			return false;
                	}else {
              		sum /= Integer.parseInt(board[i+1][j]);
                	}
              	
                  i++;
              } else if (board[i][j].equals("=")) {
              	break;
              } else {
              	
              		sum += Integer.parseInt(board[i][j]);
              	
              }
          }
      }
      if (sum != result) {
      return false;
      	}
      }
      	return true;
    }
    
    
   
    
    public static boolean checkCol(int col) {
    	int result = Integer.parseInt(board[board[col].length - 1][col]);
    	int sum = 0;
        for (int i = 0; i < size; i++) {
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
                	
                		sum /= Integer.parseInt(board[i+1][col]);
                	
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
    
    public static boolean checkRow(int row) {
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
                		sumRow /= Integer.parseInt(board[row][j + 1]);
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

    public static void printBoard(String[][] board, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
