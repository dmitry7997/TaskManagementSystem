package com.app.TaskManagementSystem.repository.impl;

import com.app.TaskManagementSystem.entity.Note;
import com.app.TaskManagementSystem.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class NoteRepositoryImpl implements NoteRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void createNote(Note note) {
        String query = "INSERT INTO Note (note, creation_date) VALUES (?, ?)";
        jdbcTemplate.update(query, note.getNote(), LocalDateTime.now());
    }

    @Override
    public Note updateNote(Integer noteId, Note updateNote) {
        String sql = "UPDATE Note SET note = ? WHERE id = ?";

        jdbcTemplate.update(sql, updateNote.getNote(), noteId);

        Note updatedNote = jdbcTemplate.queryForObject("SELECT * FROM Note WHERE id = ?",
                new BeanPropertyRowMapper<>(Note.class), noteId);

        return updatedNote;
    }

    @Override
    public List<Note> findNotesByTaskId(Integer taskId) {
        String query = "SELECT * FROM Note WHERE task_Id = ?";
        List<Note> notes = jdbcTemplate.query(query,
                new Object[] {taskId} , new BeanPropertyRowMapper<>(Note.class));
        return notes;
    }

    @Override
    public void deleteById(Integer noteId) {
        String query = "DELETE FROM Note WHERE id =?";

        jdbcTemplate.update(query, noteId);
    }

    @Override
    public Note findById(Integer noteId) {
        String query = "SELECT * FROM Note WHERE id = ?";
        Note note = jdbcTemplate.queryForObject(query,
                new Object[] {noteId}, new BeanPropertyRowMapper<>(Note.class));
        return note;
    }

    @Override
    public Note save(Note note) { // проверить
        String query = "INSERT INTO Note (note, creation_date) VALUES (?, ?)";
        jdbcTemplate.update(query, note.getNote(), LocalDateTime.now());

        return note;
    }

    @Override
    public List<Note> findAll() {
        String query = "SELECT * FROM Note";
        List<Note> notes = jdbcTemplate.query(query,
                new BeanPropertyRowMapper<>(Note.class));
        return notes;
    }
}
