package ru.andreeva.electronicdiary.service.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.andreeva.electronicdiary.service.dao.Note;
import ru.andreeva.electronicdiary.service.dao.Weekday;

@Component
public class NoteSpecificationFactoryImpl implements SpecificationFactory<Note> {
    @Override
    public Specification<Note> create(SearchCriteria criteria) {
        return new NoteSpecification(criteria);
    }
}
