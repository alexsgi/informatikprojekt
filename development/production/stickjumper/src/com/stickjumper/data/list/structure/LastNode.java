package com.stickjumper.data.list.structure;

import com.stickjumper.data.Player;

import java.util.ArrayList;

public class LastNode extends ListElement {

    @Override
    public ListElement getFollowingNode() {
        return this;
    }

    @Override
    public ListElement insert(Player p) {
        Node n = new Node(p);
        n.setFollowingNode(this);
        return n;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Player search(String username, String password) {
        return null;
    }

    @Override
    public ListElement removeNode(Player p) {
        return this;
    }

    @Override
    public void storeInArrayList(ArrayList<Player> list) {
    }

}
