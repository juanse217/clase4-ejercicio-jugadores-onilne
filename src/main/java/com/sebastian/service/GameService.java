package com.sebastian.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sebastian.model.Player;

public class GameService {
    private HashSet<Player> connected;
    private ArrayList<Player> ranking;
    private LinkedList<Player> queue; 

    private static final Logger logger = LoggerFactory.getLogger(GameService.class);
    

    public GameService(){
        connected = new HashSet<>();
        ranking = new ArrayList<>();
        queue = new LinkedList<>(); 
    }

    public boolean connectPlayer(Player p){
        logger.info("Connecting player {} ", p );
        if(connected.add(p)){
            ranking.add(p); 
            logger.info("Player {} connected", p);
            return true; 
            
        }
        logger.warn("Player {} could not be connected", p);
        return false;
    }

    public boolean disconnectPlayer(Player p){
        logger.info("Connecting player {} ", p );
        if(connected.remove(p)){
            ranking.remove(p);
            logger.info("Player {} disconnected", p);
            return true;
        }
        logger.warn("Player {} could not be connected", p);
        return false;
    }

    public void showConnectedPlayers(){
        logger.info("Showing all players");
        System.out.println(connected);
    }

    public void updateRanking(){
        logger.info("Updating ranking");
        ranking.sort((x, y) -> Integer.compare(x.getPoints(), y.getPoints()));
    }

    public void showRanking(){
        logger.info("Showirg ranking ");
        System.out.println(ranking);
    }

    public void addToqueue(Player p){
        if(connected.contains(p)){
            queue.add(p); 
            logger.info("The player {} been added", p.getNickname());
        }else{
            logger.info("The player already exists in queue, can't be added");
        }
    }

    public void removeFromQueue(){
        if(queue.isEmpty()){
            logger.info("The queue is empty. No items to remove");
        }else{
            Player p = queue.removeFirst();
            logger.info("The player {} been added", p.getNickname());
        }
    }

    public void showQueue(){
        System.out.println(queue);
    }
}
