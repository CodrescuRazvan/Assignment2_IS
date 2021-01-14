package Gr30234.HelloSpring.security;

public enum ApplicationUserPermission {
    CLIENT_READ("client:read"),
    CLIENT_WRITE("client:write"),
    CLIENT_DELETE("client:delete"),
    EVENT_READ("event:read"),
    EVENT_WRITE("event:write"),
    EVENT_DELETE("event:delete"),
    CATEGORY_READ("category:read"),
    CATEGORY_WRITE("category:write"),
    TAG_READ("tag:read"),
    TAG_WRITE("tag:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
