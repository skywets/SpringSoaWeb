package spring.soa.web.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "users")
public class User {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Size@Size(min=2, message = "At least 5 characters")
    private Long id;
    @Column(name = "name", nullable = false)
    @Size@Size(min=2, message = "At least 5 characters")
    private String name;
    @Column(name = "password")
    @Size@Size(min=2, message = "At least 5 characters")
    private String password;
    @Transient
    private String passwordConfirm;
}
