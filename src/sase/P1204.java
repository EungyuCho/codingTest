package sase;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1204 {
    public static final String DELIMITER = " ";
    public final static int ONE = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        sc.nextLine();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            MostFrequent mostFrequent = new MostFrequent(sc);
            mostFrequent.printMaxValue();
        }
    }
}

class MostFrequent {
    private final int seq;
    private HashMap<Integer, Integer> numbersHashMap = new HashMap<>();

    public MostFrequent(Scanner sc) {
        this.seq = getSeq(sc);
        String[] numbersStr = getNumbers(sc);
        setNumbersHashMap(numbersStr);
    }

    public void printMaxValue() {
        System.out.println("#" + seq + " " + getMaxValue());
    }

    private int getMaxValue() {
        List<Integer> maxList = getMaxValueList();
        int max = maxList.get(0);
        if(maxList.size() > P1204.ONE) {
            max = Collections.max(maxList);
        }
        return max;
    }

    private List<Integer> getMaxValueList() {
        int maxNumber = Collections.max(numbersHashMap.values());
        return numbersHashMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxNumber)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    private void setNumbersHashMap(String[] numbersStr) {
        for (int i = 0; i < numbersStr.length; i++) {
            int number = Integer.parseInt(numbersStr[i]);
            setHashNumber(number);
        }
    }

    private void setHashNumber(int number) {
        if(!containsNumber(number)) {
            numbersHashMap.put(number, P1204.ONE);
            return;
        }
        numbersHashMap.put(number, numbersHashMap.get(number) + P1204.ONE);
    }

    private boolean containsNumber(int number) {
        return numbersHashMap.get(number) != null;
    }

    private String[] getNumbers(Scanner sc) {
        return sc.nextLine().split(P1204.DELIMITER);
    }

    private int getSeq(Scanner sc) {
        return Integer.parseInt(sc.nextLine());
    }
}