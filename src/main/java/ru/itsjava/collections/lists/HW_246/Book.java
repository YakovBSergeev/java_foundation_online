package ru.itsjava.collections.lists.HW_246;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private final String author;
    private int numberOfPages;
}
