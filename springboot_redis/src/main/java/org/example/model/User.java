package org.example.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@RedisHash("User")
public class User implements Serializable {

    @Id
    private long userId;
    private String name;
    private String phone;
    private String email;
}
