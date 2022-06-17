package peaksoft.spting_boot_res_api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {

    private String email;
    private String password;
}
