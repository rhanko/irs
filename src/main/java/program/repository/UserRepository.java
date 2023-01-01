package program.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import program.model.User;

/**
 * Interface pre manipuláciu s údajmi v tabuľke "User"
 * napr. pridanie, odstránenie, načítanie užívateľa
 */
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * Funkcia pre nájdenie užívateľa podľa mena
     * @param nickname meno užívateľa
     * @return vráti užívateľa alebo null
     */
    User findUserByUsername(String nickname);

    /**
     * Funkcia pre nájdenie užívateľa podľa mena
     * @param mail e-mail užívateľa
     * @return vráti užívateľa alebo null
     */
    User findUserByMail(String mail);

    User findUserById(int id);

    boolean existsUserByUsername(String username);
}
