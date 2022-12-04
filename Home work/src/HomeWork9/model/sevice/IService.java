package HomeWork9.model.sevice;

import HomeWork9.model.data.Note;

import java.util.List;

public interface IService<T> {
    void addNewNote(List<Note> listNote, String dataCreate);
    void removeNote(List<Note> listNote, int idNote);
    void printAllNote(List<T> listNote);
}
