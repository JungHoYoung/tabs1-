package aaa1;


import java.util.Random;
import java.util.Scanner;


public class Main_hard {
    private int[][] mines;
    private char[][] Board;
    private int row, column;
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
	

    public Main_hard(){
        mines = new int[50][50];
        Board = new char[50][50];
        initializeMines();          //초기화된 판
        placeMines();                //지뢰를 무작위 위치로 채움
        NominesOfSurroundingNeighbours(); //주변에 지뢰가 있는지 숫자로 표현해줌
        startBoard();                      //게임시작
  }
    
    public boolean win() {
    	int count = 0;
    	for(int line = 1; line < 9; line++)
    		for(int column = 1; column < 9; column++)
    			if(Board[line][column] == '#')
    				count++;
    	if(count == 10)
    		return true;
    	else
    		return false;
    }
    
    public void revealNeighbours() {
    	for(int i = -1; i<2; i++)
    		for(int j = -1; j<2; j++)
    			if(mines[row + i][column + j] != -1)
    				Board[row + i][column + j] = Character.forDigit(mines[row + i][column + j], 10);
    }
    
    public int getPosition(int Line, int Column) {
    	return mines[Line][Column];
    }
    
    public boolean readAndsetPosition() {
    	do {
    		System.out.print("\nrow: ");
    		row = sc.nextInt();
    		System.out.print("column: ");
    		column = sc.nextInt();
    		
    	if( (Board[row][column] != '-') && ((row < 9 && row > 0) && (column < 9 && column > 0)))
    		System.out.println("이미 입력한 좌표입니다.");
    	
    	if( row < 1 || row > 10 || column < 1 || column > 10)
    		System.out.println("1~" + 9 + " 사이 숫자를 입력하세요.");
    	
    	}while((row < 1 || row > 8 || column < 1 || column > 8) || (Board[row][column] != '-'));
    	
    	if(getPosition(row, column) == -1 )
    		return true;
    	else
    		return false;
		
	}
	
	public void showMain() {
		
		System.out.println("\n		Lines");
		for(int Line = 8; Line > 0; Line--) {
			System.out.print("		" + Line + " ");
			
			for(int Column = 1; Column < 8; Column++) {
				System.out.print("	" + Board[Line][Column]);
			}
			
			System.out.println();
		}
		System.out.print("\n  		   ");
		for(int x = 1; x < 9; x++) {
		System.out.print(x + " ");
		}
		System.out.println();
		System.out.println("			Columns");
		}
	
	
	public void NominesOfSurroundingNeighbours() {
		for(int line = 1; line < 9; line++)
			for(int column = 1; column < 9; column++) {
			
				for(int i = -1; i <=1; i++)
					for(int j = -1; j <= 1; j++)
						if(mines[line][column] != -1)
							if(mines[line+i][column+j] == -1)
								mines[line][column]++;
			}
	}
	
	public void revealMines() {
		for(int i = 1; i < 9; i++)
			for(int j = 1; j < 9; j++)
				if(mines[i][j] == -1)
					Board[i][j] = '#';
		
		showMain();
	}
	
	public void startBoard() {
		for(int i = 1; i < mines.length; i++)
			for(int j = 1; j < mines.length; j++)
				Board[i][j] = '-';
	}
	
	public void initializeMines() {
		for(int i = 0; i < mines.length; i++)
			for(int j = 0; j < mines.length; j++)
				mines[i][j] = 0;
	}
	
	public void placeMines() {
		boolean raffled;
		int Line, Column;
		for(int i = 0; i < 10; i++) {
			do{
				Line = random.nextInt(8) + 1;
				Column = random.nextInt(8) + 1;
				
				if(mines[Line][Column] == -1)
					raffled = true;
				else
					raffled = false;
			}while(raffled);
			
			mines[Line][Column] = -1;
		}
	}
}