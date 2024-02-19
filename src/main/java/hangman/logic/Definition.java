package hangman.logic;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;


public class Definition {
    
    public static URI urlBuilder(String keyword) {
        String baseURL = "https://api.dictionaryapi.dev/api/v2/entries/en/";
        String fullURL = baseURL + keyword;
        URI returnURL = URI.create(fullURL);
        return returnURL;
    }
    
    public static String fetchData(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
            return result.toString();
        }
    }
    
    public static void getDefinition(String keyword) {
        
        try {
            String jsonData = fetchData(urlBuilder(keyword).toString());
            
            // Parse the JSON array
            JSONArray jsonArray = new JSONArray(jsonData);
            
            // Extract the first element (assuming there is only one word in the response)
            JSONObject wordObject = jsonArray.getJSONObject(0);
            
            // Extract meanings array
            JSONArray meaningsArray = wordObject.getJSONArray("meanings");
            
            // Iterate through meanings and print definitions
            for (int i = 0; i < meaningsArray.length(); i++) {
                JSONObject meaningObject = meaningsArray.getJSONObject(i);
                String partOfSpeech = meaningObject.getString("partOfSpeech");
                
                // Extract definitions array
                JSONArray definitionsArray = meaningObject.getJSONArray("definitions");
                
                // Print part of speech
                //System.out.println("Part of Speech: " + partOfSpeech);
                
                // Iterate through definitions and print them
                for (int j = 0; j < definitionsArray.length(); j++) {
                    JSONObject definitionObject = definitionsArray.getJSONObject(j);
                    String definition = definitionObject.getString("definition");
                    
                    // Print definition
                    System.out.println("Definition: " + definition);
                }
                
                //System.out.println(); // Add a line break between part of speech definitions
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
