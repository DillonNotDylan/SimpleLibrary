package com.lirbraryapp.backend.dataTransferObjects;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookInfo {
    @Schema(name = "Book ISBN", required = false)
    private String isbn;

    @Schema(name = "Book Name", required = false)
    private String bookName;

    @Schema(name = "Book Author", required = false)
    private String author;

    @Schema(name = "Book Genre", required = false)
    private String genre;

    @Schema(name = "Book Rating", required = false)
    private double rating;

    @Schema(name = "Book Date Published", required = false)
    private Date datePublished;

    @Schema(name = "Book Checked In", required = false)
    private Integer checkedIn;

    @Schema(name = "Book Checked Out To", required = false)
    private String checkedOutTo;

    @Schema(name = "Book Date Rented", required = false)
    private Date dateRented;

    @Schema(name = "Book Due Date", required = false)
    private Date dueDate;

    @Schema(name = "Book Image URL", required = false)
    private String imageUrl;
}
