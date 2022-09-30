package com.techguy.gkeep_bkend.service;

import com.techguy.gkeep_bkend.DTO.CreateNoteReq;
import com.techguy.gkeep_bkend.entity.Note;

import java.util.List;


public interface NoteService
{
	public Note createNote(CreateNoteReq req);
	public List<Note> fetchNote(long id);
	public Note updateNote(Note req);
	public boolean removeNote(long id);
}
