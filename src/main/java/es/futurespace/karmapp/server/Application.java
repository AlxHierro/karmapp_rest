package es.futurespace.karmapp.server;

import com.google.gson.Gson;
import es.futurespace.karmapp.domain.RegisterRequest;
import es.futurespace.karmapp.domain.User;
import es.futurespace.karmapp.util.UsersUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
//        UsersUtil usersUtil = new UsersUtil();
//        ArrayList<User> users = usersUtil.getUsers();
//        usersUtil.saveUser("caca",new RegisterRequest(true,true,false,false));
//        System.out.println(users);
//usersUtil.isRegistered("caca");
//        Gson gson = new Gson();
//        gson.toJson(new RegisterRequest(true,false,true,false),RegisterRequest.class);

//        System.out.println(usersUtil.isRegistered("caca"));

        SpringApplication.run(Application.class, args);
    }
}
