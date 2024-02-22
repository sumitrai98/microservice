package com.codeforsolution.user.service.userservice.model;


import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;
    @Version
    Long version = 1L;
    @LastModifiedDate
    LocalDateTime lastModified;

    private String firstName;
    private String middleName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private boolean enabled = true;
    private boolean accountNonLocked = true;
    private boolean accountNonExpired = true;
    private boolean credentialsNonExpired = true;
    private String rememberMeToken;
    private String registrationConfirmationToken;
    @NotNull
    private LocalDate registrationDate;
    private LocalDateTime lastLogin;

    public User() {
        registrationDate = LocalDate.now();
        lastModified = LocalDateTime.now();
        version = 1L;
    }

    public User(Long id, Long version, LocalDateTime lastModified, String firstName, String middleName, String lastName, String username, String password, String email, boolean enabled, boolean accountNonLocked, boolean accountNonExpired, boolean credentialsNonExpired, String rememberMeToken, String registrationConfirmationToken, LocalDate registrationDate, LocalDateTime lastLogin) {
        this.id = id;
        this.version = version;
        this.lastModified = lastModified;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.accountNonLocked = accountNonLocked;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.rememberMeToken = rememberMeToken;
        this.registrationConfirmationToken = registrationConfirmationToken;
        this.registrationDate = registrationDate;
        this.lastLogin = lastLogin;
    }
}
