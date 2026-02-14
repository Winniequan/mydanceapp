package com.mydanceapp.mydanceapp.course;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.mydanceapp.mydanceapp.common.TimeStampedEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course extends TimeStampedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name="level", nullable=false)
    @Enumerated(EnumType.STRING)
    private Level level;
    @Column(name="description", nullable=false)
    private String description;
    @Column(name="price", nullable=false)
    private BigDecimal price;
    @Column(name="location", nullable=false)
    private String location;
    @Column(name="start_time", nullable=false)
    private LocalDateTime startTime;
    @Column(name="end_time", nullable=false)
    private LocalDateTime endTime;
    @Column(name="capacity", nullable=false)
    private int capacity; 
}
