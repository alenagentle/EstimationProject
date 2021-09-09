package ru.irlix.evaluation.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task_type_dictionary")
@Getter
@Setter
public class TaskTypeDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private String value;

    @OneToMany(mappedBy = "type")
    private List<Task> tasks;

    @OneToMany(mappedBy = "type")
    private List<TaskDictionary> taskDictionaries;
}
