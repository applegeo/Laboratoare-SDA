import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            Path filePath = Paths.get("numere.txt");
            Path outputDir = Paths.get("rezultate.txt");


            List<String> lines = Files.readAllLines(filePath);
            System.out.println("re, ce contine fisierul " + lines);

            if (lines.size() < 2) {
                System.out.println("2 boss, tre 2");
                return;
            }

            int num1 = Integer.parseInt(lines.get(0).trim());
            int num2 = Integer.parseInt(lines.get(1).trim());

            Counter c1 = new Counter(0, num1);
            Counter c2 = new Counter(num1, num2);

            Suma sTh1 = new Suma(c1);
            Suma sTh2 = new Suma(c2);
            sTh1.start();
            sTh2.start();

            sTh1.join();
            sTh2.join();

            int sumtot = sTh1.getSuma() + sTh2.getSuma();
            String result = "Prima suma este: " + sTh1.getSuma() + "\n" +
                    "A doua suma este: " + sTh2.getSuma() + "\n" +
                    "Suma suma este: " + sumtot;

            System.out.println("Prima suma este: " + sTh1.getSuma());
            System.out.println("A doua suma este: " + sTh2.getSuma());
            System.out.println("Suma suma este: " + sumtot);


            Files.write(outputDir, Arrays.asList(result));
            System.out.println("Rezultatele au fost salvate în: " + outputDir);

        } catch (IOException e) {
            System.out.println("eroare citire folder " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("numere, nu alte caractere " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("s a dus " + e.getMessage());
        }
    }
}
