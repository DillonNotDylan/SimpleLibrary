package com.lirbraryapp.backend.dataTransferObjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LibraryRequest {
    @Schema(name = "Book Name", required = false)
    @JsonProperty("Book Name")
    private String bookName;

    @Schema(name = "Book Author", required = false)
    @JsonProperty("Book Author")
    private String bookAuthor;

    @Schema(name = "Book Genre", required = false)
    @JsonProperty("Book Genre")
    private String bookGenre;

    @Schema(name = "Book Release Date", required = false)
    @JsonProperty("Book Release Date")
    private String bookReleaseDate;

    @Schema(name = "Book ISBN", required = false)
    @JsonProperty("Book ISBN")
    private String bookISBN;

    @Schema(name = "Book Checked Out", required = false)
    @JsonProperty("Book Checked Out")
    private Integer checkedOut;

    @Schema(name = "Book Checked Out To", required = false)
    @JsonProperty("Book Checked Out To")
    private String checkedOutTo;

    @Schema(name = "Book Date Rented", required = false)
    @JsonProperty("Book Date Rented")
    private String dateRented;

    @Schema(name = "Book Due Date", required = false)
    @JsonProperty("Book Due Date")
    private String dueDate;

    @Schema(name = "Book Rating", required = false)
    @JsonProperty("Book Rating")
    private String bookRating;

    @Schema(name = "Book Image", required = false)
    @JsonProperty("Book Image")
    private String bookImage;
}

