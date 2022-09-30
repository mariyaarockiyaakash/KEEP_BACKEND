package com.techguy.gkeep_bkend.repository;

import com.techguy.gkeep_bkend.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepo extends JpaRepository<Note,Long>
{
}
