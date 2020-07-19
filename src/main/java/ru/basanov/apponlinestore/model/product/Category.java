package ru.basanov.apponlinestore.model.product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    @Column(name = "background_image")
    private String backgroundImage;

    @Column(name = "url_alias")
    private String urlAlias;

    private String description;

    @Column(name = "content_type")
    private String contentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @OrderBy("index")
    private List<Category> childCategories = new ArrayList<>();

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @OrderBy("index")
    private List<Category> notHiddenChildCategories = new ArrayList<>();

    @Column(name = "final_category")
    private boolean finalCategory = false;

    private int index;

    private boolean hidden;

    private String header;

    @Column(name = "title_meta")
    private String titleMeta;

    @Column(name = "description_meta")
    private String descriptionMeta;

    public Category() {
    }
}
