package org.example.service;

import org.example.model.GameDisk;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private List<GameDisk> games = new ArrayList<>();
    public List<GameDisk> findAll() {
        return games;
    }
    public void save(GameDisk game) {
        if (game.getId() == 0) {
            game.setId(System.currentTimeMillis());
            games.add(game);
        } else {
            update(game);
        }
    }
    public GameDisk findById(Long id){
        return games.stream().
                filter(g -> g.getId() == id).
                findFirst().
                orElse(null);
    }
    public void update(GameDisk game) {
        GameDisk existing = findById(game.getId());
        if (existing != null) {
            existing.setTitle(game.getTitle());
            existing.setGenre(game.getGenre());
            existing.setQuantity(game.getQuantity());
        }
    }
    public void deleteById(Long id){
        games.removeIf(g -> g.getId() == id);
    }
}
