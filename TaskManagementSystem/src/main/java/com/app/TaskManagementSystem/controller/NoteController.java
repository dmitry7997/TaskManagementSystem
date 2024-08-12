package com.app.TaskManagementSystem.controller;

import com.app.TaskManagementSystem.dto.NoteDto;
import com.app.TaskManagementSystem.dto.TaskNoteDto;
import com.app.TaskManagementSystem.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NoteController {

    private final NoteService noteService;

    @PostMapping("user/api/notes")
    public ResponseEntity<NoteDto> createNote(@RequestBody NoteDto noteDto) {
        NoteDto savedNote = noteService.createNote(noteDto);
        return new ResponseEntity<>(savedNote, HttpStatus.CREATED);
    }

    @GetMapping("user/api/notes/{id}")
    public ResponseEntity<NoteDto> getNoteById(@PathVariable("id") Integer noteId) {
        NoteDto noteDto = noteService.getNoteById(noteId);
        return ResponseEntity.ok(noteDto);
    }

    @GetMapping("user/api/notes")
    public ResponseEntity<List<NoteDto>> getAllNotes() {
        List<NoteDto> notes = noteService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    @PutMapping("user/api/notes/{id}")
    public ResponseEntity<NoteDto> updateNote(@PathVariable("id") Integer noteId,
                                                @RequestBody NoteDto updatedNote) {
        NoteDto noteDto = noteService.updateNote(noteId, updatedNote);
        return ResponseEntity.ok(noteDto);
    }

    @DeleteMapping("admin/api/notes/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable("id") Integer noteId) {
        noteService.deleteNote(noteId);
        return ResponseEntity.ok("Note was successfully deleted");
    }

    @GetMapping("user/api/notes/linkedNotes/{taskId}")
    public ResponseEntity<List<TaskNoteDto>> getTaskNote(@PathVariable Integer taskId) {
        List<TaskNoteDto> notes = noteService.getTaskNote(taskId);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }
}