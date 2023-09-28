import java.util.Scanner;

public class TempConversion {

    public static double kelvinToFahrenheit(double k) {
        double celsius = kelvinToCelsius(k);
        return celsiusToFahrenheit(celsius);
    }

    public static double kelvinToCelsius(double k) {
        return k - 273.15;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5.0 / 9.0;
    }

    public static double celsiusToFahrenheit(double c) {
        return c * 9.0/5.0 + 32.0;
    }

    public static double celsiusToKelvin(double c) {
        return c + 273.15;
    }

    public static double fahrenheitToKelvin(double f) {
        double c = fahrenheitToCelsius(f);
        return celsiusToKelvin(c);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Temperature Conversion Program");
        System.out.println("1. Generate a table");
        System.out.println("2. Convert a single value");
        System.out.print("Enter your choice (1/2): ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Choose starting conversion value.\n1 for Fahrenheit.\n2 for Celsius.\n3 for Kelvin.\n");
                System.out.print("Your choice: ");
                int tableChoice = scanner.nextInt();
                switch (tableChoice) {
                    case 1:
                        System.out.print("Enter the lowest Fahrenheit value for the table: ");
                        int lowestValue = scanner.nextInt();
                        System.out.print("Enter the highest Fahrenheit value for the table: ");
                        int highestValue = scanner.nextInt();

                        if (highestValue >= lowestValue) {
                            System.out.println("Fahrenheit\tCelsius\tKelvin");
                            for (int i = lowestValue; i <= highestValue; i++) {
                                double celsius = fahrenheitToCelsius(i);
                                double kelvin = fahrenheitToKelvin(i);
                                System.out.printf("%d\t%.2f\t%.2f%n", i, celsius, kelvin);
                            }
                        } else {
                            System.out.println("Invalid input: Highest value must be greater than or equal to the lowest value.");
                        }
                        break;

                    case 2:
                        System.out.print("Enter the lowest Celsius value for the table: ");
                        int celsiusLowestValue = scanner.nextInt();
                        System.out.print("Enter the highest Celsius value for the table: ");
                        int celsiusHighestValue = scanner.nextInt();

                        if (celsiusHighestValue >= celsiusLowestValue) {
                            System.out.println("Celsius\tFahrenheit\tKelvin");
                            for (int i = celsiusLowestValue; i <= celsiusHighestValue; i++) {
                                double cfahrenheit = celsiusToFahrenheit(i);
                                double ckelvin = celsiusToKelvin(i);
                                System.out.printf("%d\t%.2f\t%.2f%n", i, cfahrenheit, ckelvin);
                            }
                        } else {
                            System.out.println("Invalid input: Highest value must be greater than or equal to the lowest value.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter the lowest Kelvin value for the table: ");
                        int kelvinLowestValue = scanner.nextInt();
                        System.out.print("Enter the highest Kelvin value for the table: ");
                        int kelvinHighestValue = scanner.nextInt();

                        if (kelvinHighestValue >= kelvinLowestValue) {
                            System.out.println("Kelvin\tFahrenheit\tCelsius");
                            for (int i = kelvinLowestValue; i <= kelvinHighestValue; i++) {
                                double kfahrenheit = kelvinToFahrenheit(i);
                                double kcelsius = kelvinToCelsius(i);
                                System.out.printf("%d\t%.2f\t%.2f%n", i, kfahrenheit, kcelsius);
                            }
                        } else {
                            System.out.println("Invalid input: Highest value must be greater than or equal to the lowest value.");
                        }
                        break;

                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
                break;

            case 2:
                System.out.print("Enter a Fahrenheit, Celsius, or Kelvin value: ");
                double inputValue = scanner.nextDouble();

                System.out.println("Choose conversion:");
                System.out.println("1. Fahrenheit to Celsius and Kelvin");
                System.out.println("2. Celsius to Fahrenheit and Kelvin");
                System.out.println("3. Kelvin to Fahrenheit and Celsius"); // Added the third option
                int conversionChoice = scanner.nextInt();

                double convertedValue = 0;
                String fromUnit = "";
                String toUnit = "";

                switch (conversionChoice) {
                    case 1:
                        convertedValue = fahrenheitToCelsius(inputValue);
                        fromUnit = "Fahrenheit";
                        toUnit = "Celsius";
                        break;
                    case 2:
                        convertedValue = celsiusToFahrenheit(inputValue);
                        fromUnit = "Celsius";
                        toUnit = "Fahrenheit";
                        break;
                    case 3:
                        convertedValue = kelvinToCelsius(inputValue);
                        fromUnit = "Kelvin";
                        toUnit = "Celsius";
                        break;
                    default:
                        System.out.println("Invalid conversion choice.");
                        scanner.close();
                        return;
                }

                double kelvinValue = celsiusToKelvin(convertedValue);

                System.out.printf("%.2f %s is %.2f %s and %.2f Kelvin%n", inputValue, fromUnit, convertedValue, toUnit, kelvinValue);
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }

        scanner.close();
    }
}
