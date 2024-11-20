package hcmute.com.SecurityDemo.models;

import lombok.Data;

@Data
public class LoginDto {
        private String usernameOrEmail;
        private String password;
}
