package ru.andreeva.electronicdiary.ui.view.entity;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.andreeva.electronicdiary.service.dao.Discipline;
import ru.andreeva.electronicdiary.service.dao.Weekday;
import ru.andreeva.electronicdiary.service.repository.DisciplineRepository;
import ru.andreeva.electronicdiary.service.repository.WeekdayRepository;
import ru.andreeva.electronicdiary.service.specification.DisciplineSpecificationFactoryImpl;
import ru.andreeva.electronicdiary.ui.component.DisciplineEditor;
import ru.andreeva.electronicdiary.ui.view.MainLayout;

import java.util.Arrays;
import java.util.stream.Collectors;

@Route(value = "discipline", layout = MainLayout.class)
@PageTitle("Предмет")
@Tag("discipline-view")
@JsModule("./view/entity/discipline-view.ts")
@UIScope
@Component
public class DisciplineView extends BaseView<Discipline, Integer, DisciplineRepository> {
    @Autowired
    private WeekdayRepository weekdayRepository;

    public DisciplineView(DisciplineSpecificationFactoryImpl specificationFactory, DisciplineRepository repository, DisciplineEditor editor) {
        super(repository, specificationFactory, editor);
    }

    @Override
    protected void createColumns() {
        grid.addColumn(Discipline::getName).setHeader("Название предмета").setKey("name");
        grid.addColumn(item -> Arrays.stream(item.getWeekdayIds().split(item.getWeekdaysSeparator()))
                .map(id -> weekdayRepository.findById(Integer.parseInt(id.trim()))
                        .orElseGet(() -> new Weekday(-1, "Некорректно"))
                        .getName())
                .collect(Collectors.joining(", "))).setHeader("Дни недели").setKey("weekdays");
    }
}
