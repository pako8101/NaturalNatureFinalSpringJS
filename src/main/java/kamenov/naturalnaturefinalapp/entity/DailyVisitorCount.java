package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "daily_visitor_count") // Ясно задаваме името на таблицата
public class DailyVisitorCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false, unique = true) // Уникалност на датата
    private LocalDate date;

    @Column(name = "unique_visitors", nullable = false)
    private Long uniqueVisitors;

    // Конструктори
    public DailyVisitorCount() {
    }

    public DailyVisitorCount(LocalDate date, Long uniqueVisitors) {
        this.date = date;
        this.uniqueVisitors = uniqueVisitors;
    }

    public Long getId() {
        return id;
    }

    public DailyVisitorCount setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public DailyVisitorCount setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Long getUniqueVisitors() {
        return uniqueVisitors;
    }

    public DailyVisitorCount setUniqueVisitors(Long uniqueVisitors) {
        this.uniqueVisitors = uniqueVisitors;
        return this;
    }
}