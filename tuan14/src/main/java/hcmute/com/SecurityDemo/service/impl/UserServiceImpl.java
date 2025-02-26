package hcmute.com.SecurityDemo.service.impl;

import hcmute.com.SecurityDemo.entity.Users;
import hcmute.com.SecurityDemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

        @Autowired
        UserRepository userRepository;
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Users user = userRepository.getUserByUsername(username);
                if (user == null){
                        throw new UsernameNotFoundException("Could not find user");
                }

                return new MyUserService(user);
        }
}
