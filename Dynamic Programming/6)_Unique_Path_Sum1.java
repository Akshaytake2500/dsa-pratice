class Main {
  public static void main(String[] args) {
    int m = 4, n = 4;
    System.out.println(f(m - 1, n - 1));
  }
  public static int f(int m, int n) {
    if (m == 0 && n == 0)  return 1;
    if (m < 0 || n < 0)  return 0;

    int up = f(m - 1, n);
    int left = f(m, n - 1);

    return up + left;
  }
}