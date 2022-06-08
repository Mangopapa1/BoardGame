package BoardGame.BackEnd.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

@RestController
@RequiredArgsConstructor
public class BgaApiController {

    //private final RestTemplate restTemplate;



    @RequestMapping("/bga/list")
    public String testApi(){

        try {
            URL url = new URL("https://api.boardgameatlas.com/api/search?name=Catan&client_id=JLBr5npPhV");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); //서버연결
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(true);
            String param = "name=name&";


            int result = httpURLConnection.getResponseCode();

            InputStream inputStream;
            if(result == 200){
                inputStream = httpURLConnection.getInputStream();
            }else {
                inputStream = httpURLConnection.getErrorStream();
            }

            InputStreamReader reader = new InputStreamReader(inputStream); //데이터 읽기
            BufferedReader bufferedReader = new BufferedReader(reader); //형변환
            return bufferedReader.readLine();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/redirect";
    }






}
