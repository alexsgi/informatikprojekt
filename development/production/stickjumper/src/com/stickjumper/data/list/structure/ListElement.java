package com.stickjumper.data.list.structure;

import com.stickjumper.data.Player;

import java.util.ArrayList;

public abstract class ListElement {

    public abstract ListElement getFollowingNode();

    public abstract ListElement insert(Player p);

    public abstract int size();

    public abstract Player search(String username, String password);

    public abstract ListElement removeNode(Player p);

    public abstract void storeInArrayList(ArrayList<Player> list);
}
