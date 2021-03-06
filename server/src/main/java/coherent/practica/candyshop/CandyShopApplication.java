package coherent.practica.candyshop;

import coherent.practica.candyshop.model.*;
import coherent.practica.candyshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@SpringBootApplication
public class CandyShopApplication {
    @Autowired
    private CandyRepository candyRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderCandyRepository orderCandyRepository;
    @Autowired
    private WishlistCandyRepository wishlistCandyRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDataRepository userDataRepository;

    public static void main(String[] args) {
        SpringApplication.run(CandyShopApplication.class, args);
    }

    @PostConstruct
    public void runAfterObjectCreated(){

        orderCandyRepository.deleteAll();
        wishlistCandyRepository.deleteAll();
        candyRepository.deleteAll();
        categoryRepository.deleteAll();
        wishlistRepository.deleteAll();
        orderRepository.deleteAll();
        userDataRepository.deleteAll();
        userRepository.deleteAll();



        Category testCategory = new Category("chocolate","belgian chocolate");
        categoryRepository.save(testCategory);
        Candy testCandy = new Candy(testCategory,"Milka Caramel","Milka Chocolate","url",10,8);
        Candy testCandy1 = new Candy(testCategory,"Milka White","Milka Chocolate","url",5,5);
        candyRepository.save(testCandy);
        candyRepository.save(testCandy1);
        //System.out.println(candyRepository.findAll());

        User testUser = new User("$2a$10$ad8yto4HdK8MV0YvVzY03eriBnU3eR9YGlv27LqshZcPcp56FDYFC","Antonio","ROLE_ADMIN");
        UserData testUserData = new UserData("tudor","anita","gmail","address","0726",testUser);
        userRepository.save(testUser);
        userDataRepository.save(testUserData);
        User testUser1 = new User("$2a$10$ad8yto4HdK8MV0YvVzY03eriBnU3eR9YGlv27LqshZcPcp56FDYFC","Mihai","ROLE_ADMIN");
        UserData testUserData1 = new UserData("tudor1","anita","gmail","address","0726",testUser1);
        userRepository.save(testUser1);
        userDataRepository.save(testUserData1);
        User testUser2 = new User("$2a$10$ad8yto4HdK8MV0YvVzY03eriBnU3eR9YGlv27LqshZcPcp56FDYFC","RealAdmin","ROLE_ADMIN");
        UserData testUserData2 = new UserData("tudor1","anita","gmail","address","0726",testUser2);
        userRepository.save(testUser2);
        userDataRepository.save(testUserData2);


        Wishlist testWishlist = new Wishlist("mywishlist",testUser);
        wishlistRepository.save(testWishlist);
        WishlistCandy wishlistCandy = new WishlistCandy(testWishlist,testCandy,5);
        wishlistCandyRepository.save(wishlistCandy);
        Wishlist testWishlist1 = new Wishlist("mywishlist1",testUser1);
        wishlistRepository.save(testWishlist1);
        WishlistCandy wishlistCandy1 = new WishlistCandy(testWishlist1,testCandy,5);
        wishlistCandyRepository.save(wishlistCandy1);
        Wishlist testWishlist2 = new Wishlist("mywishlist2",testUser2);
        wishlistRepository.save(testWishlist2);
        WishlistCandy wishlistCandy2 = new WishlistCandy(testWishlist2,testCandy1,5);
        wishlistCandyRepository.save(wishlistCandy2);



        Calendar calendar = Calendar.getInstance();
        Order testOrder = new Order(new Timestamp(calendar.getTimeInMillis()),testUserData);
        orderRepository.save(testOrder);
        OrderCandy orderCandy = new OrderCandy(testOrder,testCandy,5);
        orderCandyRepository.save(orderCandy);





    }

}
