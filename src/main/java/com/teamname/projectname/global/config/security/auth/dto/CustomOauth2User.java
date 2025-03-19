package com.teamname.projectname.global.config.security.auth.dto;

import java.util.Collection;
import java.util.Map;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

@Getter
public class CustomOauth2User extends DefaultOAuth2User {

    private final String userId;

    public CustomOauth2User(Collection<? extends GrantedAuthority> authorities,
        Map<String, Object> attributes, String nameAttributeKey, String userId) {
        super(authorities, attributes, nameAttributeKey);
        this.userId = userId;
    }
}
