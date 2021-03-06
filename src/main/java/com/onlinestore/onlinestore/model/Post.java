package com.onlinestore.onlinestore.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;


    @OneToOne
    @JoinColumn(name = "city_Id")
    City city;

    @DateTimeFormat(pattern = "mm/dd/yyyy")
    String date;

    UUID imageId;


    @OneToOne
    @JoinColumn(name = "category_Id")
    Category category;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "post_wish_id",
            joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "wish_id", referencedColumnName = "id"))
    List<WishList> wishList;


}
