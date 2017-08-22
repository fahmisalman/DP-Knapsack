/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

/**
 *
 * @author fahminurfikri
 */
public class Knapsack {

    public void knapsack(int P[], int W[], int C, int n) {
        int hasil[][] = new int[n][C + 1];
        for (int i = 1; i < n; i++) {
            for (int w = 1; w <= C; w++) {
                if (W[i] <= w) {
                    if (P[i] + hasil[i - 1][w - W[i]] > hasil[i - 1][w]) {
                        hasil[i][w] = P[i] + hasil[i - 1][w - W[i]];
                    } else {
                        hasil[i][w] = hasil[i - 1][w];
                    }
                } else {
                    hasil[i][w] = hasil[i - 1][w];
                }
//                System.out.print(hasil[i][w] + " ");
            }
//            System.out.println("");
        }
        System.out.print("Jumlah Maksimum profit  : " + hasil[n - 1][C]);
        System.out.print("\nBarang yang diambil     : ");
        int i = n - 1;
        int k = C;
        while (i > 0 && k > 0) {
            if (hasil[i][k] != hasil[i - 1][k]) {
                System.out.print(i + " ");
                k = k - W[i];
            } 
            i--;
        }
        System.out.println("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int P[] = new int[]{0, 20, 30, 50, 10};
        int W[] = new int[]{0, 2, 5, 10, 5};
        int C = 16;
        int n = P.length;
        Knapsack k = new Knapsack();
        k.knapsack(P, W, C, n);
    }

}
