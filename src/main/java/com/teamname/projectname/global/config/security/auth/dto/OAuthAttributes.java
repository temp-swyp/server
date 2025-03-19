package com.teamname.projectname.global.config.security.auth.dto;

import com.teamname.projectname.domain.user.entity.Role;
import com.teamname.projectname.domain.user.entity.User;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes {
    private static final String KAKAO = "kakao";
    private static final String GOOGLE = "google";
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name,
        String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName,
        Map<String, Object> attributes) {
        if(KAKAO.equals(registrationId)){
            return ofKakao(userNameAttributeName, attributes);
        }
        //ofGoogle, ofKakao
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
            .name(attributes.get("name").toString())
            .email(attributes.get("email").toString())
            .picture(attributes.get("picture").toString())
            .attributes(attributes)
            .nameAttributeKey(userNameAttributeName)
            .build();
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");

        return OAuthAttributes.builder()
            .name(profile.get("nickname").toString())
            .email(kakaoAccount.get("email").toString())
            .picture(profile.get("profile_image_url").toString())
            .attributes(attributes)
            .nameAttributeKey(userNameAttributeName)
            .build();
    }

    //User 엔티티 생성
    public User toEntity(String userId) {
        return User.builder()
            .id(userId)
            .name(name)
            .email(email)
            .picture(picture)
            .role(Role.GUEST)
            .build();
    }
}
