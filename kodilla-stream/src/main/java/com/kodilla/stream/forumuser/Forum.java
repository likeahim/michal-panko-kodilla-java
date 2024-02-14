package com.kodilla.stream.forumuser;

import com.kodilla.stream.ForumUser;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> theListOfUsers = new ArrayList<>();

    public Forum() {
        theListOfUsers.add(new ForumUser(7055, "marco67", 'M', 15, 2, 2004, 23));
        theListOfUsers.add(new ForumUser(3443, "babic", 'W', 20, 1, 1988, 230));
        theListOfUsers.add(new ForumUser(9009, "benitto", 'M', 20, 1, 1978, 0));
        theListOfUsers.add(new ForumUser(1001, "mystic1", 'M', 10, 1, 1998, 1002));
        theListOfUsers.add(new ForumUser(10011, "newman", 'M', 10, 12, 1998, 0));
        theListOfUsers.add(new ForumUser(2001, "gillz", 'W', 11, 7, 1990, 23));
        theListOfUsers.add(new ForumUser(2005, "enigmag", 'M', 14, 2, 2004, 233));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theListOfUsers);
    }
}
