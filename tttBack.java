class Board {
    private static final int EMPTY = -1;
    private static final int X = 1;
    private static final int O = 0;
    
    protected int[][] board = {
        {EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY}
    };
    protected int row = 0, column = 0;
    protected int counter=0;
    
    // Sets X or O on the board based on the turn and cursor input
    public boolean setter(boolean turn, int cursor) {
        if (cursor < 1 || cursor > 9) { return false;} // Invalid cursor input    

        // Convert cursor to row and column
        row = (cursor - 1) / 3;
        column = (cursor - 1) % 3;
    
        // Place mark if cell is empty
        if (board[row][column] != EMPTY) {
            return false; // Cell already occupied
        } else {
            board[row][column] = turn ? O : X;
            counter++;
            return true;
        }
    }
    
    // Resets the board for a new game
    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }counter =0;
    }
}
    
class logic extends Board {
	//checks if all elements of input column are same 
    public boolean CheckColumn(boolean turn){
        int state = turn? 0: 1;
        for (int i = 0; i<3;i++){
            if (board[i][column]!= state){return false;}
        }return true;
    }

    //checks if all elements of input row are same         
    public boolean CheckRow(boolean turn){
        int state = turn? 0: 1;
        for (int i = 0; i<3;i++){
            if (board[row][i]!= state){return false;}
        }return true;
    }

    //checks if all elements of both diagonals are same
    public boolean CheckDig(boolean turn){
        boolean d1= true ,d2 =true;
        int state = turn ? 0: 1;
        for (int i = 0,j=2; i<3;i++,j--){
            if (board[i][i]!= state){d1= false;}
            if(board[i][j] != state){d2 = false;}
        }return d1||d2;
    }
    public boolean checkWin(boolean turn){ //For doing all checks in one time
        return (CheckColumn(turn) || CheckRow(turn) || CheckDig(turn));
    }

    //For exclamation of a win
    public void win(boolean turn){
        System.out.println("\nGame Over!");
        System.out.println("Player "+(turn?"1":"2")+" Won!");
        System.out.println("Thanks for Playing!");
    }

    //For exclamation of Draw
    protected void draw(){
        System.out.println("\n Game Over!");
        System.out.println("--- DRAW ---");
        System.out.println("Thanks for Playing!");
    }
}//EOC

class Driver extends logic{
    /*private boolean getState(int num){
        return ((num%2 == 0)?true : false);//to get which player's turn it is
    }*/
    
    /*public void run(){//Initial Dialog start
        Scanner inp = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-toe");
        System.out.println("   By Hawerd Riser");
        System.out.println("Press ENTER to start!");
        inp.nextLine();
        int turn =0;
        keys();
        System.out.println("Enter the corrosponding cell number to place mark!");
        System.out.println("Press 0 to QUIT!");
        System.out.println("Good Luck!\n");//Initial Dialog end
        System.out.println("Press ENTER to start!");
        inp.nextLine();

        while(true){
            int choice;
            boolean exit;
            display();
            System.out.println("\n\n");
            System.out.println("Player "+((turn%2)+1)+"'s Turn!");
            System.out.print("Place mark : ");
            choice = inp.nextInt();
            if (choice == 0) {
                System.out.println("Thanks for playing!");
                inp.close();//If player choses to quit
                return;
            }
            exit = !setter(getState(turn), choice);
            if (exit) {
                System.out.println("Invalid Input! Try again!");
                continue;//If wrong input
            }
            if (checkWin(getState(turn))) {
                win(getState(turn));
                break;//win
            }else if(turn > 9){
                draw();
                break;//draw
            }
            turn++;//for keping flow of variables
        }
        inp.close();
        //EOF
    }*/
}//EOC    

