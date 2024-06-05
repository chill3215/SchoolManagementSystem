package com.lechi.managementsystem.Model.Entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private String name;

    private String author;

    private int pages;

    private int publishedYear;
}
