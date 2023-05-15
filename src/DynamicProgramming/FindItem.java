package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindItem {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Verileri girin (boþluklarla ayrýlmýþ): ");
        String data = input.nextLine();

        // Verileri boþluklara göre böler ve int türüne dönüþtürür
        String[] strNumbers = data.split(" ");
        int[] numbers = new int[strNumbers.length];
        for (int i = 0; i < strNumbers.length; i++) {
            numbers[i] = Integer.parseInt(strNumbers[i]);
        }

        // "1" sayýsýný ve "1"lerin bulunduðu indeksleri bulur
        List<Integer> indexes = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                count++;
                indexes.add(i+1);
            }
        }

        // "1" sayýsýný ve "1"lerin bulunduðu indeksleri ekrana yazdýrýr
        System.out.println("\"1\" sayýsý: " + count);
        System.out.println("\"1\"lerin bulunduðu indeksler: " + indexes);
    }
}
