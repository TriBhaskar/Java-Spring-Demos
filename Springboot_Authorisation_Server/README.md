```markdown
# Authorization Server

This project is an implementation of an OAuth2 Authorization Server using Spring Boot and Spring Security. It provides secure authentication and authorization for clients and users.

## Project Structure

- `src/main/java/org/triBhaskar/config/AuthorizationServerConfig.java`: Configuration for the authorization server.
- `src/main/resources/application.yml`: Application configuration file.
- `.gitignore`: Git ignore file for the project.

## Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher

## Getting Started

1. Clone the repository:
    ```sh
    git clone https://github.com/TriBhaskar/authorization-server.git
    cd authorization-server
    ```

2. Build the project:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

The server will start on port `9001` as configured in `application.yml`.

## Configuration

### Authorization Server Configuration

The authorization server is configured in `AuthorizationServerConfig.java`. It includes:

- Security filter chains for OAuth2 and general web security.
- In-memory user details service with a sample user.
- In-memory registered client repository with a sample client.
- JWT key pair generation for token signing.

### Application Configuration

The `application.yml` file contains the server port and logging levels.

## API Endpoints

### Authorization Endpoint

- **URL**: `/oauth2/authorize`
- **Method**: GET
- **Description**: Endpoint for obtaining authorization from the resource owner.

### Token Endpoint

- **URL**: `/oauth2/token`
- **Method**: POST
- **Description**: Endpoint for obtaining access tokens.

### JWK Set Endpoint

- **URL**: `/oauth2/jwks`
- **Method**: GET
- **Description**: Endpoint for retrieving the JSON Web Key Set (JWKS).

### User Info Endpoint

- **URL**: `/userinfo`
- **Method**: GET
- **Description**: Endpoint for retrieving user information.

## Example Client Configuration

A sample client configuration is provided in `AuthorizationServerConfig.java`:

- **Client ID**: `public-client-react`
- **Client Secret**: `secret`
- **Scopes**: `openid`, `profile`
- **Redirect URI**: `http://127.0.0.1:8083/login/oauth2/code/public-client-react`
- **Grant Types**: `authorization_code`, `refresh_token`, `client_credentials`

## Security

- User authentication is handled by an in-memory user details service.
- Passwords are stored in plain text for simplicity (not recommended for production).
- JWT tokens are signed using an RSA key pair.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## Contact

For any questions or issues, please contact [TriBhaskar](https://github.com/TriBhaskar).
```