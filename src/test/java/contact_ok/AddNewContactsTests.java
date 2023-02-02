package contact_ok;

import com.google.gson.Gson;
import dto.*;
import okhttp3.*;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.io.IOException;


public class AddNewContactsTests {


        String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiYWJjQGRlZi5jb20iLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTY3NTc4NzcxOSwiaWF0IjoxNjc1MTg3NzE5fQ.kNxBwJ6gEX2VJzh9F9kxTiiseXz9ZyU54s58oTbzM-w";
        public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");

        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();

        ContactDto AddNewContact = ContactDto.builder()
                .name("New")
                .lastName("Contact")
                .email("add@mail.com")
                .phone("45678901706")
                .address("Haifa")
                .description("Add new Contact_1")
                .build();

        @Test
        public void AddNewContact() throws IOException {
            RequestBody requestBodyNewContact = RequestBody.create(gson.toJson(AddNewContact), JSON);

            Request requestNewContact = new Request.Builder()
                    .url("https://contactapp-telran-backend.herokuapp.com/v1/contacts")
                    .addHeader("Authorization", token)
                    .post(requestBodyNewContact)
                    .build();

            Response responseAddContact = client.newCall(requestNewContact).execute();
            Assert.assertTrue(responseAddContact.isSuccessful());
            ResponseMessageDto messageDto = gson.fromJson(responseAddContact.body().string(), ResponseMessageDto.class);
            String message = messageDto.getMessage();
            System.out.println(message);
        }
    }
