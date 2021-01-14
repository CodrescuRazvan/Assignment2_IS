package Gr30234.HelloSpring.auth;

import Gr30234.HelloSpring.data.UserJpaRepository;
import Gr30234.HelloSpring.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipleDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private UserJpaRepository userRepository;

    public UserPrincipleDetailsService(UserJpaRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        UserPrinciple userPrinciple = new UserPrinciple(user);

        return userPrinciple;
    }
}
