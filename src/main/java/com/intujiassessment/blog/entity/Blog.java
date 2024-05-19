package com.intujiassessment.blog.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "blog")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "blog_id")
    private Long id;

    @Column(name = "blog_title")
    @NonNull
    private String title;

    @Column(name = "blog_description")
    @NonNull
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    @NonNull
    private Category category;


}
