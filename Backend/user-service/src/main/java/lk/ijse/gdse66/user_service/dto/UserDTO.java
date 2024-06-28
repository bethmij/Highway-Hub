package lk.ijse.gdse66.user_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank(message = "user nic can not be null")
    private String userNIC;

    @NotBlank(message = "user name can not be null")
    @Pattern(regexp = "[A-Za-z ]+", message = "name is not valid")
    private String userName;

    private String address;

    @NotNull(message = "contact number can not be null")
    @Pattern(regexp = "\\d{10}", message = "Contact must be exactly 10 digits")
    private int contactNumber;

    private String email;

}
