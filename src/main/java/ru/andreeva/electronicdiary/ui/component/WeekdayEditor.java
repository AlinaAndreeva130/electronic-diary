package ru.andreeva.electronicdiary.ui.component;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Component;
import ru.andreeva.electronicdiary.service.dao.Weekday;
import ru.andreeva.electronicdiary.service.repository.WeekdayRepository;

@Component
public class WeekdayEditor extends BaseEditor<Weekday> {
    /*@Bind("student")
    private ComboBox<Weekday> name;*/

    public WeekdayEditor(WeekdayRepository repository) {
        super(repository, Weekday.class);
    }

    @Override
    protected void createContentPanel(VerticalLayout contentPanel) {
       /* name = new ComboBox<>("Ученик");
        name.setItemLabelGenerator(
                item -> item.getFirstName() + " " + item.getLastName() + " " + item.getPatronymic() + " " + item.getClazz());
        contentPanel.add(name);*/
    }

    @Override
    protected Weekday createNewEntity() {
        return new Weekday();
    }
}
