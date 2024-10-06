package com.taidev198.shoesstore.model;

import com.taidev198.shoesstore.model.enums.AccountRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Account extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String email;
    private String displayName;
    private String password;
    @Enumerated(EnumType.STRING)
    private AccountRole role;
    private String fullName;
    private LocalDate dateOfBirth;
    private String address;
    private String phoneNumber;
    private Boolean gender;
    private String avatar;
    private Boolean isActive = true;
    // One-to-Many relationship with RefreshToken
    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY)
    private List<RefreshToken> refreshTokens;
    // One-to-Many relationship with ShoppingCart
    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY)
    private List<ShoppingCart> shoppingCarts;
    // One-to-Many relationship with Order
    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY)
    private List<Order> orders;

}