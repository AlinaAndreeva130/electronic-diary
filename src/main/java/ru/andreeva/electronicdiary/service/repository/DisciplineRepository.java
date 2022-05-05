package ru.andreeva.electronicdiary.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.andreeva.electronicdiary.service.dao.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Integer>, JpaSpecificationExecutor<Discipline> {
}