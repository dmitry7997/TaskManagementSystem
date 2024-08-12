package com.app.TaskManagementSystem.mapper;

import com.app.TaskManagementSystem.dto.NoteDto;
import com.app.TaskManagementSystem.dto.TaskNoteDto;
import com.app.TaskManagementSystem.entity.Note;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-12T17:55:41+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class NoteMapperImpl implements NoteMapper {

    @Override
    public NoteDto toNoteDto(Note note) {
        if ( note == null ) {
            return null;
        }

        NoteDto noteDto = new NoteDto();

        noteDto.setId( note.getId() );
        noteDto.setNote( note.getNote() );
        noteDto.setCreationDate( note.getCreationDate() );

        return noteDto;
    }

    @Override
    public Note toNote(NoteDto noteDto) {
        if ( noteDto == null ) {
            return null;
        }

        Note note = new Note();

        note.setId( noteDto.getId() );
        note.setNote( noteDto.getNote() );
        note.setCreationDate( noteDto.getCreationDate() );

        return note;
    }

    @Override
    public List<TaskNoteDto> toTaskNotetoList(List<Note> notes) {
        if ( notes == null ) {
            return null;
        }

        List<TaskNoteDto> list = new ArrayList<TaskNoteDto>( notes.size() );
        for ( Note note : notes ) {
            list.add( noteToTaskNoteDto( note ) );
        }

        return list;
    }

    protected TaskNoteDto noteToTaskNoteDto(Note note) {
        if ( note == null ) {
            return null;
        }

        TaskNoteDto taskNoteDto = new TaskNoteDto();

        taskNoteDto.setNote( note.getNote() );

        return taskNoteDto;
    }
}
