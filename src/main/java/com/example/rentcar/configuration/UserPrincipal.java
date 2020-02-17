package com.example.rentcar.configuration;

import com.example.rentcar.Entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private UserEntity userEntity;

    public UserPrincipal(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        //extract list of permissions
      this.userEntity.getPermissionList().forEach(p-> {
                GrantedAuthority auth = new SimpleGrantedAuthority(p);
                authorities.add(auth);
    });

        this.userEntity.getRoleList().forEach(r-> {
            GrantedAuthority auth = new SimpleGrantedAuthority("ROLE_"+r);
            authorities.add(auth);
        });

      return authorities;}

    @Override
    public String getPassword() {
        return this.userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userEntity.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.userEntity.getActived()==1;
    }
}
