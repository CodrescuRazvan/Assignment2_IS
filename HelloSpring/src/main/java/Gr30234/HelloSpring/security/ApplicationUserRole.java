package Gr30234.HelloSpring.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static Gr30234.HelloSpring.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    CLIENT(Sets.newHashSet(EVENT_READ, EVENT_WRITE, EVENT_DELETE, CATEGORY_READ, TAG_READ)),
    ADMIN(Sets.newHashSet(CLIENT_READ, CLIENT_WRITE, CLIENT_DELETE, EVENT_READ, EVENT_WRITE, EVENT_DELETE, CATEGORY_READ, CATEGORY_WRITE, TAG_READ, TAG_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
