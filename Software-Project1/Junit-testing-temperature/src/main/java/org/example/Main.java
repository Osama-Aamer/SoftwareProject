package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TemperatureConverter converter = new TemperatureConverter();

        while (true) {
            System.out.println("\n=== Temperature Converter ===");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("3. Kelvin to Celsius");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            if (choice == 4) break;

            System.out.print("Enter temperature value: ");
            double value = scanner.nextDouble();

            if (choice == 1) {
                double result = converter.fahrenheitToCelsius(value);
                System.out.printf("Result: %.2f °C\n", result);
            } else if (choice == 2) {
                double result = converter.celsiusToFahrenheit(value);
                System.out.printf("Result: %.2f °F\n", result);
            } else if (choice == 3) {
                double result = converter.kelvinToCelsius(value);
                System.out.printf("Result: %.2f °C\n", result);
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }
}