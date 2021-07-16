package testProjectAliParser.parser.ali;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import testProjectAliParser.parser.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class AliParser implements Parser {

    @Override
    public JsonNode parse() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL("https://gpsfront.aliexpress.com/getRecommendingResults.do?widget_id=5547572&limit=40").openConnection();
        InputStream inputStream = connection.getInputStream();
        String collect = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readValue(collect, JsonNode.class);

        if (!jsonNode.has("results") || !jsonNode.get("results").isArray()) {
            return null;
        }

        return jsonNode.get("results");
    }
}
