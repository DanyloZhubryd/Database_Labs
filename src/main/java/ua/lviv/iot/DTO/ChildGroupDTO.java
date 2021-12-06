package ua.lviv.iot.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChildGroupDTO {
    private Integer id;
    private String name;
    private Integer bedroomNumber;
    private Integer kindergardenId;
    private Integer workerId;
}
