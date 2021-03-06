package eReportP24.entity.j3001001;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonsItem{

	@JsonProperty("startDateWork")
	private String startDateWork;

	@JsonProperty("orderNumber")
	private String orderNumber;

	@JsonProperty("registrationNumber")
	private String registrationNumber;

	@JsonProperty("category")
	private String category;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("secondName")
	private String secondName;

	@JsonProperty("thirdName")
	private String thirdName;

	@JsonProperty("publicationOrderDate")
	private String publicationOrderDate;
}