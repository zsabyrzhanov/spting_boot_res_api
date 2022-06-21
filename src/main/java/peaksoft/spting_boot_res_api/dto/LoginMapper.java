package peaksoft.spting_boot_res_api.dto;

import org.springframework.stereotype.Component;
import peaksoft.spting_boot_res_api.entity.Role;
import peaksoft.spting_boot_res_api.entity.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class LoginMapper {

    public LoginResponse loginView(String token, String message, User user){
        var loginResponse = new LoginResponse();
        if (user != null){
            setAuthority(loginResponse,user.getRoles());
        }

        loginResponse.setJwtToken(token);
        loginResponse.setMessages(message);
        return loginResponse;
    }

    private void setAuthority(LoginResponse loginResponse, List<Role> roles) {
        Set<String> authorities = new HashSet<>();
        for (Role role : roles){
            authorities.add(role.getRoleName());
        }
        loginResponse.setAuthorities(authorities);
    }
}
