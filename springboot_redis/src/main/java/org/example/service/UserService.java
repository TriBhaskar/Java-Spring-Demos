package org.example.service;

import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    public static final String HASH_KEY = "User";
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public User save(User user){
        redisTemplate.opsForHash().put(HASH_KEY, user.getUserId(), user);
        return user;
    }
    public List<User> findAll(){
        // return all the values of the hash and convert them to a list of users
        return redisTemplate.opsForHash().values(HASH_KEY).stream().map(
                user -> (User) user
        ).collect(Collectors.toList());
    }
    public User findById(long id){
        return (User) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public String delete(long id){
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return "User removed !!";
    }

//    public User update(User user){
//        redisTemplate.opsForHash().put(HASH_KEY, user.getUserTd(), user);
//        return user;
//    }
}
