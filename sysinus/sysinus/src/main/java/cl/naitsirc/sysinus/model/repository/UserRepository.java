package cl.naitsirc.sysinus.model.repository;

import cl.naitsirc.sysinus.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
