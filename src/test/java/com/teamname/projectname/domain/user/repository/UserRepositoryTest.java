package com.teamname.projectname.domain.user.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.teamname.projectname.domain.user.entity.Role;
import com.teamname.projectname.domain.user.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @DisplayName("User 저장 테스트")
    @Test
    void saveUserTest() {
        User createUser = new User("pk","sean", "tmdgus717@naver.com", "abc.png", Role.USER);
        User savedUser = userRepository.save(createUser);

        assertThat(savedUser.getName()).isEqualTo(createUser.getName());
    }

}
