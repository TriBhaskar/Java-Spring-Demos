package com.anterka.webservice;

import com.anterka.users.*;
import com.anterka.webservice.model.User;
import com.anterka.webservice.service.UserService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.Optional;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://www.anterka.com/users";

    private final UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        Optional<User> userOptional = userService.getUserById(request.getId());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            com.anterka.users.User userResponse = new com.anterka.users.User();
            userResponse.setId(user.getId());
            userResponse.setFirstName(user.getFirstName());
            userResponse.setLastName(user.getLastName());
            userResponse.setEmail(user.getEmail());
            userResponse.setPhone(user.getPhone());
            response.setUser(userResponse);
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUsersRequest")
    @ResponsePayload
    public GetAllUsersResponse getAllUsers(@RequestPayload GetAllUsersRequest request) {
        GetAllUsersResponse response = new GetAllUsersResponse();
        List<User> users = userService.getAllUsers();

        for (User user : users) {
            com.anterka.users.User userResponse = new com.anterka.users.User();
            userResponse.setId(user.getId());
            userResponse.setFirstName(user.getFirstName());
            userResponse.setLastName(user.getLastName());
            userResponse.setEmail(user.getEmail());
            userResponse.setPhone(user.getPhone());
            response.getUsers().add(userResponse);
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createUserRequest")
    @ResponsePayload
    public CreateUserResponse createUser(@RequestPayload CreateUserRequest request) {
        CreateUserResponse response = new CreateUserResponse();

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());

        User createdUser = userService.createUser(user);

        com.anterka.users.User userResponse = new com.anterka.users.User();
        userResponse.setId(createdUser.getId());
        userResponse.setFirstName(createdUser.getFirstName());
        userResponse.setLastName(createdUser.getLastName());
        userResponse.setEmail(createdUser.getEmail());
        userResponse.setPhone(createdUser.getPhone());

        response.setUser(userResponse);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    public UpdateUserResponse updateUser(@RequestPayload UpdateUserRequest request) {
        UpdateUserResponse response = new UpdateUserResponse();

        com.anterka.users.User requestUser = request.getUser();

        User user = new User();
        user.setId(requestUser.getId());
        user.setFirstName(requestUser.getFirstName());
        user.setLastName(requestUser.getLastName());
        user.setEmail(requestUser.getEmail());
        user.setPhone(requestUser.getPhone());

        User updatedUser = userService.updateUser(user);

        com.anterka.users.User userResponse = new com.anterka.users.User();
        userResponse.setId(updatedUser.getId());
        userResponse.setFirstName(updatedUser.getFirstName());
        userResponse.setLastName(updatedUser.getLastName());
        userResponse.setEmail(updatedUser.getEmail());
        userResponse.setPhone(updatedUser.getPhone());

        response.setUser(userResponse);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse deleteUser(@RequestPayload DeleteUserRequest request) {
        DeleteUserResponse response = new DeleteUserResponse();
        userService.deleteUser(request.getId());
        response.setStatus("Success");
        return response;
    }
}
