package contact_ok;

import com.google.gson.Gson;
import dto.AuthRequestDTO;
import dto.AuthResponseDTO;
import dto.ErrorDTO;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLOutput;

public class OkHttpLoginTest {
    //token "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiaGFpZmFAZ21haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE2NzU4NjM3MTgsImlhdCI6MTY3NTI2MzcxOH0.3WAdkonLBt-dkb8N3EXSXHY-Y8D-SIgHJz8UMGplDjw"


    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");

    @Test
    public void loginTest() throws IOException {//create object
        AuthRequestDTO requestDTO = AuthRequestDTO.builder()
                .username("haifa@gmail.com")
                .password("Haifa082022$")
                .build();
//library tp covert object to json
 // that we pass to server

        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
//we want to covert object to json
        RequestBody requestBody = RequestBody.create(gson.toJson(requestDTO),JSON);
//url type of request and format of request
        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
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