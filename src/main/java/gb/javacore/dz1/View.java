package gb.javacore.dz1;

public class View {
    public static void printMenu() {
        printBigDelimiter();
        System.out.println("""
                Меню:
                1 - Ввести новую заметку
                0 - Выход
                """);
    }

    public static void printEnterNote() {
        printSmallDelimiter();
        System.out.print("Введите заметку: ");
    }

    public static void printMessage(Note note) {
        printSmallDelimiter();
        System.out.println("Дозапись в файл: " + note.toString());
    }

    public static void printBigDelimiter() {
        System.out.println("\n==================================================\n");
    }

    public static void printSmallDelimiter() {
        System.out.println("\n--------------------------------------------------\n");
    }
}
