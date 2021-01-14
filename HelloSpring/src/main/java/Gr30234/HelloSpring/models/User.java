package Gr30234.HelloSpring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class User extends AbstractEntity{

    @Column(nullable = false)
    //@NotNull(message = "Username required.")
    //@Size(min = 6, max = 32, message = "Username must be between 6 and 32 characters!")
    private String username;

    @Column(nullable = false)
    //@NotNull(message = "Password required.")
    //@Size(min = 6, max = 32, message = "Password must be at least 8 characters!")
    private String password;

    //@Transient
    //private String passwordConfirm;

    //@ManyToMany
    //private Set<Role> roles;
    private String roles = "";

    public User(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public String getPasswordConfirm() {
        return this.passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }*/

    public String getRoles() {
        return roles;
    }

    //public Set<Role> getRoles() {
    //    return this.roles;
    //}

    //public void setRoles(Set<Role> roles) {
    //    this.roles = roles;
    //}


    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
}
