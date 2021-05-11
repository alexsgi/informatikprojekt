package com.stickjumper.data.list.structure;

import com.stickjumper.data.Player;

public class LastNode extends ListElement {

    @Override
    public ListElement getFollowingNode() {
        return this;
    }

    @Override
    public ListElement insert(Player p) {
        return null;
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
}
