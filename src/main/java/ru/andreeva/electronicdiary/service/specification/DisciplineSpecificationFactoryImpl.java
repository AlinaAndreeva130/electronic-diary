package ru.andreeva.electronicdiary.service.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.andreeva.electronicdiary.service.dao.Discipline;

@Component
public class DisciplineSpecificationFactoryImpl implements SpecificationFactory<Discipline> {
    @Override
    public Specification<Discipline> create(SearchCriteria criteria) {
        return new DisciplineSpecification(criteria);
    }
}
