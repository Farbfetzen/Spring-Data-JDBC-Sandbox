package farbfetzen.springdatajdbcsandbox.model;

import lombok.Data;
import org.springframework.data.annotation.Transient;

@Data
public class Role {

    public static final String ADMIN = "admin";
    public static final String USER = "user";
    private final String name;
    @Transient
    private Account account;

}
