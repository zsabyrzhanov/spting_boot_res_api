package peaksoft.spting_boot_res_api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import peaksoft.spting_boot_res_api.entity.CustomUserDetails;
import peaksoft.spting_boot_res_api.entity.User;
import peaksoft.spting_boot_res_api.service.UserService;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService service;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = service.findByEmail(email);
        return CustomUserDetails.fromEntityToCustomUserDetails(user);
    }
}
