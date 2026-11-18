import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class WriteUserInputNew {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (Scanner sc = new Scanner(System.in);
             BufferedWriter bw = Files.newBufferedWriter(Paths.get("user_input.txt"),
                     StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {

            System.out.println("Masukkan teks (ketik 'exit' untuk menyimpan dan keluar):");
            while (true) {
                System.out.print("> ");
                String text = sc.nextLine();

                if (text.equalsIgnoreCase("exit")) {
                    break;
                }

                String timestamp = LocalDateTime.now().format(formatter);
                bw.write("[" + timestamp + "] " + text);
                bw.newLine();
            }
            System.out.println("Seluruh input berhasil disimpan ke user_input.txt!");
        } catch (IOException e) {
            System.out.println("Galat: " + e.getMessage());
        }
    }
}