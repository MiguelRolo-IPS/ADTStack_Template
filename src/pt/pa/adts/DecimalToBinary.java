package pt.pa.adts;

import java.util.Scanner;

public class DecimalToBinary {

    public static String decimal2Binary(int decimal){
        StackArrayList<Integer> stack = new StackArrayList<>();
        for (int i = decimal; i > 0; i = i / 2) {
            stack.push(i % 2);
        }
        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal;
        System.out.println("Enter a decimal:");
        decimal = scanner.nextInt();
        System.out.println("Decimal: " + decimal);
        System.out.println("Binario: " + decimal2Binary(decimal));
    }
}
