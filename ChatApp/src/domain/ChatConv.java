package domain;

import java.util.ArrayList;
import java.util.List;

public class ChatConv {
    public Person me;
    public Person other;
    public List<String> chat;

    public ChatConv(Person me, Person other) {
        this.me = me;
        this.other = other;
        chat = new ArrayList<>();
    }
}
