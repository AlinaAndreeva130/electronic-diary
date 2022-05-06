package ru.andreeva.electronicdiary.ui.component;

import com.vaadin.componentfactory.multiselect.MultiComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.andreeva.electronicdiary.service.dao.Discipline;
import ru.andreeva.electronicdiary.service.dao.Weekday;
import ru.andreeva.electronicdiary.service.repository.DisciplineRepository;
import ru.andreeva.electronicdiary.service.repository.WeekdayRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class DisciplineEditor extends BaseEditor<Discipline> {
    @Bind
    private TextField name;
    @Bind
    private MultiComboBox<Weekday> weekdays;
    @Autowired
    private WeekdayRepository weekdayRepository;

    public DisciplineEditor(DisciplineRepository repository) {
        super(repository, Discipline.class);
    }

    @Override
    protected void createContentPanel(VerticalLayout contentPanel) {
        name = new TextField("Название предмета");
        weekdays = new MultiComboBox<>("День недели");
        weekdays.setItemLabelGenerator(Weekday::getName);
        contentPanel.add(name, weekdays);
    }

    @Override
    protected Discipline createNewEntity() {
        return new Discipline();
    }

    @Override
    protected void actionBeforeAdd() {
        weekdays.setItems(weekdayRepository.findAll());
    }

    @Override
    protected void actionBeforeEdit() {
        Discipline item = getBinder().getBean();
        weekdays.setItems(weekdayRepository.findAll());
        weekdays.setValue(new HashSet<>(weekdayRepository.findAllById(Arrays.stream(item.getWeekdayIds()
                .split(item.getWeekdaysSeparator())).map(Integer::parseInt).collect(Collectors.toList()))));
    }

    @Override
    protected void actionBeforeSave() {
        Discipline item = getBinder().getBean();
        item.setWeekdayIds(item.getWeekdays().stream().map(Object::toString).collect(Collectors.joining(",")));
    }
}
