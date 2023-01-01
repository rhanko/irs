package program.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import program.model.User;
import program.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servis trieda pre prácu s užívateľom
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Funkcia pre prihlásenie sa do systému cez web
     * @param usernameOrEmail meno alebo e-mail užívateľa
     * @return vráti detaily užívateľa (meno, heslo, role)
     * @throws UsernameNotFoundException vyhodí chybu o zlom mene/ e-maily
     */
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User userByMail = userRepository.findUserByMail(usernameOrEmail);
        if(userByMail != null){
            return returnUser(userByMail);
        }

        User userByUsername = userRepository.findUserByUsername(usernameOrEmail);
        if(userByUsername != null) {
            return returnUser(userByUsername);
        }

        else {
            throw new UsernameNotFoundException("Zlé meno alebo email");
        }
    }

    /**
     * Pomocná funkcia pre prihlásenie sa
     * @param user
     * @return
     */
    private UserDetails returnUser(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRole().stream().map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void saveUserEdited(User user) {
        User editedUser = userRepository.findUserById(user.getId());

        editedUser.setMail(user.getMail());
        editedUser.setFirstname(user.getFirstname());
        editedUser.setSurname(user.getSurname());

        //ak sa heslá zhodujú tak heslo sa needitovalo
        if (user.getPassword() != null) {
            if (!(user.getPassword().equals(editedUser.getPassword()))) {
                if (!(passwordEncoder.matches(user.getPassword(), editedUser.getPassword()))) {
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                }
            }
        }

        userRepository.save(editedUser);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserByNickname(String nickname) {
        return  userRepository.findUserByUsername(nickname);
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByMail(email);
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public boolean existUserByUsername(String username) {
        return userRepository.existsUserByUsername(username);
    }

}