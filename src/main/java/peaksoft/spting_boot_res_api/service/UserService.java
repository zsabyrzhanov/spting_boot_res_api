package peaksoft.spting_boot_res_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.spting_boot_res_api.dto.RegisterRequest;
import peaksoft.spting_boot_res_api.dto.RegisterResponse;
import peaksoft.spting_boot_res_api.entity.User;
import peaksoft.spting_boot_res_api.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterResponse create(RegisterRequest request){
        User user = mapToEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        return mapToResponse(user);

    }

    private User mapToEntity(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setPassword(request.getPassword());
        return user;
    }

    private RegisterResponse mapToResponse(User user){

        if (user == null){
            return null;
        }
        RegisterResponse response = new RegisterResponse();
        if (user.getId() != null){
            response.setId(String.valueOf(user.getId()));
        }
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        return response;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
        .orElseThrow(()-> new UsernameNotFoundException("User with email not found"));
    }
}
