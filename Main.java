import java.util.*;
import java.lang.*;





public class Main {
    
    
  
    public static void printGameField (int pulledRoot1DarrayAsInteger, 
                                       char output2DArray[][],
                                       char data2DArray[][],
                                       String infoText,
                                       boolean fieldLinesAndSpaces,
                                       boolean dataPlayers) {
            

            
            // loop over 2D array and fill with lines on first and last row
            
            
            if (fieldLinesAndSpaces) {
                
                
                
                // print lines on top and bottom
                for(int rowIndex2DArray = 0; rowIndex2DArray <= output2DArray.length; rowIndex2DArray++) {
                    for(int columnIndex2DArray = 0; columnIndex2DArray < output2DArray[1].length; columnIndex2DArray++) {
                        if (rowIndex2DArray == 0 || rowIndex2DArray == output2DArray.length - 1) {
                            output2DArray[rowIndex2DArray][columnIndex2DArray] = '-';
                        }
                    }
                }
    
                // loop over 2D array and fill with lines on first and last column
                for(int rowIndex2DArray = 1; rowIndex2DArray < output2DArray.length - 1; rowIndex2DArray++) {
                    for(int columnIndex2DArray = 0; columnIndex2DArray < output2DArray[1].length; columnIndex2DArray++) {
                        if (columnIndex2DArray < 1 || columnIndex2DArray > output2DArray[1].length - 2) {
                            output2DArray[rowIndex2DArray][columnIndex2DArray] = '|';
                        }
                    }
                }
                
            
                
                
                // FILL ARRAY GAME FIELDS WITH BOTTOM LINE
                int oneDArrayIndexCounterEmptyFieldInput = 0;
    
                // loop over 2D array and fill with spaces
                for(int rowIndex2DArray = 1; rowIndex2DArray <= pulledRoot1DarrayAsInteger; rowIndex2DArray++) {
                    for(int columnIndex2DArray = 1; columnIndex2DArray <= pulledRoot1DarrayAsInteger + pulledRoot1DarrayAsInteger + 1; columnIndex2DArray++) {
    
    
                        if (columnIndex2DArray % 2 != 0) {
                            // fill 2D Array with spaces
                            output2DArray[rowIndex2DArray][columnIndex2DArray] = ' ';
                            oneDArrayIndexCounterEmptyFieldInput++;
                        }
    
    
    
                    }
                }
                
                
                
                // FILL FIELDS OF ARRAY WHICH ARE NOT USED FOR GAME WITH EMPTY SPACE
                for(int rowIndex2DArray = 1; rowIndex2DArray <= pulledRoot1DarrayAsInteger; rowIndex2DArray++) {
                    for(int columnIndex2DArray = 1; columnIndex2DArray <= pulledRoot1DarrayAsInteger + pulledRoot1DarrayAsInteger + 1; columnIndex2DArray++) {
    
    
                        if (columnIndex2DArray % 2 == 0) {
                            // fill 2D Array with spaces
                            output2DArray[rowIndex2DArray][columnIndex2DArray] = '_';
                            oneDArrayIndexCounterEmptyFieldInput++;
                        }
    
    
    
                    }
                }
                

            
            }
            
            
            // fill data into 2d game array from 2d data array
            
            if(dataPlayers) {
                

                
                // FILL ARRAY with GAMER DATA
                
                int rowCounterToFill = 0;

                for(int rowIndex2DArray = 1; rowIndex2DArray <= pulledRoot1DarrayAsInteger; rowIndex2DArray++) {

                    int columnCounterToFill = 0;
    
                    for(int columnIndex2DArray = 1; columnIndex2DArray <= pulledRoot1DarrayAsInteger + pulledRoot1DarrayAsInteger + 1; columnIndex2DArray++) {
                        
                        
                        
                        if (columnIndex2DArray % 2 == 0) {
    
    
                            // fill 2D array with gamer input
                            
                            output2DArray[rowIndex2DArray][columnIndex2DArray] = data2DArray[rowCounterToFill][columnCounterToFill];    
                           
                            
                            
                            
    
                            columnCounterToFill++;
    
                        } else {
                             output2DArray[rowIndex2DArray][columnIndex2DArray] = ' ';
                        }
                    }
                    rowCounterToFill++;

                }
                
                
            }
            
            
            
            
            
            // print whole 2D array
            for(int rowIndex2DArray = 0; rowIndex2DArray < output2DArray.length; rowIndex2DArray++) {
                for(int columnIndex2DArray = 0; columnIndex2DArray < output2DArray[1].length; columnIndex2DArray++) {
                    System.out.print(output2DArray[rowIndex2DArray][columnIndex2DArray]);
                }
                System.out.println();
            }
            
            if(infoText != null) {
                System.out.println(infoText);    
            }
            
            
    }
    
    

    
    
