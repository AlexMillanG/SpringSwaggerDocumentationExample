package mx.edu.utez.unidadtres.security.jwt;

import mx.edu.utez.unidadtres.modules.user.BeanUser;
import mx.edu.utez.unidadtres.modules.user.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UDService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BeanUser found = userRepository.findByUsername(username).orElse(null);
        if (found== null) throw new UsernameNotFoundException("usuario no encontrado");

        //authority = ROLE_ADMIN,  ROLE_EMPLOYEE
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" +found.getRol().getName());


        return new User(
                found.getUsername(),
                found.getPassword(),
                Collections.singleton(authority)
        );
    }
}
