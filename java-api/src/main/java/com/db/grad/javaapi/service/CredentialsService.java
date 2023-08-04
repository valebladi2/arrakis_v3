package com.db.grad.javaapi.service;

import com.db.grad.javaapi.details.MyCredentialsDetails;
import com.db.grad.javaapi.model.Credentials;
import com.db.grad.javaapi.repository.CredentialsRepository;
import com.db.grad.javaapi.repository.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CredentialsService implements UserDetailsService {

    private CredentialsRepository credentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Credentials credentials = credentialsRepository.getCredentialsByEmail(email);
        if(credentials == null)
        {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyCredentialsDetails(credentials);
    }
}
