package com.stickjumper.data.list.structure;

import com.stickjumper.data.Player;

public class Node extends ListElement {

    private Node
    private Player player;

    public Node(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
