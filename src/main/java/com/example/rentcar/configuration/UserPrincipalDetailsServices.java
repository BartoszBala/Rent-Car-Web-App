package com.example.rentcar.configuration;

import com.example.rentcar.Entity.UserEntity;
import com.example.rentcar.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsServices implements UserDetailsService {

    private UserRepository userRepository;


    public UserPrincipalDetailsServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRepository.findByLogin(s);


        if(userEntity==null){
            throw new UsernameNotFoundException("No user found for "+s+".");
        }
        UserPrincipal userPrincipal = new UserPrincipal(userEntity);

        return userPrincipal;
    }


}
