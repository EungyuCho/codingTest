package sase;

import java.util.Scanner;

public class P1859 {
    public static final String DELIMITER = " ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        sc.nextLine();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            PrincessProject princessProject = new PrincessProject(sc, test_case);
            princessProject.getBenefitOutput();
        }
    }
}
class PrincessProject {
    private final int date;
    private final int seq;
    int[] prices;

    public PrincessProject(Scanner sc, int seq) {
        this.date = Integer.parseInt(sc.nextLine());
        this.prices = getPrices(sc);
        this.seq = seq;
    }

    public void getBenefitOutput() {
        long benefit = getBenefit();
        System.out.println("#" + seq + " " + benefit);
    }

    private int[] getPrices(Scanner sc) {
        String price = sc.nextLine();
        String[] pricesString = price.split(P1859.DELIMITER);
        int[] pricesInt = new int[pricesString.length];
        for (int i = 0; i < pricesString.length; i++) {
            pricesInt[i] = Integer.parseInt(pricesString[i]);
        }
        return pricesInt;
    }

    private long getBenefit() {
        long ans = 0;
        for (int i = date - 1; i >= 0; i--) {
            int j = i - 1;
            int tmp = 0;
            while(j >= 0 && prices[i] > prices[j]) {
                tmp += prices[i];
                tmp -= prices[j];
                j--;
            }
            ans += tmp;
            i = j + 1;
        }
        return ans;
    }
}