package tests;

import org.junit.Test;

public class Test_13 extends MyTestBase {

    @Test
    public void addToCartAndDel (){

        for (int i = 1; i <= 3; i++){
            app.addToCart();
        }
        app.delFromCart();
    }
}
