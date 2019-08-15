package order;

public class InsertSort {

    public void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            int insertNUm = a[i];
            while (j > 0 && a[j] < a[j - 1]) {
                a[j] = a[j - 1];
                a[j - 1] = insertNUm;
                j--;
            }
        }

    }

    public static void main(String[] arg) {
        int[] a = {3, 1, 2, 4, 6, 10, 38, 12, 15, 5};
        new InsertSort().sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
    }

}
