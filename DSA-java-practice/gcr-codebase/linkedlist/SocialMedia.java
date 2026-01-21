class Friend {
    int id;
    Friend next;
    Friend(int id) { this.id = id; }
}

class User {
    int id;
    String name;
    Friend friends;
    User next;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class SocialMedia {
    static User head = null;

    static void addFriend(User u, int fid) {
        Friend f = new Friend(fid);
        f.next = u.friends;
        u.friends = f;
    }
}
