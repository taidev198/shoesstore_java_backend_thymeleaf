package com.taidev198.shoesstore.model;

import com.taidev198.shoesstore.model.Embeddables.ProductDescription;
import com.taidev198.shoesstore.model.enums.ProductGender;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product extends EntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int price;
    private int originPrice;
    private int discount;
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductGender gender;
    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private ProductDescription description;
    // One-to-Many relationship with ProductImage
    @OneToMany(mappedBy = "product")
    private List<ProductImage> images;
    private LocalDateTime deleteAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Constant category;

    @ManyToOne
    @JoinColumn(name = "style_id")
    private Constant style;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Constant material;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<ProductDetail> productDetails;
}
