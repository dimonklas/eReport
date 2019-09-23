package eReportP24.entity.settingsData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
@Getter
public class SettingsDataItem{

	@JsonProperty("dfsBody")
	private String dfsBody;

	@JsonProperty("vatPayer")
	private String vatPayer;

	@JsonProperty("inn")
	private String inn;

	@JsonProperty("accountant")
	private String accountant;

	@JsonProperty("director")
	private String director;

	@JsonProperty("pensionFundCode")
	private String pensionFundCode;

	@JsonProperty("registrationNumberPension")
	private String registrationNumberPension;

	@JsonProperty("fiscalService")
	private String fiscalService;

	@JsonProperty("factAddress")
	private FactAddress factAddress;

	@JsonProperty("telephone")
	private String telephone;

	@JsonProperty("legalForm")
	private String legalForm;

	@JsonProperty("mainNACE")
	private String mainNACE;

	@JsonProperty("koatuu")
	private String koatuu;

	@JsonProperty("businessAddress")
	private BusinessAddress businessAddress;

	@JsonProperty("email")
	private String email;
}