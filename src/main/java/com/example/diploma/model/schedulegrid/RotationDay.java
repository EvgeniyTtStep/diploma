package com.example.diploma.model.schedulegrid;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "rotation_day")
public class RotationDay implements Comparable<RotationDay>{

    @Id
    @Column(name="rotation_day_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private int num_in_seq;

    @ManyToOne
    @JoinColumn(name="semester_id")
    private Semester semester;


    public RotationDay() {
        super();
    }

    public RotationDay(String name, int NinSeq) {
        this.name = name;
        this.num_in_seq = NinSeq;
    }

    @OneToMany(mappedBy = "rotationday")
    private Collection<CalendarDay> calendar_days;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNum_in_seq() {
        return num_in_seq;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum_in_seq(int num_in_seq) {
        this.num_in_seq = num_in_seq;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(RotationDay o) {
        return num_in_seq - o.num_in_seq;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof RotationDay && ((RotationDay) o).getId().equals(this.id);
    }
}
