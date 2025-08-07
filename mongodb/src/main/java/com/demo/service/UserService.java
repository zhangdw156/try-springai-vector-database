package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.repository.UserRepository;
import com.demo.entity.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // 保存用户
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // 查询所有用户
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 根据名称查询用户
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    // 删除用户
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
