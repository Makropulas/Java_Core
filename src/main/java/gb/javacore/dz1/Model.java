package gb.javacore.dz1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Model {
    static Scanner scanner = new Scanner(System.in);

    public static int action(String regex) {
        int i;
        while (true) {
            String message = "Введите номер действия: ";
            i = getIntFromConsole(message);
            String iString = String.valueOf(i);
            if (iString.matches(regex)) {
                break;
            }
        }
        return i;
    }

    public static int getIntFromConsole(String message) {
        int i;
        while (true) {
            System.out.print(message);
            try {
                i = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException ignored) {
            }
        }
        return i;
    }

    public static void waitingForInput() {
        System.out.print("\nДля продолжения нажмите Enter ");
        boolean pass = Boolean.parseBoolean(scanner.nextLine()); // способ, позволивший сделать ожидание ввода Enter (Придумал сам)
    }

    public static void writeInFile(Note note) {
        try (FileWriter writer = new FileWriter("notes.txt", true)) {
            writer.write(note.toString() + '\n');
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
