package eReportP24.entity.settingsData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
@Getter
public class BusinessAddress{

	@JsonProperty("address")
	private String address;

	@JsonProperty("officeOrFlat")
	private String officeOrFlat;
}