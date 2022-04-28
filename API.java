import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {



    public static void main(String[] args) throws IOException,InterruptedException{
        String[] arr={"dengue","malaria","Covid-19", "HidocDr"};
        for(String a :arr) {
            var url = "https://newsapi.org/v2/everything?q="+a+"&from=2022-03-23&sortBy=publishedAt&apiKey=f4f85ccd28d6420b9e2bc221ffbb2e57";
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

            var client = HttpClient.newBuilder().build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            System.out.println(response.body());
        }


    }
}
