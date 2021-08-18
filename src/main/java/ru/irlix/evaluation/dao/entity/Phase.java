package ru.irlix.evaluation.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="phase")
@Getter
@Setter
@NoArgsConstructor
public class Phase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotNull(message = "estimation is mandatory")
    @ManyToOne
    @JoinColumn(name = "estimation")
    private Estimation estimation;

    @NotNull(message = "sort_order is mandatory")
    @Column(name = "sort_order")
    private Integer sortOrder;

    @Column(name = "management_reserve")
    private Integer managementReserve;

    @Column(name = "bags_reserve")
    private Integer bagsReserve;

    @Column(name = "qa_reserve")
    private Integer qaReserve;

    @Column(name = "risk_reserve")
    private Integer riskReserve;

    @OneToMany(mappedBy = "phase", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private List<Task> tasks;

    @Column(name = "done")
    private Boolean done;

    @Column(name = "bags_reserve_on")
    private Boolean bagsReserveOn;

    @Column(name = "qa_reserve_on")
    private Boolean qaReserveOn;

    @Column(name = "management_reserve_on")
    private Boolean managementReserveOn;

    @Column(name = "risk_reserve_on")
    private Boolean riskReserveOn;

}
