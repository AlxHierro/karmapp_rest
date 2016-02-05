package es.futurespace.karmapp.domain;

/**
 * Created by user on 05/02/2016.
 */
public class User {
    String email;
    RegisterRequest profile;

    public User(String email, RegisterRequest profile) {
        this.email = email;
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RegisterRequest getProfile() {
        return profile;
    }

    public void setProfile(RegisterRequest profile) {
        this.profile = profile;
    }
}
