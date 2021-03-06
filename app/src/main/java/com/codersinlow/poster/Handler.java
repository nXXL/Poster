package com.codersinlow.poster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Handler {
    public static final String token = "0024613c1444f731bb96dd97f025d41a";
    public static final String format = "json";
    public static final String link = "https://oleg-fomenko.joinposter.com";

    public static String sendRequest(String request, String requestType, String... parms) {
        String ss = link + "/api/" + request + "?token=" + token + "&format=" + format;
        for(String p : parms) ss += "&" + p;

        try {
            URL url = new URL(ss);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(requestType);
            BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String content = "", line = "";
            while((line = bf.readLine()) != null) {
                content += line;
            }

            return content;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "error";
    }
}

