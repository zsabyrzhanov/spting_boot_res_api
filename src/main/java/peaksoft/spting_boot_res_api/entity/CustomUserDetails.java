package peaksoft.spting_boot_res_api.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails  implements UserDetails {

    private String email;
    private String password;
    private Collection<?extends GrantedAuthority> grantedAuthorities;


    public static CustomUserDetails fromEntityToCustomUserDetails(User user){
        CustomUserDetails custom = new CustomUserDetails();
        custom.email = user.getEmail();
        custom.password = user.getPassword();
        custom.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getRoleName()));
        return custom;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
