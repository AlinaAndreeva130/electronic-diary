package ru.andreeva.electronicdiary.service.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "discipline")
@Getter
@Setter
public class Discipline {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "weekday_ids", nullable = false)
    private String weekdayIds;

    @Transient
    private String weekdaysSeparator = ",";

    @Transient
    private Set<Weekday> weekdays;

}