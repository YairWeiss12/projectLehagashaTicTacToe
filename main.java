import java.util.Scanner;
// PROJECT TIC TAC TOE - For 2 Players:
// Create a playing board (3X3) [new function].
// Enter 2 players [name & symbol 'X' / 'O'] playing in turns.
// Choosing 0/ 1 / 2  to replace a symbol on the 3x3 board & print new result board.
// Check who won/ tie, and declare the winner!
// End Game.

public class Main {
    public static void main(String[] args) {
        // get a Scanner for users name + input.
        Scanner s = new Scanner(System.in);
        // Head start printing
        System.out.println(String.format("  TIC TAC TOE %n * New Game *"));
        System.out.println();
        //Getting & printing players names:
        System.out.println(String.format("Player 1 %nEnter your name: "));
        String P1 = s.nextLine();
        System.out.println(String.format("Player 2 %nEnter your name: "));
        String P2 = s.nextLine();

        // Creating the playing board [3X3]
        char[][] playingBoard = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                playingBoard[i][j] = '-';
            }
        }
        // ABOVE THE playingBoard - OUTSIDE THE LOOP -
        boolean isP1Turn = true;

        // Check if it's the End Of Game?
        boolean EndOfGame = false;
        while (!EndOfGame) {
            // TURNS FOR PLAYERS
            PrintingBoard(playingBoard);

            // PLAYER 1 PLAY WITH sign X.  PLAYER 2 PLAY WITH sign O.
            char sign = ' ';
            if (isP1Turn) {
                sign = 'X';
            } else {
                sign = 'O';
            }
            // Changing turns:
            if (isP1Turn) {
                System.out.println("It's " + P1 + " turn, [playing with X]");
            } else {
                System.out.println("It's " + P2 + " turn, [playing with O]");
            }
            // placing row & colum outside the loop - to use them again:

                int row = 0; // (Integer.toString());
                //Integer.parseInt(Integer(NumberFormatException));
                int colum = 0; // (Integer.toString());
                //Integer.parseInt("try again");
                // System.out.println("valid number, try again");

                // while & break; for clear space on the playingBoard.
                while (true) {
                    // user choosing: first - row and then a colum, position for his sign on board
                    System.out.print("Enter a row: [use location 0, 1 or 2]");
                     row = s.nextInt();
                    System.out.print("Enter a colum: [use location 0, 1 or 2]");
                     colum = s.nextInt();
                    // check if input space is clear?
                    if (row < 0 || row > 2 || colum < 0 || colum > 2) {
                        System.out.println("not valid number, try again");
                    } else if (playingBoard[row][colum] != '-') {
                        System.out.println();
                        System.out.println("this spot is taken! choose another: ");
                        //PrintingBoard(playingBoard);
                    } else {
                    break;
                    }
                }
                // placing x or o on the position (row / colum).
                playingBoard[row][colum] = sign;
                //  DECLARING WHO IS THE WINNER?!?
                if (winning(playingBoard) == 'X') {
                    System.out.println(" * * * " + P1 + " IS THE WINNER!!! * * *");
                    EndOfGame = true;
                } else if (winning(playingBoard) == 'O') {
                    System.out.println(" * * * " + P2 + " IS THE WINNER!!! * * *");
                    EndOfGame = true;
                } else {
                    if (IsTied(playingBoard)) {
                        System.out.println(" *** IT'S A TIE!!! * * * PLAY AGAIN * * *");
                        EndOfGame = true;
                    } else {
                        // how to continue the game??? = changing turns!
                        isP1Turn = !isP1Turn;
                    }
                }
            }
            // printing NEW board + RESULT:
            PrintingBoard(playingBoard);
        }
        // new function for printing board
        public static void PrintingBoard ( char[][] playingBoard){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(playingBoard[i][j]);
                }
                System.out.println();
                // so far = so good [we have two players names + a playing board].
            }
        }
        // wining the game 3[XXX] or 3[OOO] in a row/ colum/ diagonals:
        public static char winning ( char[][] playingBoard){
            for (int i = 0; i < 3; i++) {
                if (playingBoard[i][0] == playingBoard[i][1] && playingBoard[i][1] == playingBoard[i][2] && playingBoard[i][0] != '-') {
                    return playingBoard[i][0];
                }
            }
            for (int j = 0; j < 3; j++) {
                if (playingBoard[j][0] == playingBoard[j][1] && playingBoard[j][1] == playingBoard[j][2] && playingBoard[j][0] != '-') {
                    return playingBoard[0][j];
                }
            }
            if (playingBoard[0][0] == playingBoard[1][1] && playingBoard[1][1] == playingBoard[2][2] && playingBoard[0][0] != '-') {
                return playingBoard[0][0];
            }
            if (playingBoard[0][2] == playingBoard[1][1] && playingBoard[1][1] == playingBoard[2][0] && playingBoard[0][0] != '-') {
                return playingBoard[0][2];
            }
            // tied
            return '-';
        }
        // IS THE playingBoard FULL? END OF GAME?
        public static boolean IsTied ( char[][] playingBoard){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (playingBoard[i][j] == '-') {
                        return false;
                    }
                }
            }
            return true;
        }
    }
                // END OF GAME
            //(sout) "START A NEW GAME"...
