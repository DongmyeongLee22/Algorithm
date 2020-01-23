package programmers.lv2;

import org.junit.Test;

public class ProductDevTest {

    @Test
    public void das() throws Exception {
        ProductDev productDev = new ProductDev();
        // [93,30,55]	[1,30,5]	[2,1]

        productDev.solutiontest(new int[]{93, 30, 55}, new int[]{1, 30 ,5});
    }


}