package eReportP24.entity.j3001001;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class J3001001DataItem {

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

    @JsonProperty("codeERDPOU")
    private String codeERDPOU;

    @JsonProperty("bossPassport")
    private String bossPassport;

    @JsonIgnore
    public static J3001001DataItem getDefaultData() {
        return new J3001001DataItemBuilder()
                .numberOfList("")
                .codeERDPOU("31435622")
                .companyName("Комунальне підприємство \"TEST TEST MCB_0309\"")
                .type("початкове")
                .persons(new ArrayList<>(Collections.singleton(new PersonsItem()
                        .builder()
                        .category("")
                        .registrationNumber("")
                        .firstName("")
                        .secondName("")
                        .thirdName("")
                        .orderNumber("")
                        .publicationOrderDate("")
                        .startDateWork("")
                        .build())))
                .formationDate(new SimpleDateFormat("dd.MM.yyyy").format(new Date()))
                .rowsCount("1")
                .bossPassport("2924203694")
                .boss("Давиденко Вячеслав Олександрович")
                .accountantPassport("3170104738")
                .accountant("Унченко Антон Павлович")
                .build();
    }
}