package lt.viko.eif.vskuder.soap.gameStore;

import gamestoresoap.*;
import lt.viko.eif.vskuder.soap.gameStore.DataBase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
/**
 * Class that handles all the web service endpoints
 */
@Endpoint
public class StoreEndpoint {
    /**
     * Namespace URI
     */
    private static final String NAMESPACE_URI = "gamestoresoap";
    /**
     * Database url
     */
    private final String url = "jdbc:mysql://localhost:3306/gamestore11";
    /**
     * Database user
     */
    private final String user = "root";
    /**
     * Database password
     */
    private final String password = "root";
    /**
     * Constructor
     */
    @Autowired
    public StoreEndpoint() {
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createUserRequest")
    @ResponsePayload
    public CreateUserResponse createUser(@RequestPayload CreateUserRequest request) {
        CreateUserResponse response = new CreateUserResponse();
        //Using UserDAO to create a new user
        UserDAO userDAO = new UserDAO(url, user, password);

        //Creating a new user
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        //Inserting the user into the database
        boolean success = userDAO.insertUser(user);

        //if the user was successfully inserted
        if (success) {
            response.setAnswer("User was successfully created");
        } else {
            response.setAnswer("User was not created");
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        //Using UserDAO to get a user
        UserDAO userDAO = new UserDAO(url, user, password);

        //Getting the user from the database
        User user = userDAO.getUserById(request.getUserId());

        //if the user was successfully inserted
        if (user != null) {
            response.setUser(user);
        } else {
            response.setUser(null);
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsersRequest")
    @ResponsePayload
    public GetUsersResponse getUsers(@RequestPayload GetUsersRequest request) {
        GetUsersResponse response = new GetUsersResponse();
        //Using UserDAO to get a user
        UserDAO userDAO = new UserDAO(url, user, password);

        //Getting the user from the database
        response.getUsers().addAll(userDAO.getAllUsers());

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    public UpdateUserResponse updateUser(@RequestPayload UpdateUserRequest request) {
        UpdateUserResponse response = new UpdateUserResponse();
        //Using UserDAO to get a user
        UserDAO userDAO = new UserDAO(url, user, password);

        //creating a new user
        User user = new User();
        user.setId(request.getUserId());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        //Getting the user from the database
        boolean success = userDAO.updateUser(user);

        //if the user was successfully deleted
        if (success) {
            response.setAnswer("User was successfully updated");
        } else {
            response.setAnswer("User was not updated");
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeUserRequest")
    @ResponsePayload
    public RemoveUserResponse removeUser(@RequestPayload RemoveUserRequest request) {
        RemoveUserResponse response = new RemoveUserResponse();
        //Using UserDAO to get a user
        UserDAO userDAO = new UserDAO(url, user, password);

        //Getting the user from the database
        boolean success = userDAO.deleteUser(request.getUserId());

        //if the user was successfully deleted
        if (success) {
            response.setAnswer("User was successfully removed");
        } else {
            response.setAnswer("User was not removed");
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCategoryRequest")
    @ResponsePayload
    public CreateCategoryResponse createCategory(@RequestPayload CreateCategoryRequest request) {
        CreateCategoryResponse response = new CreateCategoryResponse();
        //Using UserDAO to create a new user
        CategoryDAO userDAO = new CategoryDAO(url, user, password);

        //Creating a new user
        Category category = new Category();
        category.setName(request.getCategoryName());

        //Inserting the user into the database
        boolean success = userDAO.insertCategory(category);

        //if the user was successfully inserted
        if (success) {
            response.setAnswer("Category was successfully created");
        } else {
            response.setAnswer("Category was not created");
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCategoryRequest")
    @ResponsePayload
    public GetCategoryResponse getCategory(@RequestPayload GetCategoryRequest request) {
        GetCategoryResponse response = new GetCategoryResponse();
        //Using UserDAO to get a user
        CategoryDAO userDAO = new CategoryDAO(url, user, password);

        //Getting the user from the database
        Category category = userDAO.getCategoryById(request.getCategoryId());

        //if the user was successfully inserted
        if (category != null) {
            response.setCategory(category);
        } else {
            response.setCategory(null);
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCategoriesRequest")
    @ResponsePayload
    public GetCategoriesResponse getCategories(@RequestPayload GetCategoriesRequest request) {
        GetCategoriesResponse response = new GetCategoriesResponse();
        //Using UserDAO to get a user
        CategoryDAO userDAO = new CategoryDAO(url, user, password);

        //Getting the user from the database
        response.getCategories().addAll(userDAO.getAllCategories());

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCategoryRequest")
    @ResponsePayload
    public UpdateCategoryResponse updateCategory(@RequestPayload UpdateCategoryRequest request) {
        UpdateCategoryResponse response = new UpdateCategoryResponse();
        //Using UserDAO to get a user
        CategoryDAO userDAO = new CategoryDAO(url, user, password);

        //creating a new user
        Category category = new Category();
        category.setId(request.getCategoryId());
        category.setName(request.getCategoryName());

        //Getting the user from the database
        boolean success = userDAO.updateCategory(category);

        //if the user was successfully deleted
        if (success) {
            response.setAnswer("Category was successfully updated");
        } else {
            response.setAnswer("Category was not updated");
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeCategoryRequest")
    @ResponsePayload
    public RemoveCategoryResponse removeCategory(@RequestPayload RemoveCategoryRequest request) {
        RemoveCategoryResponse response = new RemoveCategoryResponse();
        //Using UserDAO to get a user
        CategoryDAO userDAO = new CategoryDAO(url, user, password);

        //Getting the user from the database
        boolean success = userDAO.deleteCategory(request.getCategoryId());

        //if the user was successfully deleted
        if (success) {
            response.setAnswer("Category was successfully removed");
        } else {
            response.setAnswer("Category was not removed");
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createDeveloperRequest")
    @ResponsePayload
    public CreateDeveloperResponse createDeveloper(@RequestPayload CreateDeveloperRequest request) {
        CreateDeveloperResponse response = new CreateDeveloperResponse();
        //Using UserDAO to create a new user
        DeveloperDAO userDAO = new DeveloperDAO(url, user, password);

        //Creating a new user
        Developer developer = new Developer();
        developer.setName(request.getDeveloperName());

        //Inserting the user into the database
        boolean success = userDAO.insertDeveloper(developer);

        //if the user was successfully inserted
        if (success) {
            response.setAnswer("Developer was successfully created");
        } else {
            response.setAnswer("Developer was not created");
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDeveloperRequest")
    @ResponsePayload
    public GetDeveloperResponse getDeveloper(@RequestPayload GetDeveloperRequest request) {
        GetDeveloperResponse response = new GetDeveloperResponse();
        //Using UserDAO to get a user
        DeveloperDAO userDAO = new DeveloperDAO(url, user, password);

        //Getting the user from the database
        Developer developer = userDAO.getDeveloperById(request.getDeveloperId());

        //if the user was successfully inserted
        if (developer != null) {
            response.setDeveloper(developer);
        } else {
            response.setDeveloper(null);
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDevelopersRequest")
    @ResponsePayload
    public GetDevelopersResponse getDevelopers(@RequestPayload GetDevelopersRequest request) {
        GetDevelopersResponse response = new GetDevelopersResponse();
        //Using UserDAO to get a user
        DeveloperDAO userDAO = new DeveloperDAO(url, user, password);

        //Getting the user from the database
        response.getDevelopers().addAll(userDAO.getAllDevelopers());

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateDeveloperRequest")
    @ResponsePayload
    public UpdateDeveloperResponse updateDeveloper(@RequestPayload UpdateDeveloperRequest request) {
        UpdateDeveloperResponse response = new UpdateDeveloperResponse();
        //Using UserDAO to get a user
        DeveloperDAO userDAO = new DeveloperDAO(url, user, password);

        //creating a new user
        Developer developer = new Developer();
        developer.setId(request.getDeveloperId());
        developer.setName(request.getDeveloperName());

        //Getting the user from the database
        boolean success = userDAO.updateDeveloper(developer);

        //if the user was successfully deleted
        if (success) {
            response.setAnswer("Developer was successfully updated");
        } else {
            response.setAnswer("Developer was not updated");
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeDeveloperRequest")
    @ResponsePayload
    public RemoveDeveloperResponse removeDeveloper(@RequestPayload RemoveDeveloperRequest request) {
        RemoveDeveloperResponse response = new RemoveDeveloperResponse();
        //Using UserDAO to get a user
        DeveloperDAO userDAO = new DeveloperDAO(url, user, password);

        //Getting the user from the database
        boolean success = userDAO.deleteDeveloper(request.getDeveloperId());

        //if the user was successfully deleted
        if (success) {
            response.setAnswer("Developer was successfully removed");
        } else {
            response.setAnswer("Developer was not removed");
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createGameRequest")
    @ResponsePayload
    public CreateGameResponse createGameResponse(@RequestPayload CreateGameRequest request) {
        CreateGameResponse response = new CreateGameResponse();
        //Using UserDAO to create a new user
        GameDAO userDAO = new GameDAO(url, user, password);
        DeveloperDAO developerDAO = new DeveloperDAO(url, user, password);
        CategoryDAO categoryDAO = new CategoryDAO(url, user, password);

        //Creating a new user
        Game game = new Game();
        game.setTitle(request.getGameTitle());
        game.setPrice(request.getGamePrice());
        game.setDeveloper(developerDAO.getDeveloperById(request.getGameDeveloperId()));
        game.setCategory(categoryDAO.getCategoryById(request.getGameCategoryId()));

        //Inserting the user into the database
        boolean success = userDAO.insertGame(game);

        //if the user was successfully inserted
        if (success) {
            response.setAnswer("Game was successfully created");
        } else {
            response.setAnswer("Game was not created");
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGameRequest")
    @ResponsePayload
    public GetGameResponse getGame(@RequestPayload GetGameRequest request) {
        GetGameResponse response = new GetGameResponse();
        //Using UserDAO to get a user
        GameDAO userDAO = new GameDAO(url, user, password);

        //Getting the user from the database
        Game game = userDAO.getGameById(request.getGameId());

        //if the user was successfully inserted
        if (game != null) {
            response.setGame(game);
        } else {
            response.setGame(null);
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGamesRequest")
    @ResponsePayload
    public GetGamesResponse getGames(@RequestPayload GetGamesRequest request) {
        GetGamesResponse response = new GetGamesResponse();
        //Using UserDAO to get a user
        GameDAO userDAO = new GameDAO(url, user, password);

        //Getting the user from the database
        response.getGames().addAll(userDAO.getAllGames());

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateGameRequest")
    @ResponsePayload
    public UpdateGameResponse updateGame(@RequestPayload UpdateGameRequest request) {
        UpdateGameResponse response = new UpdateGameResponse();
        //Using UserDAO to get a user
        GameDAO userDAO = new GameDAO(url, user, password);
        DeveloperDAO developerDAO = new DeveloperDAO(url, user, password);
        CategoryDAO categoryDAO = new CategoryDAO(url, user, password);

        //creating a new user
        Game game = new Game();
        game.setId(request.getGameId());
        game.setTitle(request.getGameTitle());
        game.setPrice(request.getGamePrice());
        game.setDeveloper(developerDAO.getDeveloperById(request.getGameDeveloperId()));
        game.setCategory(categoryDAO.getCategoryById(request.getGameCategoryId()));

        //Getting the user from the database
        boolean success = userDAO.updateGame(game);

        //if the user was successfully deleted
        if (success) {
            response.setAnswer("Game was successfully updated");
        } else {
            response.setAnswer("Game was not updated");
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeGameRequest")
    @ResponsePayload
    public RemoveGameResponse removeGame(@RequestPayload RemoveGameRequest request) {
        RemoveGameResponse response = new RemoveGameResponse();
        //Using UserDAO to get a user
        GameDAO userDAO = new GameDAO(url, user, password);

        //Getting the user from the database
        boolean success = userDAO.deleteGame(request.getGameId());

        //if the user was successfully deleted
        if (success) {
            response.setAnswer("Game was successfully removed");
        } else {
            response.setAnswer("Game was not removed");
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addItemToLibraryRequest")
    @ResponsePayload
    public AddItemToLibraryResponse addItemToLibrary(@RequestPayload AddItemToLibraryRequest request) {
        AddItemToLibraryResponse response = new AddItemToLibraryResponse();
        //Using UserDAO to get a user
        LibraryDAO userDAO = new LibraryDAO(url, user, password);
        UserDAO userDAO1 = new UserDAO(url, user, password);
        GameDAO gameDAO = new GameDAO(url, user, password);

        //Getting the user from the database
        boolean success = userDAO.insertGameIntoLibrary(userDAO1.getUserById(request.getUserId())
                , gameDAO.getGameById(request.getGameId()));

        //if the user was successfully deleted
        if (success) {
            response.setAnswer("Item was successfully added to library");
        } else {
            response.setAnswer("Item was not added to library");
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeItemFromLibraryRequest")
    @ResponsePayload
    public RemoveItemFromLibraryResponse removeItemFromLibrary(@RequestPayload RemoveItemFromLibraryRequest request) {
        RemoveItemFromLibraryResponse response = new RemoveItemFromLibraryResponse();
        //Using UserDAO to get a user
        LibraryDAO userDAO = new LibraryDAO(url, user, password);
        UserDAO userDAO1 = new UserDAO(url, user, password);
        GameDAO gameDAO = new GameDAO(url, user, password);

        //Getting the user from the database
        boolean success = userDAO.removeGameFromLibrary(userDAO1.getUserById(request.getUserId())
                , gameDAO.getGameById(request.getGameId()));

        //if the user was successfully deleted
        if (success) {
            response.setAnswer("Item was successfully removed from library");
        } else {
            response.setAnswer("Item was not removed from library");
        }

        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLibraryRequest")
    @ResponsePayload
    public GetLibraryResponse getLibrary(@RequestPayload GetLibraryRequest request) {
        GetLibraryResponse response = new GetLibraryResponse();
        //Using UserDAO to get a user
        LibraryDAO userDAO = new LibraryDAO(url, user, password);
        GameDAO gameDAO = new GameDAO(url, user, password);

        //Getting the user from the database
        response.getGames().addAll(userDAO.getLibraryByUserId(request.getUserId()).getGames());
        return response;
    }
    /**
     * Method that handles the getAllGames request
     * @param request request
     * @return response
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLibraryUserRequest")
    @ResponsePayload
    public GetLibraryUserResponse getLibraryUser(@RequestPayload GetLibraryUserRequest request) {
        GetLibraryUserResponse response = new GetLibraryUserResponse();
        //Using UserDAO to get a user
        LibraryDAO userDAO = new LibraryDAO(url, user, password);

        //Getting the user from the database
        response.setUser(userDAO.getLibraryByUserId(request.getUserId()).getUser());
        response.getGames().addAll(userDAO.getLibraryByUserId(request.getUserId()).getGames());
        return response;
    }
}
