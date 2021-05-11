package com.stickjumper.data.list.structure;

import com.stickjumper.data.Player;

public class Node extends ListElement {

    private ListElement followingNode = new LastNode();
    private Player player;

    public Node(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public ListElement getFollowingNode() {
        return followingNode;
    }

    public void setFollowingNode(ListElement follower) {
        this.followingNode = follower;
    }

    @Override
    public ListElement insert(Player p) {
        followingNode = followingNode.insert(p);
        return this;
    }

    @Override
    public int size() {
        return followingNode.size() + 1;
    }

    @Override
    public Player search(String username, String password) {
        if (player.getPlayerName().equals(username) && player.getPlayerPassword().equals(password)) {
            return player;
        }
        return followingNode.search(username, password);
    }

    @Override
    public ListElement removeNode(Player p) {
        if (player == p) return followingNode;
        followingNode = followingNode.removeNode(p);
        return this;
    }
}
