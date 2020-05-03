package com.xcl.community.provider;

import com.alibaba.fastjson.JSON;
import com.xcl.community.dto.AccessTokenDTO;
import com.xcl.community.dto.GithupUser;
import okhttp3.*;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * GithubProvider
 *
 * @author 徐长乐
 * @date 2020/5/1
 */
@Component
public class GithubProvider {
    public static final MediaType MEDIA_TYPE
            = MediaType.get("application/json; charset=utf-8");

    public String getAccessToken(AccessTokenDTO accessTokenDTO){
            OkHttpClient client = new OkHttpClient();
        String json = JSON.toJSONString(accessTokenDTO);
        RequestBody body = RequestBody.create(MEDIA_TYPE, json);
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string = response.body().string();
                String token = string.split("&")[0].split("=")[1];
               return token;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }
    public GithupUser getGithubUser(String accessToken){
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token="+accessToken)
                    .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            String user =  response.body().string();
            GithupUser githupUser = JSON.parseObject(user, GithupUser.class);
            return githupUser;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
