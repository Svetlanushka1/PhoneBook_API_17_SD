package contact_ok;

import com.google.gson.Gson;
import dto.ResponseMessageDto;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkDeleteById {
    /*
    a7a2513a-a3c1-40c1-b27d-9c182c85a892
add_1983@mail.ru
1234561983
=======================
49e8f4ea-30e4-4b4a-802a-41b0bc772016
add_1168@mail.ru
1234561168
=======================
14945a78-849b-40c6-892f-20ffd4b28c16
add_1742@mail.ru
1234561742
=======================
215811f9-e37b-4434-bdaa-aace66cc6c8d
add_1175@mail.ru
1234561175

     */
    Gson gson = new Gson();
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiaGFpZmFAZ21haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE2NzU4NjM3MTgsImlhdCI6MTY3NTI2MzcxOH0.3WAdkonLBt-dkb8N3EXSXHY-Y8D-SIgHJz8UMGplDjw";
    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");
    OkHttpClient client = new OkHttpClient();

    String id = "a7a2513a-a3c1-40c1-b27d-9c182c85a892";
    @Test
    public void deleteById() throws IOException {
        Request request = new Request.Builder()
            .url("https://contactapp-telran-backend.herokuapp.com/v1/contacts/" + id)
                .addHeader("Authorization", token)
            .delete()
            .build();

        Response response = client.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());
        ResponseMessageDto messageDto = gson.fromJson(response.body().string(),ResponseMessageDto.class);
        String message = messageDto.getMessage();
        System.out.println(message);



    }

}
