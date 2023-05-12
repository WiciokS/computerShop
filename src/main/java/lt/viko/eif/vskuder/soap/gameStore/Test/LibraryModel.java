package lt.viko.eif.vskuder.soap.gameStore.Test;

import java.util.ArrayList;
import java.util.List;

public class LibraryModel {

    int id;
    UserModel user;
    List<GameModel> games;

    public LibraryModel(int id, UserModel user, List<GameModel> games) {
        this.id = id;
        this.user = user;
        this.games = games;
    }

    public LibraryModel(UserModel user, List<GameModel> games) {
        this.user = user;
        this.games = games;
    }

    public LibraryModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<GameModel> getGames() {
        return games;
    }

    public void setGames(List<GameModel> games) {
        this.games = games;
    }

    public void addGame(GameModel game) {
        if (games == null) {
            games = new ArrayList<>();
        }
        games.add(game);
    }

    public void removeGame(GameModel game) {
        if (games != null) {
            games.remove(game);
        }
    }
}
