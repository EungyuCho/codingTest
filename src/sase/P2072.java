package sase;

import java.util.Scanner;

public class P2072 {
    public static final String DELIMITER = " ";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        sc.nextLine();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            OddList oddList = new OddList(test_case, sc);
            oddList.printOddSumResult();
        }
    }
}

class OddList {
    private final int seq;
    private int sum = 0;

    public OddList(int seq, Scanner sc) {
        this.seq = seq;
        sumFromLine(sc);
    }

    public void printOddSumResult() {
        System.out.println("#" + seq + " " + sum);
    }

    private void sumFromLine(Scanner sc) {
        String[] nextLine = getNextLine(sc);
        for(String numberStr : nextLine) {
            sumOdd(numberStr, sc);
        }
    }

    private void sumOdd(String numberStr, Scanner sc) {
        int num = getIntegerFromString(numberStr, sc);
        if(isOdd(num))
            sum += num;
    }

    private int getIntegerFromString(String number, Scanner sc) {
        int num = -1;
        try {
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            getNextLine(sc);
        }
        return num;
    }

    private boolean isOdd(int num) {
        if(num%2 == 1)
            return true;
        return false;
    }

    private String[] getNextLine(Scanner sc) {
        return sc.nextLine().split(P2072.DELIMITER);
    }
}