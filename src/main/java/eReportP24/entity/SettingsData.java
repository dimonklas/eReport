package eReportP24.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import javax.annotation.Generated;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
@Data
public class SettingsData {

    @JsonProperty("settingsData")
    private List<SettingsDataItem> settingsData;


    @JsonIgnore
    public SettingsData getSettingsDataFromFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            SettingsData settingsData = mapper.readValue(new File("src/main/resources/settingsData.json"), SettingsData.class);
            return settingsData;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}