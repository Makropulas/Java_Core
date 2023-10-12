package gb.javacore.dz1;

public class Controller {
    public static void start() {
        while (true) {
            View.printMenu();
            int action = Model.action("[01]");
            if (action == 1) {
                View.printEnterNote();
                Note note = new Note(Model.scanner.nextLine());
                Model.writeInFile(note);
                View.printMessage(note);
                Model.waitingForInput();
            }
            if (action == 0) {
                break;
            }
        }
        Model.scanner.close();
    }
}
