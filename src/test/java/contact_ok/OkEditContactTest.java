package contact_ok;

//4790a202-0030-4582-9985-44f04f055546
//        rem_1706@mail.com
//12345678901706


import com.google.gson.Gson;
import dto.ContactDto;
import dto.ResponseMessageDto;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkEditContactTest {

    String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiYWJjQGRlZi5jb20iLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTY3NTc4NzcxOSwiaWF0IjoxNjc1MTg3NzE5fQ.kNxBwJ6gEX2VJzh9F9kxTiiseXz9ZyU54s58oTbzM-w";
    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");

    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();

    ContactDto contact = ContactDto.builder()
            .id("4790a202-0030-4582-9985-44f04f055546")
            .name("Rem_1706")
            .lastName("Edited")
            .email("rem_1706@mail.com")
            .phone("12345678901706")
            .address("Haifa")
            .description("Edited Contact_1706")
            .build();

    @Test
    public void editById() throws IOException {
        RequestBody requestBody = RequestBody.create(gson.toJson(contact), JSON);

        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/contacts/")
                .addHeader("Authorization", token)
                .put(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());
        ResponseMessageDto messageDto = gson.fromJson(response.body().string(), ResponseMessageDto.class);
        String message = messageDto.getMessage();
        System.out.println(message);
    }
}
