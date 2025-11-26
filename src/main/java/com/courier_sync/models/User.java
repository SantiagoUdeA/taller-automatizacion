package com.courier_sync.models;

import com.courier_sync.utils.ConfigurationReader;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {

    private String email;
    private String password;

    /**
     * Crea un usuario con las credenciales cargadas desde las variables de entorno
     * definidas en serenity.conf
     * @return Usuario con credenciales desde configuración
     */
    public static User valid() {
        return new User(
                ConfigurationReader.getUserEmail(),
                ConfigurationReader.getUserPassword()
        );
    }

    public static User invalid() {
        return new User("invalid@gmail.com","invalid");
    }
}
