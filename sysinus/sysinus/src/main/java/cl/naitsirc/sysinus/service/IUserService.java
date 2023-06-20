package cl.naitsirc.sysinus.service;

import cl.naitsirc.sysinus.model.dto.UserDTO;
import cl.naitsirc.sysinus.model.entity.User;

import java.util.List;

public interface IUserService {

    List<UserDTO> getUsers();

    UserDTO getUser(int id);

    UserDTO saveUser(UserDTO udto);

    User deleteUser(int id);

    User updateUser(User user);
}
