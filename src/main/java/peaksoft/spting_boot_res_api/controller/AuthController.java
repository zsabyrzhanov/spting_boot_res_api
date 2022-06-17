package peaksoft.spting_boot_res_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.spting_boot_res_api.dto.AuthResponse;
import peaksoft.spting_boot_res_api.dto.RegisterRequest;
import peaksoft.spting_boot_res_api.entity.User;
import peaksoft.spting_boot_res_api.security.JwtProvider;
import peaksoft.spting_boot_res_api.service.UserService;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider provider;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest request){
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        userService.saveUser(user);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody RegisterRequest request){
        User user = userService.findByLoginAndPassword(request.getEmail(),request.getPassword());
        String token = provider.generaToken(user.getEmail());
        return new AuthResponse(token);
    }


}
