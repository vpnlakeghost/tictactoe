public class Printer {
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

    public void testConnect() {
        System.out.println("connect successful");
    }
}
