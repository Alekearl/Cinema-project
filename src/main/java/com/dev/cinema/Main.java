package com.dev.cinema;

import com.dev.cinema.exception.AuthenticationException;
import com.dev.cinema.lib.Injector;
import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.model.Movie;
import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.Order;
import com.dev.cinema.model.ShoppingCart;
import com.dev.cinema.model.User;
import com.dev.cinema.service.AuthenticationService;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import com.dev.cinema.service.MovieSessionService;
import com.dev.cinema.service.OrderService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static Injector injector = Injector.getInstance("com.dev.cinema");

    public static void main(String[] args) throws AuthenticationException {
        Movie movie = new Movie();
        Movie movieTwo = new Movie();
        movie.setTitle("Kingdom of Heaven");
        movieTwo.setTitle("Hidden figures");
        movie.setDescription("War and peace at middle east.");
        movieTwo.setDescription("Story about three personalities who worked in NASA");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.add(movie);
        movieService.add(movieTwo);

        movieService.getAll().forEach(System.out::println);

        CinemaHall cinemaHall = new CinemaHall();
        CinemaHall cinemaHallTwo = new CinemaHall();
        cinemaHall.setCapacity(250);
        cinemaHallTwo.setCapacity(150);
        CinemaHallService cinemaHallService =
                (CinemaHallService) injector.getInstance(CinemaHallService.class);
        cinemaHallService.add(cinemaHall);
        cinemaHallService.add(cinemaHallTwo);

        cinemaHallService.getAll().forEach(System.out::println);

        MovieSession movieSession = new MovieSession();
        MovieSession movieSessionTwo = new MovieSession();
        movieSession.setMovie(movie);
        movieSessionTwo.setMovie(movieTwo);
        movieSession.setCinemaHall(cinemaHall);
        movieSessionTwo.setCinemaHall(cinemaHallTwo);
        movieSession.setShowTime(LocalDateTime.of(2021, 1, 2, 14, 30));
        movieSessionTwo.setShowTime(LocalDateTime.of(2021, 2, 10, 18, 30));
        MovieSessionService movieSessionService =
                (MovieSessionService) injector.getInstance(MovieSessionService.class);
        movieSessionService.add(movieSession);
        movieSessionService.add(movieSessionTwo);
        System.out.println(movieSessionService
                .findAvailableSessions(movie.getId(), LocalDate.now()));

        User user = new User();
        user.setEmail("some@gmail.com");
        user.setPassword("some123");
        User userTwo = new User();
        userTwo.setEmail("second@gmail.com");
        userTwo.setPassword("some321");
        UserService userService =
                (UserService) injector.getInstance(UserService.class);
        userService.add(user);
        userService.add(userTwo);
        System.out.println(userService.findByEmail("some@gmail.com"));

        AuthenticationService authenticationService =
                (AuthenticationService) injector.getInstance(AuthenticationService.class);
        authenticationService.register("third@gmail.com", "some333");
        System.out.println(authenticationService.login("third@gmail.com", "some333"));
        ShoppingCartService shoppingCartService =
                (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
        shoppingCartService.registerNewShoppingCart(user);
        shoppingCartService.addSession(movieSession, user);
        shoppingCartService.registerNewShoppingCart(userTwo);
        shoppingCartService.addSession(movieSessionTwo, userTwo);
        OrderService orderService =
                (OrderService) injector.getInstance(OrderService.class);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        System.out.println(orderService.completeOrder(shoppingCart));
        System.out.println(orderService.getOrdersHistory(user));
        Order order = orderService.completeOrder(shoppingCartService.getByUser(userTwo));
        System.out.println(order);
        System.out.println(orderService.getOrdersHistory(userTwo));

    }
}
