/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package falconserver;

import java.io.Serializable;

/**
 *
 * @author
 */
public class User implements Serializable {
    public String username;
    public String password;
    public String email;

    User (String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
