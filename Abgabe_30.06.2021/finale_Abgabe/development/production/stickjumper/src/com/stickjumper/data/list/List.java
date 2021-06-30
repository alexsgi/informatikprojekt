package com.stickjumper.data.list;

import com.stickjumper.data.Player;
import com.stickjumper.data.list.structure.LastNode;
import com.stickjumper.data.list.structure.ListElement;
import com.stickjumper.data.list.structure.Node;

import java.util.ArrayList;

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

    public Player getRootPlayer() {
        if (root instanceof LastNode) return null;
        return ((Node) root).getPlayer();
    }

    public ArrayList<Player> asArrayList() {
        ArrayList<Player> list = new ArrayList<>();
        root.storeInArrayList(list);
        return list;
    }
}
