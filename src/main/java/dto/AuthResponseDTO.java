package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//{
//        "token": "string"
//        }
@Setter
@Getter
@Builder
@ToString

public class AuthResponseDTO {
    String token;
    //String token = "eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiaGFpZmFAZ21haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE2NzU3ODc3NDMsImlhdCI6MTY3NTE4Nzc0M30.Wt1Ic-FhOd5ZpQXTdZpWBf8gmvMsBtXvtlNMXSNNIoM";
}