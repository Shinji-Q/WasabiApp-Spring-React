package com.wassabi.wassabiapp.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.wassabi.wassabiapp.model.Usuario;

public class CustomUserDetails implements UserDetails{

    // private Usuario usuario;

    private String usuarioEmail;
	private String usuarioSenha;
	private List<GrantedAuthority> authorities;    
    private String username;

    public CustomUserDetails(Usuario usuario){
        // super();
        // this.usuario = usuario;
        this.usuarioEmail = usuario.getUsuarioEmail();
        this.usuarioSenha = usuario.getUsuarioSenha();
        this.authorities = Arrays.stream(usuario.getUsuarioTipo().split(","))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    
    @Override
    public String getPassword() {
        return usuarioSenha;
    }

    @Override
    public String getUsername() {
        return usuarioEmail;
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
        return true;
    }

    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     return Arrays.asList(new SimpleGrantedAuthority(usuario.getUsuarioTipo()));
    // }

    // @Override
    // public String getPassword() {
    //     return usuario.getUsuarioSenha();
    // }

    // @Override
    // public String getUsername() {
    //     return usuario.getUsuarioEmail();
    // }

    // @Override
    // public boolean isAccountNonExpired() {
    //     return true;
    // }

    // @Override
    // public boolean isAccountNonLocked() {
    //     return true;
    // }

    // @Override
    // public boolean isCredentialsNonExpired() {
    //     return true;
    // }

    // @Override
    // public boolean isEnabled() {
    //     return true;
    // }
    
}
