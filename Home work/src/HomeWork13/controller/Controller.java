package HomeWork13.controller;

import HomeWork13.vue.UserInterface;


public class Controller {
    UserInterface userInterface = new UserInterface();
    ActionController actionController = new ActionController();

    public void start() {

        userInterface.initInterface();
        userInterface.initDataBase(actionController.initStartData());

        boolean terminalActive = true;
        while (terminalActive) {

            userInterface.userMenu();
            String action = actionController.chooseAction();

            switch (action) {
                case "1" -> actionController.getAll(); //GET
                case "2" -> actionController.postForm(); //POST
                case "3" -> actionController.postRemove(); //POST
                case "4" -> actionController.getResultSearch(); //GET
                case "5" -> terminalActive = false;
            }
        }
    }


}
