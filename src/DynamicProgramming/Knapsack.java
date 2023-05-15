package DynamicProgramming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Knapsack {
    
    public static void main(String[] args) {
        try {
            // Dosya okuma iþlemi
            File file = new File("src/Files/10000.txt");
            Scanner sc = new Scanner(file);
            
            // Ýlk satýrdaki deðerlerin okunmasý
            int itemNumber = sc.nextInt();
            int maxWeight = sc.nextInt();
            
            // Deðer dizilerinin oluþturulmasý
            int[] values = new int[itemNumber];
            int[] weights = new int[itemNumber];
            
            // Diðer satýrlardaki deðerlerin okunmasý
            for (int i = 0; i < itemNumber; i++) {
                values[i] = sc.nextInt();
                weights[i] = sc.nextInt();
            }
            
            // Knapsack algoritmasýnýn çaðrýlmasý
            int[] result = knapsack(maxWeight, weights, values, itemNumber);
            
            // Sonuçlarýn ekrana yazdýrýlmasý
            System.out.println(result[0]);
            for (int i = 1; i <= itemNumber; i++) {
                System.out.print(result[i] + " ");
            }
            
            // Scanner nesnesinin kapatýlmasý
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static int[] knapsack(int maxWeight, int[] weights, int[] values, int n) {
        // Tablo oluþturma
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
        
        // Seçilen elemanlarýn bulunmasý
        int[] selected = new int[n + 1];
        int i = n, w = maxWeight;
        while (i > 0 && w > 0) {
            if (table[i][w] != table[i - 1][w]) {
                selected[i] = 1;
                w = w - weights[i - 1];
            }
            i--;
        }
        
        // Sonuç dizisi oluþturma
        int[] result = new int[n + 1];
        result[0] = table[n][maxWeight];
        for (i = 1; i <= n; i++) {
            result[i] = selected[i];
        }
        
        return result;
    }
}
