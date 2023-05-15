package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindItem {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Verileri girin (bo�luklarla ayr�lm��): ");
        String data = input.nextLine();

        // Verileri bo�luklara g�re b�ler ve int t�r�ne d�n��t�r�r
        String[] strNumbers = data.split(" ");
        int[] numbers = new int[strNumbers.length];
        for (int i = 0; i < strNumbers.length; i++) {
            numbers[i] = Integer.parseInt(strNumbers[i]);
        }

        // "1" say�s�n� ve "1"lerin bulundu�u indeksleri bulur
        List<Integer> indexes = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                count++;
                indexes.add(i+1);
            }
        }

        // "1" say�s�n� ve "1"lerin bulundu�u indeksleri ekrana yazd�r�r
        System.out.println("\"1\" say�s�: " + count);
        System.out.println("\"1\"lerin bulundu�u indeksler: " + indexes);
    }
}
