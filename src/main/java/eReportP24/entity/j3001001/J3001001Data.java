package eReportP24.entity.j3001001;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import eReportP24.entity.settingsData.SettingsData;
import lombok.Getter;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
@Getter
public class J3001001Data{

	@JsonProperty("j3001001Data")
	private List<J3001001DataItem> j3001001Data;

	@JsonIgnore
	public J3001001Data getJ3001001DataFromFile() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			J3001001Data j3001001Data = mapper.readValue(new File("src/main/resources/jsonData/j3001001Data.json"), J3001001Data.class);
			return j3001001Data;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@JsonIgnore
	public static J3001001DataItem getJ3001001DataItem() {
		return new J3001001Data().getJ3001001DataFromFile().getJ3001001Data().get(0);
	}
}