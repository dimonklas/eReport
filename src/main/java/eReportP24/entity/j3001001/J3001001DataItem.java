package eReportP24.entity.j3001001;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
@Getter
public class J3001001DataItem{

	@JsonProperty("numberOfList")
	private String numberOfList;

	@JsonProperty("boss")
	private String boss;

	@JsonProperty("accountant")
	private String accountant;

	@JsonProperty("companyName")
	private String companyName;

	@JsonProperty("accountantPassport")
	private String accountantPassport;

	@JsonProperty("formationDate")
	private String formationDate;

	@JsonProperty("declarationCode")
	private String declarationCode;

	@JsonProperty("type")
	private String type;

	@JsonProperty("persons")
	private List<PersonsItem> persons;

	@JsonProperty("declarationName")
	private String declarationName;

	@JsonProperty("rowsCount")
	private String rowsCount;

	@JsonProperty("numberPassportSeria")
	private String numberPassportSeria;

	@JsonProperty("bossPassport")
	private String bossPassport;
}