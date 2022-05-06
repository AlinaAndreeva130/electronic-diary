package ru.andreeva.electronicdiary.ui.view.entity;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.andreeva.electronicdiary.service.dao.Discipline;
import ru.andreeva.electronicdiary.service.dao.Note;
import ru.andreeva.electronicdiary.service.dao.Weekday;
import ru.andreeva.electronicdiary.service.repository.DisciplineRepository;
import ru.andreeva.electronicdiary.service.repository.NoteRepository;
import ru.andreeva.electronicdiary.service.repository.WeekdayRepository;
import ru.andreeva.electronicdiary.service.specification.DisciplineSpecificationFactoryImpl;
import ru.andreeva.electronicdiary.service.specification.NoteSpecificationFactoryImpl;
import ru.andreeva.electronicdiary.ui.component.DisciplineEditor;
import ru.andreeva.electronicdiary.ui.component.NoteEditor;
import ru.andreeva.electronicdiary.ui.view.MainLayout;

import java.util.Arrays;
import java.util.stream.Collectors;

@Route(value = "notes", layout = MainLayout.class)
@PageTitle("Заметки")
@Tag("note-view")
@JsModule("./view/entity/note-view.ts")
@UIScope
@Component
public class NoteView extends BaseView<Note, Integer, NoteRepository> {
    @Autowired
    private WeekdayRepository weekdayRepository;

    public NoteView(NoteSpecificationFactoryImpl specificationFactory, NoteRepository repository, NoteEditor editor) {
        super(repository, specificationFactory, editor);
    }

    @Override
    protected void createColumns() {
    }
}
