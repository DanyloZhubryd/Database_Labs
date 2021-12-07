package ua.lviv.iot.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChildDTO {
    private Integer id;
    private String birthCertificate;
    private String name;
    private String surname;
    private String birthDate;
    private Integer childGroupId;
}
