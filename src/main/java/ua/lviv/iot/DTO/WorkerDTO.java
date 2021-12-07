package ua.lviv.iot.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkerDTO {
    private Integer id;
    private String passport;
    private String name;
    private String surname;
    private String hireDate;
    private String fireDate;
    private Integer kindergardenId;
    private Integer positionId;
}
