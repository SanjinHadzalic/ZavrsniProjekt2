package org.springframework.boot.backend.entity.input;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.backend.entity.user.AppUser;

@Entity
@Table(name = "ring_code")
@Data
public class RingCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;

    //TODO Add jUnit tests with Mockito
}
