package com.stickjumper.data.list.structure;

import com.stickjumper.data.Player;

public class Node extends ListElement {

    private ListElement follower = new LastNode();
    private Player player;

    public Node(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public ListElement getFollower() {
        return follower;
    }

    @Override
    public ListElement insert(Player p) {
        follower = follower.insert(p);
        return this;
    }

    @Override
    public int size() {
        return follower.size() + 1;
    }

    @Override
    public Player search(String username, String password) {
        if (player.getPlayerName().equals(username) && player.getPlayerPassword().equals(password)) {
            return player;
        }
        return follower.search(username, password);
    }

    @Override
    public ListElement removeNode(Player p) {
        if (player == p) return follower;
        follower = follower.removeNode(p);
        return this;
    }

    public void setFollower(ListElement follower) {
        this.follower = follower;
    }
}
