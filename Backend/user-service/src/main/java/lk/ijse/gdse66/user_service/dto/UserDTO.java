package lk.ijse.gdse66.user_service.dto;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private String userNIC;

    private String userName;

    private String address;

    private int contactNumber;

    private String email;

}
