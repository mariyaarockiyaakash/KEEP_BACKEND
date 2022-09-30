package com.techguy.gkeep_bkend.controller;


import com.techguy.gkeep_bkend.DTO.CreateNoteReq;
import com.techguy.gkeep_bkend.apiReponse.APIResponse;
import com.techguy.gkeep_bkend.entity.Note;
import com.techguy.gkeep_bkend.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/keep")
@AllArgsConstructor
public class KeepController
{
	NoteService service;

	@PostMapping
	public ResponseEntity<APIResponse> createNote(@RequestBody CreateNoteReq req)
	{
		APIResponse response = new APIResponse();
		Note noteResponse = service.createNote(req);
		response.setData(noteResponse);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<APIResponse> getNote(@PathVariable long id)
	{
		APIResponse response = new APIResponse();
		Note note = service.fetchNote(id).get(0);
		response.setData(note);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<APIResponse> getAllNote()
	{
		APIResponse response = new APIResponse();
		List<Note> notes = service.fetchNote(-1);
		response.setData(notes);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<APIResponse> updateNote(@RequestBody Note req)
	{
		APIResponse response = new APIResponse();
		Note noteResponse = service.updateNote(req);
		response.setData(noteResponse);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<APIResponse> deleteNote(@PathVariable long id)
	{
		APIResponse response = new APIResponse();
		boolean result = service.removeNote(id);
		response.setData(result);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
