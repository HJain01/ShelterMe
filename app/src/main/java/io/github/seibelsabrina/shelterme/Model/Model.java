package io.github.seibelsabrina.shelterme.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tanya on 2/22/18.
 */

public class Model {
    /** Singleton instance */
    private static final Model _instance = new Model();
    public static Model getInstance() { return _instance; }
    private Map<String, User> users = new HashMap<>();
    private Map<String, Admin> admins = new HashMap<>();

    public Map getUsers() { return users;}

    public Map getAdmins() { return admins;}
}
