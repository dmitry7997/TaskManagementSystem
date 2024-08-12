package com.app.TaskManagementSystem.service;


import com.app.TaskManagementSystem.dto.NoteDto;
import com.app.TaskManagementSystem.dto.TaskNoteDto;

import java.util.List;

public interface NoteService  {
    NoteDto createNote(NoteDto noteDto);

    NoteDto getNoteById(Integer noteId);

    List<NoteDto> getAllNotes();

    NoteDto updateNote(Integer noteId, NoteDto updateNote);

    void deleteNote(Integer noteId);

    List<TaskNoteDto> getTaskNote(Integer taskId);
}
