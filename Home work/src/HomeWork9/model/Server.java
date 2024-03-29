package HomeWork9.model;

import HomeWork9.model.data.Notes;
import HomeWork9.model.sevice.NoteServiceImpl;
import HomeWork9.vueController.controller.Control;
import HomeWork9.vueController.vue.UserInterface;

public class Server {
    public static void runServer() {
        Notes listNotes = new Notes();

        NoteServiceImpl noteService = new NoteServiceImpl();
        noteService.FileRead(listNotes.getListNotes());

        Control controller = new Control();

        UserInterface userInterface = new UserInterface();

        System.out.println();
        System.out.println("Добро пожаловать в NotePad!");

        boolean terminalActive = true;
        while (terminalActive) {
            userInterface.userMenu();
            String action = userInterface.chooseAction();

            switch (action) {
                case "1" -> noteService.printAllNote(listNotes.getListNotes());
                case "2" -> noteService.addNewNote(listNotes.getListNotes(), controller.inputDataCreatNotes());
                case "3" -> noteService.removeNote(listNotes.getListNotes(), controller.inputIdForRemoveNote());
                case "4" -> terminalActive = false;
            }
        }
    }
}
