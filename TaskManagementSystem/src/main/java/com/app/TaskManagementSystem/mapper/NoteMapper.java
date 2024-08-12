package com.app.TaskManagementSystem.mapper;

import com.app.TaskManagementSystem.dto.NoteDto;
import com.app.TaskManagementSystem.dto.TaskNoteDto;
import com.app.TaskManagementSystem.entity.Note;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NoteMapper {
    NoteDto toNoteDto(Note note);

    Note toNote(NoteDto noteDto);

    List<TaskNoteDto> toTaskNotetoList(List<Note> notes);
}
