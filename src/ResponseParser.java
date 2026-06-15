import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ResponseParser { 
    public static String extractText(String json) {
        JsonObject root = com.google.gson.JsonParser
            .parseString(json)
            .getAsJsonObject();

        JsonArray candidates = root.getAsJsonArray("candidates");

        if(candidates == null || candidates.size() == 0) {
            return "No response received";
        }

        JsonObject candidate = candidates
            .get(0)
            .getAsJsonObject();

        JsonObject content = candidate
            .getAsJsonObject("content");

        JsonArray parts = content
            .getAsJsonArray("parts");

        return parts.get(0)
            .getAsJsonObject()
            .get("text")
            .getAsString();
    }
}