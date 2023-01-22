package farbfetzen.springdatajdbcsandbox.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Account {

    @Id
    @JsonIgnore
    private Integer id;
    private String name;
    private String email;
    @JsonIgnore
    private Set<Role> roles;

    public Account(final String name, final String email, final Set<Role> roles ) {
        this.name = name;
        this.email = email;
        this.roles = roles;
    }

    @JsonProperty("roles")
    public List<String> getRolesAsStrings() {
        return roles.stream().map(Role::getName).toList();
    }

}
