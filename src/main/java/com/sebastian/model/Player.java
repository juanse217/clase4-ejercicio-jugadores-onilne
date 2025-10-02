package com.sebastian.model;

public class Player {
    private String nickname; 
    private int level; 
    private int points;

    
    public Player(String nickname, int level, int points) {
        this.nickname = nickname;
        this.level = level;
        this.points = points;
    }

    public String getNickname() {
        return nickname;
    }
    
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        if (nickname == null) {
            if (other.nickname != null)
                return false;
        } else if (!nickname.equals(other.nickname))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Player [nickname=" + nickname + ", level=" + level + ", points=" + points + "]";
    } 

}
