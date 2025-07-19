import java.io.*;
import java.util.Scanner;

public class file {

    static final String FILE_NAME = "codtech_task.txt";

    // 1. Create and write to a file
    public static void writeToFile() {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            writer.write("Welcome to CODTECH Internship!\n");
            writer.write("This file is created using Java File Handling.\n");
            writer.close();
            System.out.println("File created and content written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing.");
            e.printStackTrace();
        }
    }

    // 2. Read the file content
    public static void readFromFile() {
        try {
            File file = new File(FILE_NAME);
            Scanner reader = new Scanner(file);
            System.out.println("\nFile Content:");
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    // 3. Modify the file by appending new content
    public static void appendToFile() {
        try {
            FileWriter writer = new FileWriter(FILE_NAME, true); // true enables append mode
            writer.write("This is newly appended text.\n");
            writer.write("End of file.\n");
            writer.close();
            System.out.println("\nNew content appended successfully.");
        } catch (IOException e) {
            System.out.println("Error while appending.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        writeToFile();      // Step 1
        readFromFile();     // Step 2
        appendToFile();     // Step 3
        readFromFile();     // Step 4 (View updated content)
    }
}
