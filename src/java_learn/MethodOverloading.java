package java_learn;

public class MethodOverloading {
    public static void main(String[] args) {
        int newScore1 = calcScore("Erji", 42);
        System.out.println("New sore: " + newScore1);

        int newScore2 = calcScore(6);
        System.out.println("New sore: " + newScore2);

        int newScore3 = calcScore();
        System.out.println("New sore: " + newScore3);

        double cm = inchToCm(2, 2);
        System.out.println("cm: " + cm);
        double cm2 = inchToCm(42);
        System.out.println("cm2: " + cm2);

    }

    public static int calcScore(String a, int b) {
        System.out.println("Player: " + a + " score: " + b);
        return b * 1000;
    }

    public static int calcScore(int b) {
        return calcScore("Anonymus", b);
    }

    public static int calcScore() {
        return calcScore(0);
    }

    public static double inchToCm(int inch) {
        return inch * 2.54;
    }
    public static double inchToCm(int feet, int inch) {
        return inchToCm(feet * 12 + inch);
    }
}
