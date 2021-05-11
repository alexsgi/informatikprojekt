package com.stickjumper.data.list;

import com.stickjumper.data.Player;
import com.stickjumper.data.list.structure.LastNode;
import com.stickjumper.data.list.structure.ListElement;

public class List {

    private ListElement root = new LastNode();

    public void insert(Player p) {
        root = root.insert(p);
    }

    public int size() {
        return root.size();
    }

    public Player search(String username, String password) {
        return root.search(username, password);
    }

    public void remove(Player p) {
        root = root.removeNode(p);
    }
}
