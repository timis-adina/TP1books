package books;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jdk.jfr.Timestamp;

@RunWith(Theories.class)
public class BookShopTest {

    public List<Integer> getOrder(){
        return new ArrayList<Integer>(){
            {
                add(5);
            }
        };
    }
    //test if the basket is null
    @Test
    public void TestBasketNull(){
        BookShop4 calc = new BookShop4(); 
        Double price = calc.DeterminePrice(null); 
        assertThat(price, is(0.0)); 
    }

    //test if the bastek is empty
    @Test 
    public void TestBasketEmpty(){
        BookShop4 calc = new BookShop4();
        List<Integer> basket = new ArrayList<Integer>();
        Double price = calc.DeterminePrice(basket); 
        assertThat(price, is(0.0));
    }

    //test if there is only one book
    @Test 
    public void testOneBook(){
        BookShop4 calc = new BookShop4(); 
        List<Integer> basket = new ArrayList<Integer>(){
            {
                add(5);
            }
        };
        Double price = calc.DeterminePrice(basket);
        assertThat(price, is(8.0));
    }

    //test for the purchase of one book
    @Theory
    public void purchaseOneBook(List<Integer>basket){
        BookShop4 calc = new BookShop4();
        Double price = calc.DeterminePrice(basket); 
        assertThat(price, is(8.0));
    }

    //test for the purchase of two books that are the same
    @Theory
    public void purchaseTwoSameBooks(){
        BookShop4 calc = new BookShop4(); 
        List<Integer> basket = new ArrayList<Integer>(){
            {
                add(5);
                add(5);
            }
        };
        Double price = calc.DeterminePrice(basket);
        assertThat(price, is(16.0));
    }

    //test for the purchase of two different books and therefore with a reduction of price
    @Test 
    public void purchaseTwoDiffBooks(){
        BookShop4 calc = new BookShop4(); 
        List<Integer> basket = new ArrayList<Integer>(){
            {
                add(5);
                add(4);
            }
        };
        Double price = calc.DeterminePrice(basket);
        assertThat(price, is(16.0 * 0.93));
    }

    //Test for three books but only two differents
    @Test 
    public void purchaseThreeBooksButTwoDiff(){
        BookShop4 calc = new BookShop4(); 
        List<Integer> basket = new ArrayList<Integer>(){
            {
                add(4);
                add(4);
                add(5);
            }
        };
        Double price = calc.DeterminePrice(basket);
        assertThat(price, is(8.0 + 16.0 * 0.93));
    }

    //test for four books (2x2)
    @Test 
    public void purchaseFourDiffBooks(){
        BookShop4 calc = new BookShop4(); 
        List<Integer> basket = new ArrayList<Integer>(){
            {
                add(1);
                add(1);
                add(2);
                add(2);
            }
        };
        Double price = calc.DeterminePrice(basket);
        assertThat(price, is(2 * (16 * 0.93)));
    }

    //test for a random purchase: 1x2x2x2
    @Test 
    public void randomPurchase(){
        BookShop4 calc = new BookShop4(); 
        List<Integer> basket = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(2);
                add(3);
                add(3);
                add(4);
                add(4);
            }
        };
        Double price = calc.DeterminePrice(basket);
        assertThat(price, is((4 * 8 * 0.72) + (3 * 8 * 0.86)));
    }

    @Test
    public void myFirstTest(){
        assertTrue(false);
    }
}
