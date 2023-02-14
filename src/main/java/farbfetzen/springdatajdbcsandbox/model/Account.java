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
    private final String name;
    private final String email;
    @JsonIgnore
    private final Set<Role> roles;

    @JsonProperty("roles")
    public List<String> getRolesAsStrings() {
        return roles.stream().map(Role::getName).toList();
    }

}
