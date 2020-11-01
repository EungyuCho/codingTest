package sase;

import java.util.Scanner;

public class P1206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            new BuildingHeight(test_case, sc).printViewBuildingCount();
        }
    }
}

class BuildingHeight {
    private final int seq;
    private int[] height;
    private int viewCount = 0;

    public BuildingHeight(int seq, Scanner sc) {
        this.seq = seq;
        getBuildingHeightFromScanner(sc);
        calcViewCount();
    }

    public void printViewBuildingCount() {
        System.out.println("#" + seq + " " + viewCount);
    }

    private void calcViewCount() {
        for (int i = 2; i < height.length - 2; i++) {
            int max = getMaxAroundHeight(i);
            viewCount += getHigher(i, max);
        }
    }

    private int getHigher(int index, int maxHeight) {
        int higher = height[index] - maxHeight;
        if(higher <= 0)
            return 0;
        return higher;
    }

    private int getMaxAroundHeight(int index) {
        return Math.max(height[index - 2], Math.max(height[index - 1], Math.max(height[index + 1], height[index + 2])));
    }

    private void getBuildingHeightFromScanner(Scanner sc) {
        int horizontal  = Integer.parseInt(sc.nextLine());
        String[] nextLine = sc.nextLine().split(" ");
        height = new int[horizontal];
        for (int i = 0; i < nextLine.length; i++) {
            height[i] = getIntegerFromString(nextLine[i]);
        }
    }

    private int getIntegerFromString(String number) {
        return Integer.parseInt(number);
    }
}