package com.example.btvalidation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Tên bài hát không được để trống")
    @Size(max = 800, message = "Tên bài hát không được vượt quá 800 ký tự")
    @Pattern(regexp = "^[^@;,.=+]+$", message = "Tên không được chứa ký tự đặc biệt")
    private String nameSong;

    @NotEmpty(message = "Tên nghệ sĩ không được để trống")
    @Size(max = 300, message = "Tên nghệ sĩ không được vượt quá 300 ký tự")
    @Pattern(regexp = "^[^@;,.=+]+$", message = "Tên nghệ sĩ không được chứa ký tự đặc biệt")
    private String artist;

    @NotEmpty(message = "Thể loại không được để trống")
    @Size(max = 1000, message = "Thể loại không được vượt quá 1000 ký tự")
    @Pattern(regexp = "^[^@;.=+]+$", message = "Thể loại chỉ được chứa dấu phẩy")
    private String genre;
}