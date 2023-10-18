package com.book.check.config.auth;

import com.book.check.model.User;
import com.book.check.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public PrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
        User userEntity = userRepository.findByUsername(username);

        if(userEntity != null) {
            return new PrincipalDetails(userEntity);
        } else {
            throw new UsernameNotFoundException("아이디를 찾을 수 없습니다 : " + username);
        }
    }
}
