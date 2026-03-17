public class Task1 {
  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      if (i % 4 == 0) printMul(i);
    }
  }

  private static void printMul(int i) {
    for (int j = 1; j <= 5; j++) {
      System.out.printf("%.0f ", Math.pow(i, j));
    }
    System.out.printf("%n");
  }
}
