package Bp2.Screens.Model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Code {

        //alle atributen uit JSON-file in private
        private String id;
        private String description;
        private String url;
        private String types;
        private JSONArray topicsArray;
        private String topics;
        private JSONArray levelsArray;
        private String levels;

        //aanspreken van de private strings/arrays
        public Code(JSONObject json) {
            this.id =  json.get("id").toString();
            this.description= json.get("description").toString();
            this.url = json.get("url").toString();
            this.types = json.get("types").toString();

            this.topicsArray = (JSONArray) json.get("topics");
            this.topics = json.get("topics").toString();

            this.levelsArray = (JSONArray) json.get("levels");
            this.levels = json.get("levels").toString();
        }

    //getters and setters om informatiewaarde te verdelen in andere classe
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    //strings maken van arrays
    public String getTopics() {
        StringBuilder topicString = new StringBuilder();
        for (Object topics : topicsArray) {
            topicString.append("  " + topics);
        }

        return String.valueOf(topicString);
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }


    //strings maken van arrays
    public String getLevels() {
            StringBuilder levelsString = new StringBuilder();
        for (Object level : levelsArray) {
            levelsString.append("\n" + level);
        }

        return String.valueOf(levelsString);
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }

    }


