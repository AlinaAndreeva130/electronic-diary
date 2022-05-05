package ru.andreeva.electronicdiary.ui.view.entity;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;
import ru.andreeva.electronicdiary.service.dao.Weekday;
import ru.andreeva.electronicdiary.service.repository.WeekdayRepository;
import ru.andreeva.electronicdiary.service.specification.WeekdaySpecificationFactoryImpl;
import ru.andreeva.electronicdiary.ui.component.WeekdayEditor;
import ru.andreeva.electronicdiary.ui.view.MainLayout;

@Route(value = "schedule", layout = MainLayout.class)
@PageTitle("Расписание")
@Tag("schedule-view")
@JsModule("./view/entity/schedule-view.ts")
@UIScope
@Component
public class WeekdayView extends BaseView<Weekday, Integer, WeekdayRepository> {

    public WeekdayView(WeekdaySpecificationFactoryImpl specificationFactory,
                        WeekdayRepository repository,
                        WeekdayEditor editor) {
        super(repository, specificationFactory, editor);
    }

    @Override
    protected void createColumns() {
        grid.addColumn(Weekday::getName).setHeader("День недели").setKey("weekday");
    }
}
