package org.example.expert.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
class PasswordEncoderTest {

    @InjectMocks
    private PasswordEncoder passwordEncoder;

    @Test
    void matches_메서드가_정상적으로_동작한다() {
        // given
        String rawPassword = "testPassword";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // when
        // passEncoder 클래스의 matches 메서드를 확인해보면 매개변수의 순서가 matches(rawPassword, encodedPassword) 이다
        // 이때 boolean matches는 참이 된다
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);

        // 만약 매개변수의 순서를 기존에 있는거로 하고싶다면 아래 검증식을 바꿔야한다
//        boolean matches = passwordEncoder.matches(encodedPassword, rawPassword);

        // then
        // assertTrue는 괄호안의 값이 참이면 테스트를 성공한다
        assertTrue(matches);

        // assertFalse는 괄호안의 식이 false이면 테스트를 성공한다
//        assertFalse(matches);
    }
}
