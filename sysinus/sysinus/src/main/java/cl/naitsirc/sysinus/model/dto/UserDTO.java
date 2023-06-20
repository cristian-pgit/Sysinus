package cl.naitsirc.sysinus.model.dto;

import cl.naitsirc.sysinus.model.entity.Telephone;
import cl.naitsirc.sysinus.model.entity.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    @NotEmpty(message = "El Nombre es Requerido")
    private String name;

    @NotEmpty(message = "El email es Requerido")
    private String email;

    @NotEmpty(message = "Debe ingresar un password")
    private String password;



    private LocalDateTime created;


    private LocalDateTime modified;


    private boolean isActive = true;

    @Valid
    private List<Telephone> telephone;

    public static UserDTO mapToDto(User entity){
        UserDTO dto = new UserDTO();
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setCreated(entity.getCreated());
        dto.setModified(entity.getModified());
        dto.setActive(entity.isActive());
        dto.setTelephone(entity.getTelephone());

        return dto;
    }

    public static User mapToEntity(UserDTO dto){
        User userEntity = new User();
        userEntity.setName(dto.getName());
        userEntity.setEmail(dto.getEmail());
        userEntity.setPassword(dto.getPassword());
        userEntity.setCreated(dto.getCreated());
        userEntity.setModified(dto.getModified());
        userEntity.setActive(dto.isActive);
        userEntity.setTelephone(dto.getTelephone());

        return userEntity;
    }

}
