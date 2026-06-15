import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeminiClient {
    private final HttpClient client;

    public GeminiClient() {
        client = HttpClient.newHttpClient();
    }

    public String askGemini(String prompt) throws IOException, InterruptedException {
        String jsonBody = """ 
            {
                "contents" : [
                    {
                        "parts" : [
                            {
                                "text" : "%s"
                            }
                        ]
                    }
                ]
            }
            """.formatted(prompt.replace("\"", "\\\""));
    

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(Config.API_URL))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();

        HttpResponse<String> response = client.send(
            request,
            HttpResponse.BodyHandlers.ofString()
        );

        return response.body();
    }
}