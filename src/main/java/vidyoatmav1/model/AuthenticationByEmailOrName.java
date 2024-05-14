package vidyoatmav1.model;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vidyoatmav1.model.tablehelpers.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "authentication_by_email_or_name")
public class AuthenticationByEmailOrName implements UserDetails {
    @PrimaryKeyColumn(value = "login_email_or_name", type = PrimaryKeyType.PARTITIONED)
    private String loginEmailOrName;
    @Column(value = "loginpass")
    private String loginpass;
    @Column
    private Role role;
    @Column
    private UUID id;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.toString()));
    }

    @Override
    public String getPassword() {
        return this.loginpass;
    }

    @Override
    public String getUsername() {
        return this.loginEmailOrName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
