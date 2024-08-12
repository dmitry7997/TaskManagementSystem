package com.app.TaskManagementSystem.service.impl;

import com.app.TaskManagementSystem.dto.NoteDto;
import com.app.TaskManagementSystem.dto.TaskNoteDto;
import com.app.TaskManagementSystem.entity.Note;
import com.app.TaskManagementSystem.exception.ResourceNotFondException;
import com.app.TaskManagementSystem.mapper.NoteMapper;
import com.app.TaskManagementSystem.repository.NoteRepository;
import com.app.TaskManagementSystem.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    private final NoteMapper noteMapper;

    @Override
    public NoteDto createNote(NoteDto noteDto) {
        Note note = noteMapper.toNote(noteDto);
        Note savedNote = noteRepository.save(note);

        return noteMapper.toNoteDto(savedNote);
    }

    @Override
    public NoteDto getNoteById(Integer noteId) {
        Note note = noteRepository.findById(noteId);
        if (note != null) {
            return noteMapper.toNoteDto(note);
        } else {
            throw new ResourceNotFondException("Note does not exist with this id : " + noteId);
        }
    }

    @Override
    public List<NoteDto> getAllNotes() {
        List<Note> notes = noteRepository.findAll();
        return notes.stream().map((note) -> noteMapper.toNoteDto(note))
                .collect(Collectors.toList());
    }

    @Override
    public NoteDto updateNote(Integer noteId, NoteDto updateNote) {
        Note note = noteRepository.findById(noteId);
        if (note != null) {
            note.setNote(updateNote.getNote());

            Note updateNoteObj = noteRepository.save(note);

            return noteMapper.toNoteDto(updateNoteObj);
        } else {
            throw new ResourceNotFondException("Note does not exist with this id : " + noteId);
        }
    }

    @Override
    public void deleteNote(Integer noteId) {
        Note note = noteRepository.findById(noteId);
        if (note != null) {
            noteRepository.deleteById(noteId);
        } else {
            throw new ResourceNotFondException("Note does not exist with this id : " + noteId);
        }
    }

    @Override
    public List<TaskNoteDto> getTaskNote(Integer taskId) {
        List<Note> notes = noteRepository.findNotesByTaskId(taskId);

        return noteMapper.toTaskNotetoList(notes);
    }
}
