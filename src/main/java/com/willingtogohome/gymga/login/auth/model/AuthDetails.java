//package com.willingtogohome.gymga.login.auth.model;
//
//import com.willingtogohome.gymga.login.user.model.dto.LoginDTO;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//public class AuthDetails implements UserDetails {
//
//    private LoginDTO loginDTO;
//
//    public AuthDetails(){}
//
//    public AuthDetails(LoginDTO loginDTO) {
//        this.loginDTO = loginDTO;
//    }
//
//    public LoginDTO getLoginDTO() {
//        return loginDTO;
//    }
//
//    public void setLoginDTO(LoginDTO loginDTO) {
//        this.loginDTO = loginDTO;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        loginDTO.getRole().forEach(role ->authorities.add(() -> role));
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return loginDTO.getUserPwd();
//    }
//
//    @Override
//    public String getUsername() {
//        return loginDTO.getUserId();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
