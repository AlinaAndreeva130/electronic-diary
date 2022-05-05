package ru.andreeva.electronicdiary.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.andreeva.electronicdiary.service.dao.Note;

public interface NoteRepository extends JpaRepository<Note, Integer>, JpaSpecificationExecutor<Note> {
}