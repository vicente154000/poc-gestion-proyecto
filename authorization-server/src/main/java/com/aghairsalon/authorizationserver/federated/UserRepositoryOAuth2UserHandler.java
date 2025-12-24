package com.aghairsalon.authorizationserver.federated;

import com.aghairsalon.authorizationserver.entity.GoogleUser;
import com.aghairsalon.authorizationserver.repository.GoogleUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.function.Consumer;

@RequiredArgsConstructor
@Slf4j
public final class UserRepositoryOAuth2UserHandler implements Consumer<OAuth2User> {

    private final GoogleUserRepository googleUserRepository;

    @Override
    public void accept(OAuth2User user) {
        if (!this.googleUserRepository.findByEmail(user.getName()).isPresent()) {
            GoogleUser googleUser = GoogleUser.fromOauth2User(user);
            log.info(googleUser.toString());
            this.googleUserRepository.save(googleUser);
        } else {
            log.info("Bienvenido {}", user.getAttributes().get("given_name"));
        }
    }
}