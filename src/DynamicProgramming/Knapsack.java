package DynamicProgramming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Knapsack {
    
    public static void main(String[] args) {
        try {
            // Dosya okuma i�lemi
            File file = new File("src/Files/10000.txt");
            Scanner sc = new Scanner(file);
            
            // �lk sat�rdaki de�erlerin okunmas�
            int itemNumber = sc.nextInt();
            int maxWeight = sc.nextInt();
            
            // De�er dizilerinin olu�turulmas�
            int[] values = new int[itemNumber];
            int[] weights = new int[itemNumber];
            
            // Di�er sat�rlardaki de�erlerin okunmas�
            for (int i = 0; i < itemNumber; i++) {
                values[i] = sc.nextInt();
                weights[i] = sc.nextInt();
            }
            
            // Knapsack algoritmas�n�n �a�r�lmas�
            int[] result = knapsack(maxWeight, weights, values, itemNumber);
            
            // Sonu�lar�n ekrana yazd�r�lmas�
            System.out.println(result[0]);
            for (int i = 1; i <= itemNumber; i++) {
                System.out.print(result[i] + " ");
            }
            
            // Scanner nesnesinin kapat�lmas�
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static int[] knapsack(int maxWeight, int[] weights, int[] values, int n) {
        // Tablo olu�turma
        int[][] table = new int[n + 1][maxWeight + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                if (i == 0 || w == 0) {
                    table[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    table[i][w] = Math.max(values[i - 1] + table[i - 1][w - weights[i - 1]], table[i - 1][w]);
                } else {
                    table[i][w] = table[i - 1][w];
                }
            }
        }
        
        // Se�ilen elemanlar�n bulunmas�
        int[] selected = new int[n + 1];
        int i = n, w = maxWeight;
        while (i > 0 && w > 0) {
            if (table[i][w] != table[i - 1][w]) {
                selected[i] = 1;
                w = w - weights[i - 1];
            }
            i--;
        }
        
        // Sonu� dizisi olu�turma
        int[] result = new int[n + 1];
        result[0] = table[n][maxWeight];
        for (i = 1; i <= n; i++) {
            result[i] = selected[i];
        }
        
        return result;
    }
}
