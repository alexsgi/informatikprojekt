package com.stickjumper.data.list.structure;

import com.stickjumper.data.Player;

public abstract class ListElement {

    public abstract ListElement getFollower();

    public abstract ListElement insert(Player p);

    public abstract int size();

    public abstract Player search(String username, String password);

    public abstract ListElement removeNode(Player p);
}
