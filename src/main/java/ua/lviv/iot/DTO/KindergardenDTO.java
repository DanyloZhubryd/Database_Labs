package ua.lviv.iot.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KindergardenDTO {
    private Integer id;
    private Integer flatsCount;
    private Integer workersCount;
    private Integer groupCount;
    private Integer addressId;
}
