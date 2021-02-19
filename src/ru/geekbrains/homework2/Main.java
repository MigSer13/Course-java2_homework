package ru.geekbrains.homework2;

public class Main {

    public static void main(String[] args) {
        String[][] arrStr = {{"2", "372", "38", "4"},
                {"85", "68", "457", "988"},
                {"91", "fgh", "5", "2"},
                {"456", "54", "8", "75"}};

        try {
            int sum = 0;
            sum = calculateSumElemArray(arrStr);
            System.out.println(sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("The program ended.");
    }

    private static int calculateSumElemArray(String[][] arrStr) throws MyArraySizeException {
        int sum = 0;
        for (int i = 0; i < arrStr.length; i++) {
            if (arrStr.length != 4 || arrStr[i].length != 4) {
                throw new MyArraySizeException("The array is set incorrectly. The size should be 4x4.");
            }

            for (int j = 0; j < arrStr[i].length; j++) {
                if (!checkConvertToInt(arrStr[i][j])) {
                    throw new MyArrayDataException("Failed to convert value cell to int. Cell: [" + i + "][" + j + "] (" + arrStr[i][j] + ")" );
                } else {
                    sum += Integer.parseInt(arrStr[i][j]);
                }
            }
        }
        return sum;
    }

    private static boolean checkConvertToInt(String str) throws MyArrayDataException {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
