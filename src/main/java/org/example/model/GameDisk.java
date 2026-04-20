package org.example.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class GameDisk {
    private long id;
    @NotBlank(message = "Title khong duoc de trong")
    @Size(min = 3, max = 100, message = "Title phai co do dai tu 3 den 100 ky tu")
    private String title;
    @NotBlank(message = "Genre khong duoc de trong")
    private String genre;
    @Min(value = 0, message = "Quantity phai lon hon hoac bang 0")
    private int quantity;
    private String coverImage;

    public GameDisk() {
    }
    public GameDisk(long id, String title, String genre, int quantity, String coverImage) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.quantity = quantity;
        this.coverImage = coverImage;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getCoverImage() {
        return coverImage;
    }
}
