package ru.andreeva.electronicdiary.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.andreeva.electronicdiary.service.dao.Weekday;

public interface WeekdayRepository extends JpaRepository<Weekday, Integer>, JpaSpecificationExecutor<Weekday> {
}