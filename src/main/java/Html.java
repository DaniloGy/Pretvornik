import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

public class Html {
    private String language;
    private Head head;
    private Map body;

    private Attributes bodyAttributes;

    String[] htmlTags;

    public Html(String language, Head head, Map body) {
        this.language = language;
        this.head = head;
        this.body = body;
    }

    @Override
    public String toString() {
        htmlTags = new String[]{"h1", "h2", "h3", "p"};
        String string = "<!DOCTYPE html>\n" +
                "<html";

        if(language != null){
            string += " lang=\"" + language + "\">\n";
        }else {
            string += ">\n";
        }

        string += head.toString();
        string += bodyToString(body);

        string += "</html>";
        return string;
    }

    private String bodyToString(Map map){
        String string = "\t<body";

        if (map.containsKey("attributes")){
            initAttributesObject((Map) map.get("attributes"));
            string += " " + bodyAttributes.toString() + ">\n";
            map.remove("attributes");
        }else{
            string += ">\n";
        }
        string += bodyTagsToString(map, 1);


        string += "\t</body>\n";
        return string;
    }

    private String bodyTagsToString(Map map, int numOfTab){
        String string = "";
        int newNumOfTab = numOfTab + 1;
        List listofKeys = new ArrayList(map.keySet());
        for (Object key: listofKeys) {
            if (isSimpleHtmlTag(key.toString())){
                for(int i = 0; i < newNumOfTab; i++){
                    string += "\t";
                }
                string += "<" + key + ">" + map.get(key) + "</" + key + ">\n";
            }else {
                string += customTagToString((Map) map.get(key), newNumOfTab, key.toString());
            }
        }
        return string;
    }

    private String customTagToString(Map customTag, int numOfTab, String tagName){
        String string = "";
        Map newCustomTag = customTag;

        for(int i = 0; i < numOfTab; i++){
            string += "\t";
        }
        if (customTag.containsKey("attributes")){
            Gson gson = new Gson();
            Type gsonType = new TypeToken<Map>(){}.getType();
            String gsonString = gson.toJson(customTag.get("attributes"),gsonType);
            Attributes att = new Gson().fromJson(gsonString, Attributes.class);
            newCustomTag.remove("attributes");

            string += "<" + tagName + " " + att.toString() + ">\n";
        }else {
            string += "<" + tagName + ">\n";
        }

        string += bodyTagsToString(newCustomTag, numOfTab);

        for(int i = 0; i < numOfTab; i++){
            string += "\t";
        }
        string += "</" + tagName + ">\n";

        return string;
    }

    private boolean isSimpleHtmlTag(String key) {
        for (int i = 0; i < htmlTags.length; i++) {
            if (Objects.equals(htmlTags[i], key)){
                return true;
            }
        }
        return false;
    }

    private void initAttributesObject(Map map){
        Gson gson = new Gson();
        Type gsonType = new TypeToken<Map>(){}.getType();
        String gsonString = gson.toJson(map,gsonType);

        this.bodyAttributes = new Gson().fromJson(gsonString, Attributes.class);
    }
}
