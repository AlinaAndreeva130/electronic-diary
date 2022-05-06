package ru.andreeva.electronicdiary.ui.component;

import com.vaadin.componentfactory.multiselect.MultiComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.andreeva.electronicdiary.service.dao.Discipline;
import ru.andreeva.electronicdiary.service.dao.Note;
import ru.andreeva.electronicdiary.service.dao.Weekday;
import ru.andreeva.electronicdiary.service.repository.DisciplineRepository;
import ru.andreeva.electronicdiary.service.repository.WeekdayRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class NoteEditor extends BaseEditor<Note> {

    public NoteEditor(DisciplineRepository repository) {
        super(repository, Note.class);
    }

    @Override
    protected void createContentPanel(VerticalLayout contentPanel) {
//        contentPanel.add(name, weekdays);
    }

    @Override
    protected Note createNewEntity() {
        return new Note();
    }

    @Override
    protected void actionBeforeAdd() {
//        weekdays.setItems(weekdayRepository.findAll());
    }

    @Override
    protected void actionBeforeEdit() {
    }

    @Override
    protected void actionBeforeSave() {
    }
}
