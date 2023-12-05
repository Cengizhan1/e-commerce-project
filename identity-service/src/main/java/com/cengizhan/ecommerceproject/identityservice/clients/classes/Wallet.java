package com.cengizhan.ecommerceproject.identityservice.clients.classes;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class Wallet implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    @NotEmpty
    private Integer userId;
    private Float balance;
}
