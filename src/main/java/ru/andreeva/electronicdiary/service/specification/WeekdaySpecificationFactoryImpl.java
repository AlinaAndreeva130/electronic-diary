package ru.andreeva.electronicdiary.service.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.andreeva.electronicdiary.service.dao.Discipline;
import ru.andreeva.electronicdiary.service.dao.Weekday;

@Component
public class WeekdaySpecificationFactoryImpl implements SpecificationFactory<Weekday> {
    @Override
    public Specification<Weekday> create(SearchCriteria criteria) {
        return new WeekdaySpecification(criteria);
    }
}
