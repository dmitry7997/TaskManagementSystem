package com.app.TaskManagementSystem.repository;

import com.app.TaskManagementSystem.entity.Note;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository {
    void createNote(Note note);

    Note updateNote(Integer noteId, Note updateNote);

    List<Note> findNotesByTaskId(Integer taskId);

    void deleteById(Integer noteId);

    Note findById(Integer noteId);

    Note save(Note note);

    List<Note> findAll();
}
