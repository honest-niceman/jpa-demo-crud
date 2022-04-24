package io.jpabuddy.spring.demo.jpademo.dtos;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class TaskDto implements Serializable {
    private final Long id;
    private final Instant endDate;
    private final Instant startDate;
    private final String name;

    public TaskDto(Long id, Instant endDate, Instant startDate, String name) {
        this.id = id;
        this.endDate = endDate;
        this.startDate = startDate;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDto entity = (TaskDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.endDate, entity.endDate) &&
                Objects.equals(this.startDate, entity.startDate) &&
                Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, endDate, startDate, name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "endDate = " + endDate + ", " +
                "startDate = " + startDate + ", " +
                "name = " + name + ")";
    }
}
