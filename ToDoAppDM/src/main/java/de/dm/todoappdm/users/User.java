package de.dm.todoappdm.users;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDUSER")
    private Long idUser;

    @Column(name="USERNAME",nullable = false, unique = true)
    private String login;

    @Column(name="PASSWORD", nullable = false)
    private String password;

    @Column(name="IS_ADMIN", nullable = false)
    private Boolean IsAdmin;

    protected User() {
    }


    public User(String login, String password, boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.IsAdmin = isAdmin;
    }



    public Long getIdUser() { return idUser; }
    public void setIdUser(Long idUser) { this.idUser = idUser; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
