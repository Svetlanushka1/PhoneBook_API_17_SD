package contact_ok;

import com.google.gson.Gson;
import dto.AuthRequestDTO;
import dto.AuthResponseDTO;
import dto.ErrorDTO;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkHttpRegistrationTest {


    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");

    @Test
    public void registrationTest() throws IOException {
        AuthRequestDTO requestDTO = AuthRequestDTO.builder()
                .username("rgisr1@gmail.com")
                .password("Registr082022$")
                .build();

        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = RequestBody.create(gson.toJson(requestDTO),JSON);

        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/user/registration/usernamepassword")
                .post(requestBody)
                .build()
                ;
        //Client starts new request and result will be readble response
        Response response = client.newCall(request).execute();
        //if code is 200
        if(response.isSuccessful()){
            String responseJson = response.body().string();
            AuthResponseDTO responseDTO = gson.fromJson(responseJson, AuthResponseDTO.class);
            System.out.println(responseDTO.getToken());
            String regToken = responseDTO.getToken();
            System.out.println(regToken);//"eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoicmdpc3IxQGdtYWlsLmNvbSIsImlzcyI6IlJlZ3VsYWl0IiwiZXhwIjoxNjc1OTUyMzkyLCJpYXQiOjE2NzUzNTIzOTJ9.zRQUl3QOJv368j7b1byc1uLdDhQjcuMsUnbo6b0j2LI";

            // "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoicmdpc3JAZ21haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE2NzU5NTIyMDAsImlhdCI6MTY3NTM1MjIwMH0.7_QTc5QIsE2pb1Tya3vhGUYrV1svKlwQgas_1_avQHI";
            System.out.println(response.code());

            Assert.assertTrue(response.isSuccessful());
        } else {
            System.out.println("Response code is = " + response.code());
            ErrorDTO errorDTO = gson.fromJson(response.body().string(), ErrorDTO.class);
            System.out.println(errorDTO.getStatus()
                    + " " + errorDTO.getMessage()
                    + " " + errorDTO.getError());

            Assert.assertFalse(response.isSuccessful());

        }

    }
}