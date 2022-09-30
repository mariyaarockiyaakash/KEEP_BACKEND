package com.techguy.gkeep_bkend.service;


import com.techguy.gkeep_bkend.DTO.CreateNoteReq;
import com.techguy.gkeep_bkend.entity.Note;
import com.techguy.gkeep_bkend.repository.NotesRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService
{
	@Autowired
	NotesRepo repo;

	@Override
	public Note createNote(CreateNoteReq req)
	{
		ModelMapper map=new ModelMapper();
		Note note = map.map(req, Note.class);
		note.setCreatedOn(LocalDateTime.now());
		note.setTrashed(Boolean.FALSE);
		return repo.save(note);

	}

	@Override
	public List<Note> fetchNote(long id)
	{
		if(id==-1)
		{
			return repo.findAll();
		}
		else
		{
			List<Note> response=new ArrayList<>();
			response.add(repo.findById(id).get());
			return response;
		}

	}



	@Override
	public Note updateNote(Note req)
	{
		return repo.save(req);
		
	}

	@Override
	public boolean removeNote(long id)
	{
		List<Note> notes = fetchNote(id);
		notes.get(0).setTrashed(Boolean.TRUE);
		updateNote(notes.get(0));
		return true;
	}
}
