package es.futurespace.karmapp.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import es.futurespace.karmapp.domain.RegisterRequest;
import es.futurespace.karmapp.domain.User;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by user on 05/02/2016.
 */
public class UsersUtil {
    private final String USERS_FILE = "bd/users.json";


    /**
     * Extracts all users from USERS_FILE
     *
     * @return JsonArray with all users, ["error"] if exception, null if empty file
     */
    public ArrayList<User> getUsers() throws Exception {
        Gson gson = new Gson();
        InputStream data = getClass().getClassLoader().getResourceAsStream(USERS_FILE);
        BufferedReader br = new BufferedReader(new InputStreamReader(data, "utf-8"));

        Type listType = new TypeToken<ArrayList<User>>() {}.getType();
        //convert the json string to object
        ArrayList<User> users = gson.fromJson(br, listType);

        data.close();
        br.close();
        return users;
    }


    /**
     * Save a user in USERS_FILE.
     * @param mail
     * @param registerRequest
     * @return "ok" or "error"
     */
    public String saveUser(String mail, RegisterRequest registerRequest) {
        User user = new User(mail, registerRequest);
        ArrayList<User> usersList;
        Gson gson = new Gson();
        String usersListJson;
        try {
            usersList = getUsers();
            if (usersList == null) {
                usersList = new ArrayList<>();
            }
            usersList.add(user);
            usersListJson = gson.toJson(usersList);

            File file = new File(getClass().getClassLoader().getResource(USERS_FILE).toURI());
            FileWriter outfilewriter = new FileWriter(file);

            outfilewriter.write(usersListJson);
            outfilewriter.flush();
            outfilewriter.close();

            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     *
     * @param mail
     * @return
     * @throws Exception
     */
    public Boolean isRegistered (String mail) throws Exception {
        ArrayList<User> usersList = getUsers();
        if (usersList == null) {
            return false;
        } else {
            Iterator<User> usersListIterator = usersList.iterator();
            boolean found = false;
            while (usersListIterator.hasNext() && !found) {
                found = usersListIterator.next().getEmail().compareToIgnoreCase(mail) == 0;
            }
            return found;
        }
    }
}
