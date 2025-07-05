package mx.edu.utez.unidadtres.modules.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<BeanUser,Long> {
    Optional<BeanUser> findByUsernameAndPassword(String u,String p);
    Optional<BeanUser> findByUsername(String s);
}
