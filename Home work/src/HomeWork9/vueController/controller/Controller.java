package HomeWork9.vueController.controller;

import java.util.Scanner;

public class Controller {
    public String inputDataCreatNotes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите стутус заметки");
        String status = scanner.nextLine();
        System.out.println("Введите заголовок заметки");
        String title = scanner.nextLine();
        System.out.println("Введите текст заметки");
        String text = scanner.nextLine().replaceAll(" ", "_");
        System.out.println("Введите состояние заметки");
        String state = scanner.nextLine();

        return status + " " +  title + " " + text + " " + state;
    }

    public int inputIdForRemoveNote() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите id заметки, которую хотите удалить");
        int noteID = scan.nextInt();
        return noteID;
    }



}
