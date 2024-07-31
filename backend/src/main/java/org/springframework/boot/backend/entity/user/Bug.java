package org.springframework.boot.backend.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Bug {
    private Long id;
    private String issueName;
    private String issueMessage;
}
