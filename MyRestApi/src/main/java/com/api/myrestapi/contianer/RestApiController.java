package com.api.myrestapi.contianer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/myrestapi")
    public String getPage(){
        return "Hello World";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
        return userRepository.findById(id).get();
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User user){
        userRepository.save(user);
        return "Saved...";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user){
        User updateUser = userRepository.findById(id).get();
        updateUser.setUsername(user.getUsername());
        updateUser.setEmail(user.getEmail());
        updateUser.getOccupation();
        updateUser.setAge(user.getAge());
        userRepository.save(updateUser);
        return "Updated...";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        User deleteUser = userRepository.findById(id).get();
        userRepository.delete(deleteUser);
        return "Delete user with the id "+id+" deleted...";
    }

}
