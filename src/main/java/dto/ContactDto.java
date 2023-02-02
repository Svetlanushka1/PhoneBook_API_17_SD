package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//{
//        "contacts": [
//        {
//        "id": "string",
//        "name": "string",
//        "lastName": "string",
//        "email": "string",
//        "phone": "437641991380",
//        "address": "string",
//        "description": "string"
//        }
//        ]
//        }
@Setter
@Getter
@Builder
@ToString

public class ContactDto {
    String id;
    String name;
    String lastName;
    String email;
    String phone;
    String address;
    String description;
}
