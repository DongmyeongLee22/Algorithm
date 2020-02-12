package leetcode;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InsertDeleteGetRandomTest {


    private InsertDeleteGetRandom insertDeleteGetRandom = new InsertDeleteGetRandom();

    @Test
    public void firstTest() throws Exception{

        assertThat(insertDeleteGetRandom.insert(1)).isTrue();
        assertThat(insertDeleteGetRandom.insert(5)).isTrue();
        assertThat(insertDeleteGetRandom.insert(2)).isTrue();
        assertThat(insertDeleteGetRandom.insert(3)).isTrue();
        assertThat(insertDeleteGetRandom.insert(1)).isFalse();

        insertDeleteGetRandom.printKeyList();

        assertThat(insertDeleteGetRandom.remove(2)).isTrue();
        assertThat(insertDeleteGetRandom.remove(2)).isFalse();

        insertDeleteGetRandom.printKeyList();
    }

}