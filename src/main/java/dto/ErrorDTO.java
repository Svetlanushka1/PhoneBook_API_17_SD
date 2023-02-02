package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//{
//        "timestamp": "2023-01-31T16:28:43.669Z",
//        "status": 0,
//        "error": "string",
//        "message": {},
//        "path": "string"
//        }
@Setter
@Getter
@Builder
@ToString

public class ErrorDTO {

    int status;
    String error;
    String message;

}