package com.fundoo.notes.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "notes")
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private Long userId;

    private boolean isPinned = false;
    private boolean isArchived = false;
    private boolean isDeleted = false;
}