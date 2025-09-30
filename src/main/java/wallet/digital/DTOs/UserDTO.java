package wallet.digital.DTOs;

import java.time.LocalDateTime;

public class UserDTO {

    private Long id;

    private String username;

    private String password;

    private String name;

    private String lastname;

    public  UserDTO(){}

    public UserDTO(Long id, String username, String password, Boolean enabled, String name, String lastname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
