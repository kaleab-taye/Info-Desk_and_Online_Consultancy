package com.infodesk.InfoDesk_and_Online_Consultancy;



import static org.assertj.core.api.Assertions.assertThat;

import com.infodesk.InfoDesk_and_Online_Consultancy.user.User;
import com.infodesk.InfoDesk_and_Online_Consultancy.user.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

@Autowired
private TestEntityManager entityManager;

@Autowired
private UserRepository repo;

@Test
public void testCreateUser() {
    User user = new User();
    user.setEmail("alexx@gmail.com");
    user.setPassword("alexi2020");
    user.setFirstName("aleax");
    user.setLastName("hupa");
     
    User savedUser = repo.save(user);
     
    User existUser = entityManager.find(User.class, savedUser.getUserId());
     
    assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
     
}
    @Test
    public void testFindUserByEmail(){
        String email = "alexx@gmail.com";
        User user = repo.findByEmail(email);
        assertThat(user).isNotNull();
    }


}