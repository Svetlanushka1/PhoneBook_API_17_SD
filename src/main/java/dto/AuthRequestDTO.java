package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//{
//        "username": "string",
//        "password": "tQ.F:25ak>X[O3\"t"
//        }
@Setter
@Getter
@Builder
@ToString

public class AuthRequestDTO {
    String username;
    String password;

}
