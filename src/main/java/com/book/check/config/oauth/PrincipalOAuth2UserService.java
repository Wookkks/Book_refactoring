package com.book.check.config.oauth;

import java.util.Optional;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.book.check.config.auth.PrincipalDetails;
import com.book.check.model.RoleType;
import com.book.check.model.User;
import com.book.check.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService{
	
	private final UserRepository userRepository;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
		OAuth2User oAuth2User = super.loadUser(userRequest);
		
		return processOAuth2User(userRequest, oAuth2User); 
	}
	
	private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
		OAuth2UserInfo oAuth2UserInfo = null;
		
		if(userRequest.getClientRegistration().getRegistrationId().equals("google")) {
			System.out.println("구글 로그인 요청");
			oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
		}
		
		Optional<User> userOptional = userRepository.findByProviderAndProviderId(oAuth2UserInfo.getProvider(), oAuth2UserInfo.getProviderId());
		
		User user;
		
		if (userOptional.isPresent()) {
			user = userOptional.get();
			user.setEmail(oAuth2UserInfo.getEmail());
			userRepository.save(user);
		} else {
			user = User.builder()
					.username(oAuth2UserInfo.getProvider() + "_" + oAuth2UserInfo.getProviderId())
					.name(oAuth2UserInfo.getName())
					.email(oAuth2UserInfo.getEmail())
					.password("seo")
					.role(RoleType.ROLE_USER)
					.provider(oAuth2UserInfo.getProvider())
					.providerId(oAuth2UserInfo.getProviderId())
					.build();
			
			userRepository.save(user);
		}
		
		return new PrincipalDetails(user, oAuth2User.getAttributes());
		
	}

}
