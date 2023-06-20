package cl.naitsirc.sysinus.service.impl;

import cl.naitsirc.sysinus.model.dto.UserDTO;
import cl.naitsirc.sysinus.model.entity.User;
import cl.naitsirc.sysinus.model.repository.UserRepository;
import cl.naitsirc.sysinus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDto = new ArrayList<>();

        for (User user:users){
            usersDto.add(UserDTO.mapToDto(user));
        }

        return usersDto;
    }

    @Override
    public UserDTO getUser(int id) {
        User user = userRepository.findById(id).orElse(null);


        return new UserDTO(user.getName(),user.getEmail(),user.getPassword(),user.getCreated(),
                    user.getModified(),user.isActive(),user.getTelephone());

    }

    @Override
    public UserDTO saveUser(UserDTO udto) {
        User userEntity = UserDTO.mapToEntity((udto));
        userRepository.save(userEntity);

        return udto;
    }

    @Override
    public User deleteUser(int id) {


        return null;
    }

    @Override
    public User updateUser(User userReq) {

        return null;
    }
}
