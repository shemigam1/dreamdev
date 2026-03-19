public class Task9 {
  public static void main(String[] args) {
    double sum = 0;
    for (int i = 1; i <= 10; i++) {
      if (i % 4 == 0) sum += printMul(i);
    }
    System.out.printf("%.0f%n", Math.pow(sum, 2));
  }

  private static double printMul(int i) {
    double sum = 0;
    for (int j = 1; j <= 5; j++) {
      sum += Math.pow(i, j);
    }
    return sum;
  }
}
