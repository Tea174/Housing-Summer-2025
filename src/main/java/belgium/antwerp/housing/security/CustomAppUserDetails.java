package belgium.antwerp.housing.security;

import belgium.antwerp.housing.domain.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class CustomAppUserDetails extends User {
    private final int AppUserId;
    private final Role role;

    public CustomAppUserDetails(
            final int appUserId,
            final String username,
            final String password,
            final Role role) {
        super(username,password, List.of(new SimpleGrantedAuthority(
                "ROLE_" + role.toString())));
        this.AppUserId = appUserId;
        this.role = role;
    }
    public Role getRole() {
        return role;
    }
    public int getAppUserId() {
        return AppUserId;
    }
}
