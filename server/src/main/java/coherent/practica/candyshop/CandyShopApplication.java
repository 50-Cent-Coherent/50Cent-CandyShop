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

    public static void main(String[] args) {
        SpringApplication.run(CandyShopApplication.class, args);
    }

    @PostConstruct
    public void runAfterObjectCreated(){

        candyRepository.deleteAll();
        categoryRepository.deleteAll();
        wishlistRepository.deleteAll();
        orderRepository.deleteAll();
        orderCandyRepository.deleteAll();
        wishlistCandyRepository.deleteAll();


        Category testCategory = new Category("chocolate","belgian chocolate");
        categoryRepository.save(testCategory);
        Candy testCandy = new Candy(testCategory,"Milka Caramel","Milka Chocolate","url",10,8);
        Candy testCandy1 = new Candy(testCategory,"Milka White","Milka Chocolate","url",5,5);
        candyRepository.save(testCandy);
        candyRepository.save(testCandy1);



        Wishlist testWishlist = new Wishlist("mywishlist");
        Wishlist testWishlist1 = new Wishlist("mywishlist1");
        wishlistRepository.save(testWishlist);
        wishlistRepository.save(testWishlist1);
        WishlistCandy wishlistCandy = new WishlistCandy(testWishlist,testCandy,5);
        wishlistCandyRepository.save(wishlistCandy);


        Calendar calendar = Calendar.getInstance();
        Order testOrder = new Order(new Timestamp(calendar.getTimeInMillis()));
        orderRepository.save(testOrder);
        OrderCandy orderCandy = new OrderCandy(testOrder,testCandy,5);
        orderCandyRepository.save(orderCandy);

    }

}