    public static void main(String[] args) {
        
        
        
        
    

        // get scanner class an create scanner
        Scanner scanner = new Scanner(System.in);

        // INPUTEHERE THE SIZE YOU WANT THE GAME FIELD TO BE!
        final int pulledRoot1DarrayAsInteger = 3;

        // define size of 2DArray
        final int nRows2DArray = pulledRoot1DarrayAsInteger + 2;
        final int nColums2DArray = pulledRoot1DarrayAsInteger + 6;

        // declare and initialilze 2DArray
        char output2DArray[][] = new char[nRows2DArray][nColums2DArray];




                    // define size of 2DDATAArray
            int nRows2DDataArray = pulledRoot1DarrayAsInteger;
            int nColums2DDataArray = pulledRoot1DarrayAsInteger;

            // declare and initialilze 2DDataArray
            char data2DArray[][] = new char[nRows2DDataArray][nColums2DDataArray];



            printGameField(pulledRoot1DarrayAsInteger, output2DArray, data2DArray, null, true, false);

            //String rowCoordinateInputFromGamer = scanner.next();
            //String columnCoordinateInputFromGamer = scanner.next();







//COMMENT START: LOOP OVER 2D DATA ARRAY AND CHECK IF THERE IS A WINNER IN A ROW
///*


            // create checker variables to check cases like draw, impossible, game not finished
            boolean resultStorageX = false;
            boolean resultStorageO = false;
            boolean winnerFound = false;
            boolean caseDRAW = false;
            int resultCounterX = 0;
            int resultCounterO = 0;
            int playedXCounter = 0;
            int playedOCounter = 0;
            int occupiedFields = 0;
            int nSucessfulMovesMade = 0;
            
            
            // fill 2dData array so there are no empty fields an stage 5/5 can be passed. this fields will be overritten by moves of players
            for(int rowIndex2DArray = 0; rowIndex2DArray < data2DArray.length; rowIndex2DArray++) {
                for(int columnIndex2DArray = 0; columnIndex2DArray < data2DArray[0].length; columnIndex2DArray++) {


                    data2DArray[rowIndex2DArray][columnIndex2DArray] = '_';


                }

            }

            



            while (winnerFound == false || caseDRAW == false) {
                
            String rowCoordinateInputFromGamer = scanner.next();
            String columnCoordinateInputFromGamer = scanner.next();



            boolean rowInputFieldIsEmpty = false;
            boolean columnInputFieldIsEmpty = false;
            
            boolean inputColIsNumber = true;
            boolean inputRowIsNumber = true;
            int userInputRowConvertedToInt = 0;
            int userInputColumnConvertedToInt = 0;
            boolean successfulFirstMoveMade = false;
            boolean inputOk = false;
            
            
                    // boolean numberCheck = true;
                
                    try {
                        userInputRowConvertedToInt = Integer.parseInt(rowCoordinateInputFromGamer);
                        inputRowIsNumber = true;
                        
                    } catch (NumberFormatException e) {
                        inputRowIsNumber = false;
                    } 
    
                    try {
                        userInputColumnConvertedToInt = Integer.parseInt(columnCoordinateInputFromGamer);
                        inputColIsNumber = true;
                        
                    } catch (NumberFormatException e) {
                        inputColIsNumber = false;
                    }
                    

                    
                    if (inputColIsNumber == false || inputRowIsNumber == false) {
                        System.out.println("You should enter numbers!");
                        // numberCheck = false;
                        continue;
                        
                    }
                    
                    
                    
                    
                    //boolean coordinateCheck = true;
                    boolean validUserInputRow = false;
                    boolean validUserInputColumn = false;
                    //boolean validCoordinatesGiven = false;
                    
                    // if (numberCheck = true) {
                        
                        if (userInputRowConvertedToInt <= pulledRoot1DarrayAsInteger && userInputRowConvertedToInt > 0) {
                            validUserInputRow = true;
                        }
                        
                        if (userInputColumnConvertedToInt <= pulledRoot1DarrayAsInteger && userInputColumnConvertedToInt > 0 ) {
                            validUserInputColumn = true;
                        }

                        if (validUserInputRow == false || validUserInputColumn == false) {
                            System.out.println("Coordinates should be from 1 to " + pulledRoot1DarrayAsInteger + "!");
                            // coordinateCheck = false;
                            continue;
                        }   
                        



                

                    userInputRowConvertedToInt--;
                    userInputColumnConvertedToInt--;
                    
                    


                    if (data2DArray[userInputRowConvertedToInt][userInputColumnConvertedToInt] == 'X' || data2DArray[userInputRowConvertedToInt][userInputColumnConvertedToInt] == 'O') {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    } else {
                        
                        if(nSucessfulMovesMade % 2 == 0) {
                            data2DArray[userInputRowConvertedToInt][userInputColumnConvertedToInt] = 'X';
                            resultCounterX++;
                            nSucessfulMovesMade++;
                        } else {
                            data2DArray[userInputRowConvertedToInt][userInputColumnConvertedToInt] = 'O';
                            resultCounterO++;
                            nSucessfulMovesMade++;
                        }
                        occupiedFields++;
                    }
                    


            
            // FILL ARRAY AFTER SUCCESSFUL MOVE
            printGameField(pulledRoot1DarrayAsInteger, output2DArray, data2DArray, null, true, true);
            
            


                // loop over 2d Data array and check for winner in a row
boolean checkerCaseRow = false;

            for(int rowIndex2DArray = 0; rowIndex2DArray < data2DArray.length; rowIndex2DArray++) {
                int winnerCounterRow = 0;
                for(int columnIndex2DArray = 0; columnIndex2DArray < data2DArray[0].length; columnIndex2DArray++) {


                    if (data2DArray[rowIndex2DArray][columnIndex2DArray] == 'X' || data2DArray[rowIndex2DArray][columnIndex2DArray] == 'O') {
                        // HIER OCCUPIED FIELD WEGGENOMMEN VORHIN


                        if(data2DArray[rowIndex2DArray][columnIndex2DArray] == 'X') {
                            playedXCounter++;
                            if (data2DArray[rowIndex2DArray][columnIndex2DArray] == data2DArray[rowIndex2DArray][0]) {
                                winnerCounterRow++;
                                if(winnerCounterRow == pulledRoot1DarrayAsInteger) {
                                    winnerFound = true;
                                    checkerCaseRow = true;
                                    resultStorageX = true;
                                    resultCounterX++;
                                }
                            }
                        } else if (data2DArray[rowIndex2DArray][columnIndex2DArray] == 'O') {
                            playedOCounter++;
                            if (data2DArray[rowIndex2DArray][columnIndex2DArray] == data2DArray[rowIndex2DArray][0]) {
                                winnerCounterRow++;
                                if(winnerCounterRow == pulledRoot1DarrayAsInteger) {
                                    winnerFound = true;
                                    checkerCaseRow = true;
                                    resultStorageO = true;
                                    resultCounterO++;
                                }
                            }
                        }
                    }

                }

            }



//*/
//COMMENT END: LOOP OVER 2D DATA ARRAY AND CHECK IF THERE IS A WINNER IN A ROW



//COMMENT START: loop over 2D data array and check if there is a winner in a column
///*

            boolean checkerCaseColumn = false;

            //loop over 2D data array and check if there is a winner in a column
            for(int columnIndex2DArray = 0; columnIndex2DArray < data2DArray.length; columnIndex2DArray++) {
                int winnerCounterColumn = 0;
                for(int rowIndex2DArray = 0; rowIndex2DArray < data2DArray[0].length; rowIndex2DArray++) {
                    if (data2DArray[rowIndex2DArray][columnIndex2DArray] == 'X' || data2DArray[rowIndex2DArray][columnIndex2DArray] == 'O') {
                        if (data2DArray[rowIndex2DArray][columnIndex2DArray] == data2DArray[0][columnIndex2DArray]) {
                            winnerCounterColumn++;



                            if(winnerCounterColumn == pulledRoot1DarrayAsInteger) {
                                winnerFound = true;
                                checkerCaseColumn = true;


// TESTPRINT: COLUMNCHECKER
//System.out.println("the COLUMNCHECKER works! and is the following at the moment: " + checkerCaseColumn);


                                if(data2DArray[rowIndex2DArray][columnIndex2DArray] == 'X') {
                                    resultStorageX = true;
                                    resultCounterX++;
                                } else if (data2DArray[rowIndex2DArray][columnIndex2DArray] == 'O') {
                                    resultStorageO = true;
                                    resultCounterO++;
                                }
                            }
                        }
                    }


                }

            }

//*/
//COMMENT END:  loop over 2D data array and check if there is a winner in a column




//COMMENT START: loop over 2D data array and check if there is a winner from axis top left to bottom right
///*
            boolean checkerCaseFromTopLeftToBottomRight = false;

            // check if first 2 fields from top left are the same
            if (data2DArray[0][0] == data2DArray[1][1]) {
                if (data2DArray[0][0] == 'X' || data2DArray[0][0] == 'O') {
                    int winnerCounterDiagonally = 2;
                    for(int indexDiagonally = 2; indexDiagonally < pulledRoot1DarrayAsInteger; indexDiagonally++) {

                        if(data2DArray[0][0] == data2DArray[indexDiagonally][indexDiagonally]) {
                            winnerCounterDiagonally++;
                            if(winnerCounterDiagonally == pulledRoot1DarrayAsInteger) {
                                winnerFound = true;
                                checkerCaseFromTopLeftToBottomRight = true;


// TESTPRINT: checkerCaseDiagonalFromTopLeftToBottomRight
//System.out.println("the checkerCaseDiagonalFromTopLeftToBottomRight works! and is the following at the moment: " + checkerCaseDiagonalFromTopLeftToBottomRight);


                                if(data2DArray[0][0] == 'X') {
                                    resultStorageX = true;
                                    resultCounterX++;
                                } else if(data2DArray[0][0] == 'O') {
                                    resultStorageO = true;
                                    resultCounterO++;
                                }
                            }
                        }
                    }
                }
            }

//*/
//COMMENT END: loop over 2D data array and check if there is a winner from axis top left to bottom right




//COMMENT START: LOOP OVER ARRAY AND CHECK BOTTOM LEFT TO TOP RIGHT
///*

            // create a case checker for further use in programm
            boolean checkerCaseDiagonalFromBottomLeftToTopRight = false;

            int startingCoordinateRowBottom = data2DArray.length - 1;
            int startingCoordinateColumnBottom = 0;

            int checkerCoordinateRow = data2DArray.length - 2;
            int checkerCoordinateColumn = startingCoordinateColumnBottom + 1;
            // evtl hier if statement das printet wenn repcounter 1 kleiner als pulledroot und dann break macht
            int repetitionCounter = 0;

            for (; repetitionCounter < pulledRoot1DarrayAsInteger - 1; repetitionCounter++){

//TESTPRINT
//System.out.println("for loop has been entered");



                if(data2DArray[startingCoordinateRowBottom][startingCoordinateColumnBottom] == data2DArray[checkerCoordinateRow][checkerCoordinateColumn]){

                    if (data2DArray[startingCoordinateRowBottom][startingCoordinateColumnBottom] == 'X' || data2DArray[startingCoordinateRowBottom][startingCoordinateColumnBottom] == 'O') {
//TESTPRINT
//System.out.println("if loop has been entered");

// TESTPRINT
//System.out.println("The coordinates have been checked and this are the gamers inputs " + data2DArray[startingCoordinateRowBottom][startingCoordinateColumnBottom] + data2DArray[checkerCoordinateRow][checkerCoordinateColumn]);


                        startingCoordinateRowBottom --;
                        startingCoordinateColumnBottom ++;
                        checkerCoordinateRow --;
                        checkerCoordinateColumn ++;


                    }
                } else {
                    break;
                }

            }





            if(repetitionCounter == pulledRoot1DarrayAsInteger - 1) {

                if (data2DArray[startingCoordinateRowBottom][startingCoordinateColumnBottom] == 'X' || data2DArray[startingCoordinateRowBottom][startingCoordinateColumnBottom] == 'O') {
                    winnerFound = true;
                    checkerCaseDiagonalFromBottomLeftToTopRight = true;
                }
// TESTPRINT: checkerCaseDiagonalFromBottomLeftToTopRight
// System.out.println("the checkerCaseDiagonalFromBottomLeftToTopRight works! and is the following at the moment: " + checkerCaseDiagonalFromBottomLeftToTopRight);

                if(data2DArray[startingCoordinateRowBottom][startingCoordinateColumnBottom] == 'X') {
                    resultStorageX = true;
                    resultCounterX++;
                } else if(data2DArray[startingCoordinateRowBottom][startingCoordinateColumnBottom] == 'O')  {
                    resultStorageO = true;
                    resultCounterO++;
                }
            }






//COMMENT END

//COMMENT START: print the correct winner



            

            




//COMMENT END



        //System.out.println(occupiedFields);
        //System.out.println(winnerFound);
        
        if (winnerFound == false && occupiedFields == (pulledRoot1DarrayAsInteger * pulledRoot1DarrayAsInteger)) {
                System.out.println("Draw");
                caseDRAW = true;
                break;
            }


            
        if (winnerFound == true && resultStorageX == true) {
                System.out.println("X wins");
                break;
            } else if (winnerFound == true && resultStorageO == true) {
                System.out.println("O wins");
                break;
            }
        

       }
      
    }
    
}
