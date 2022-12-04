package HomeWork9.model.sevice;
import HomeWork9.model.data.Note;
import HomeWork9.model.repositories.Util;

import java.util.List;

public class NoteServiceImpl implements IService<Note>{
    @Override
    public void addNewNote(List<Note> listNote, String dataCreate) {

        String[] data = dataCreate.split(" ");
        Note note = new Note(data[0], data[1], data[2], data[3]);
        listNote.add(note);
        Util.write("Notes.txt", note.toString(), true);
    }

    @Override
    public void removeNote(List<Note> listNote, int idNote) {
        for (Note note : listNote) {
            if (note.getId() == idNote) {
                listNote.remove(note);
                break;
            }
        }
        System.out.println("Заметку по указанному id найти не удалось");
    }

    @Override
    public void printAllNote(List<Note> listNote) {
        for (int i = 0; i < listNote.size(); i++) {
            System.out.print(i+1 + ". ");
            System.out.println("id " + listNote.get(i).getId());
            System.out.println("Дата создания: " + listNote.get(i).getData());
            System.out.println("Статус: " + listNote.get(i).getStatus());
            System.out.println("Тема: " + listNote.get(i).getTitle());
            System.out.println("Описание задачи: " + listNote.get(i).getText());
            System.out.println("Состояние задачи: " + listNote.get(i).getState());
            System.out.println(" ");

        }
        if (listNote.size() == 0) {
            System.out.println("Лист пуст");
        }
    }

    public void FileRead(List<Note> listNote) {
        List<String> listNotes = Util.read("Notes.txt");

        for (String str : listNotes) {
            String[] arrayData = str.split(" ");

            Note note = new Note(arrayData[2], arrayData[3], arrayData[4].replaceAll("_", " "), arrayData[5]);
            note.setId(Integer.parseInt(arrayData[0]));
            note.setData(arrayData[1]);

            listNote.add(note);
        }
    }


}
