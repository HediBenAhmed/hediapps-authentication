package com.hediapps.authentication.service;

import com.hediapps.authentication.dto.UserDto;
import com.hediapps.authentication.mapper.UserMapper;
import com.hediapps.authentication.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {
    private final CredentialRepository credentialRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = credentialRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return UserMapper.INSTANCE.userEntityToUserDto(user);
    }

    public void save(UserDto user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity userEntity = UserMapper.INSTANCE.userDtoToUserEntity(user);

        credentialRepository.save(userEntity);
    }
}
