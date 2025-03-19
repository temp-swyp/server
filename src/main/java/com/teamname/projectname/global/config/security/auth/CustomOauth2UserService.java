package com.teamname.projectname.global.config.security.auth;

import com.teamname.projectname.domain.user.entity.User;
import com.teamname.projectname.domain.user.repository.UserRepository;
import com.teamname.projectname.global.config.security.auth.dto.CustomOauth2User;
import com.teamname.projectname.global.config.security.auth.dto.OAuthAttributes;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomOauth2UserService extends DefaultOAuth2UserService{

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        //현재 로그인 진행 중인 서비스를 구분
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        //로그인 진행 시 키가 되는 필드값
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
            .getUserInfoEndpoint().getUserNameAttributeName();

        /***
         * OAuth2UserRequest 에서 가져온 oAuth2User 의 attribute 를 담을 클래스
         */
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName,
            oAuth2User.getAttributes());

        User user = saveOrUpdate(registrationId, attributes);

        return new CustomOauth2User(
            Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
            attributes.getAttributes(),
            attributes.getNameAttributeKey(),
            user.getId());
    }

    private User saveOrUpdate(String registrationId, OAuthAttributes attributes) {

        String userId = generateUserId(registrationId, attributes);

        User user = userRepository.findById(userId)
            .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
            .orElse(attributes.toEntity(userId));//없으면 엔티티생성

        return userRepository.save(user);
    }

    private String generateUserId(String registrationId, OAuthAttributes attributes) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(registrationId)
            .append("_")
            .append(attributes.getAttributes().get(attributes.getNameAttributeKey()))
            .toString();
    }
}
