package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Car1", 1);
      Car car2 = new Car("Car2", 2);
      Car car3 = new Car("Car3", 3);
      Car car4 = new Car("Car4", 4);

      userService.add(new User("User1", "LastName1", "user1@gmail.com", car1));
      userService.add(new User("User2", "LasName2", "user2@gmail.com", car2));
      userService.add(new User("User3", "LastName3", "user3@gmail.com", car3));
      userService.add(new User("User4", "LastName4", "user4@gmail.com", car4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " +user.getId());
         System.out.println("FirstName = " +user.getFirstName());
         System.out.println("LastName = " +user.getLastName());
         System.out.println("Email = " +user.getEmail());
         System.out.println("Car = " + user.getCars());
         System.out.println();
      }
      userService.findUserByCar(car1);

      context.close();
   }
}