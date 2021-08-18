package ru.irlix.evaluation.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name="estimation")
@Getter
@Setter
@NoArgsConstructor
public class Estimation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "create_date")
    @CreationTimestamp
    private Instant createDate;

    @Column(name = "description")
    private String description;

    @Column(name = "risk")
    private Integer risk;

    @ManyToOne
    @JoinColumn(name = "status")
    private Status status;

    @Column(name = "client")
    private String client;

    @Column(name = "creator")
    private String creator;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "estimation")
    private List<Phase> phases;
}
