package ru.andreeva.electronicdiary.ui.component;

import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Comparator;


public abstract class BaseEditor<T> extends Dialog {
    @Getter
    private Binder<T> binder;
    private JpaRepository repository;
    private Class<T> entityClass;
    private Runnable actionAfterEdit;

    public BaseEditor(JpaRepository repository, Class<T> entityClass) {
        this.repository = repository;
        this.entityClass = entityClass;
        createClosePanel();
    }

    protected abstract void createContentPanel(VerticalLayout contentPanel);

    private void createActionPanel(JpaRepository repository) {
        Button saveBtn = new Button("Сохранить", event -> {
            close();
            if (binder.getBean() == null) {
                binder.setBean(createNewEntity());
            }
            actionBeforeSave();
            repository.save(binder.getBean());

            actionAfterEdit.run();
        });
        Button cancelBtn = new Button("Отмена", event -> close());
        HorizontalLayout actionPanel = new HorizontalLayout(saveBtn, cancelBtn);
        add(actionPanel);
    }

    private void createClosePanel() {
        Button closeBtn = new Button(new Icon(VaadinIcon.CLOSE), event -> close());
        HorizontalLayout closePanel = new HorizontalLayout(closeBtn);
        closePanel.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        add(closePanel);
    }

    @PostConstruct
    private void postConstruct() {
        VerticalLayout contentPanel = new VerticalLayout();
        add(contentPanel);
        createContentPanel(contentPanel);
        createActionPanel(repository);
        bindFields();
    }

    private void bindFields() {
        binder = new Binder<>(entityClass);
        Arrays.stream(this.getClass().getDeclaredFields()).filter(field -> field.isAnnotationPresent(Bind.class))
                .forEach(field -> {
                    try {
                        String propertyName = StringUtils.isNotEmpty(
                                field.getAnnotation(Bind.class).value()) ? field.getAnnotation(Bind.class)
                                .value() : field.getName();
                        field.setAccessible(true);
                        Object fieldInstance = field.get(this);
                        if (fieldInstance == null) {
                            throw new IllegalArgumentException("Field must be initialized");
                        }

                        binder.bind((HasValue<?, ?>) fieldInstance,
                                propertyName);
                    } catch (IllegalAccessException e) {
                        throw new IllegalArgumentException("Binding class not contain filed " + field.getName());
                    } catch (ClassCastException e) {
                        throw new IllegalArgumentException("There is no possibility of binding a field of this type");
                    }
                });
    }

    public void add(Runnable actionAfterEdit) {
        this.actionAfterEdit = actionAfterEdit;
        super.open();
        binder.setBean(createNewEntity());
        actionBeforeAdd();
    }

    public void edit(T entity, Runnable actionAfterEdit) {
        this.actionAfterEdit = actionAfterEdit;
        super.open();
        actionBeforeEdit();
        binder.setBean(entity);
    }

    protected abstract T createNewEntity();

    protected void actionBeforeAdd() {

    }

    protected void actionBeforeEdit() {

    }

    protected void actionBeforeSave() {

    }
}
