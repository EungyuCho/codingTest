package base100;

public class RotateMatrixTest {
    public static void main(String[] args) {
        int[][] image = {
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        RotateMatrix.printImage(image);
        System.out.println("1회 회전");
        RotateMatrix.rotateImage(image);
        RotateMatrix.printImage(image);
        System.out.println("2회 회전");
        RotateMatrix.rotateImage(image);
        RotateMatrix.printImage(image);
        System.out.println("3회 회전");
        RotateMatrix.rotateImage(image);
        RotateMatrix.printImage(image);
        System.out.println("4회 회전");
        RotateMatrix.rotateImage(image);
        RotateMatrix.printImage(image);

    }
}
