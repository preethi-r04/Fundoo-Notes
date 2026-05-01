package com.fundoo.notes.controller;

import com.fundoo.notes.dto.NoteRequest;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public String createNote(@RequestBody NoteRequest request,
                             Authentication auth) {

        String email = (String) auth.getPrincipal();

        return noteService.createNote(request, email);
    }
    @GetMapping
    public List<Note> getNotes(Authentication auth) {

        String email = (String) auth.getPrincipal();

        return noteService.getNotes(email);
    }
}