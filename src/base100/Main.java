package base100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int caseCount = sc.nextInt();
        sc.nextLine();
        String[] caseArr = new String[caseCount];

        for (int i = 0; i < caseCount; i++) {
            caseArr[i] = sc.nextLine();
        }

        int a;
        int b;
        int index;
        boolean isOK = false;
        String binaryString;
        String substring;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < caseArr.length; i++) {
            String[] s = caseArr[i].split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);

            isOK = false;
            binaryString = Integer.toBinaryString(b);
            if (binaryString.length() < a) {
                if (binaryString.equals("1") && a == 1) {
                    isOK = true;
                }
            } else {
                index = binaryString.length() - a;
                substring = binaryString.substring(index);
                if(!substring.contains("0"))
                    isOK = true;
            }
            sb.append("#").append(i+1).append(" ").append(isOK ? "ON" : "OFF").append("\n");
        }

        System.out.println(sb.toString());
    }
}

/*
*
*
        String[] s = str.split(" ");
        long a = Long.parseLong(s[0]);
        long b = Long.parseLong(s[1]);
        long c = Long.parseLong(s[2]);

        long sum = a + b + c;
        System.out.println(sum);
        doubleInt = sum / (double) 3;
        System.out.println(String.format("%.1f", doubleInt) );
        *
        String[] s = str.split(" ");
        long a = Long.parseLong(s[0]);
        long b = Long.parseLong(s[1]);

        if(a != b)
            System.out.println(1);
        else
            System.out.println(0);

* */