import java.util.Scanner;

class TicTakToe{
    static char[][] boarder;
    public TicTakToe(){
        boarder =new char[3][3];
        initBoard();
    }
    void initBoard(){
        for(int i=0;i<boarder.length;i++){
            for(int j=0;j<boarder.length;j++){
                boarder[i][j]=' ';
            }
        }
    }
    static void dispBoard(){
        System.out.println("----------");
        for(int i=0;i<boarder.length;i++){
            System.out.print("| ");
            for(int j=0;j<boarder.length;j++){
                System.out.print(boarder[i][j]+"| ");
            }
            System.out.println();
            System.out.println("----------");
        }
    }
    static void PlaceMark(int row,int col,char mark) {
    	if(row>=0&&row<=boarder.length&&col>=0&&col<=boarder.length) {
    		boarder[row][col]=mark;
    	}
    	else {
    		System.out.println("Invalid Position");
    	}
    }
    static boolean checkColWin() {
    	for(int j=0;j<=2;j++) {
    		if(boarder[0][j]!=' '&&boarder[0][j]==boarder[1][j]&&boarder[1][j]==boarder[2][j]) {
    			return true;
    		}	
    	}
    	return false;
    }
    static boolean checkRowWin() {
    	for(int i=0;i<boarder.length;i++) {
    		if(boarder[i][0]!=' '&&boarder[i][0]==boarder[i][1]&&boarder[i][1]==boarder[i][2]) {
    			return true;
    		}		
    	}
    	return false;
    }
    static boolean checkDiogWin() {
    		if(boarder[0][0]!=' '&&boarder[0][0]==boarder[1][1]&&boarder[1][1]==boarder[2][2] ||
    				boarder[0][2]!=' '&&boarder[0][2]==boarder[1][1]&&boarder[1][1]==boarder[2][0] ) {
    			return true;
    		}		
    	return false;
    }
}
class HumanPlayer{
	String name;
	char mark;
	HumanPlayer(String name,char mark){
		this.name=name;
		this.mark=mark;
		
	}
	void mackMove() {
		Scanner sc=new Scanner(System.in);
		int row,col;
		do {
			System.out.println("Enter the row and coloumn");
			 row=sc.nextInt();
			 col=sc.nextInt();
			
		} while (!IsValidMove(row, col));
		TicTakToe.PlaceMark(row, col, mark);
	}
	boolean IsValidMove(int row, int col) {
			if(row>=0 && row<=TicTakToe.boarder.length && col>=0 &&col<=TicTakToe.boarder.length) {
				if(TicTakToe.boarder[row][col]==' ') {
					return true;
				}
			}
			return false;
		}
}


public class LaunchGame_HumanVSHuman {
	public static void main(String[] args) {
		TicTakToe t=new TicTakToe();
		
		HumanPlayer p1=new HumanPlayer("bob", 'X');
		HumanPlayer p2=new HumanPlayer("pandu",'O');
		
		HumanPlayer cp;
		cp=p1;
		while(true) {
			System.out.println(cp.name+"Turn");
			cp.mackMove();
			TicTakToe.dispBoard();
			if(TicTakToe.checkRowWin()||TicTakToe.checkDiogWin()||TicTakToe.checkColWin()) {
				System.out.println(cp.name+"win's");
				break;
			}
			else {
				if(cp==p1) {
					cp=p2;
				}
				else {
					cp=p1;
				}
			}
		}
	}
}
