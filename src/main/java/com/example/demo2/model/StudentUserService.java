package com.example.demo2.model;

import com.example.demo2.service.StuUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class StudentUserService implements UserDetailsService {
    @Autowired
    StuUserService studentUserService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StudentUser studentUser = studentUserService.getStudentUserByUserName(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return new StudentUserDetail(studentUser);
    }
}
