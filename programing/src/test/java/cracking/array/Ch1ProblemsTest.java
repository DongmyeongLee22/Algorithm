package cracking.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Ch1ProblemsTest {


    Problems problems = new Problems();

    @Test
    public void isDuplicate() throws Exception{

        String str1 = "qweasdzxc";
        String str2 = "qweasdzxa";
        String str3 = "qweasdzxchtrn";


        boolean isTrue = problems.isDuplicate(str1);
        boolean isFlase = problems.isDuplicate(str2);
        boolean isTrue2 = problems.isDuplicate(str3);

        assertThat(isTrue).isTrue();
        assertThat(isFlase).isFalse();
        assertThat(isTrue2).isTrue();


    }


    @Test
    public void isPermutation() throws Exception{
        //given
        String str1 = "asdqwezxc";
        String str2 = "asdzxcqwe";
        String str3 = "asdzxqg";

        //when
        boolean isTrue = problems.isPermutation(str1, str2);
        boolean isFalse = problems.isPermutation(str1, str3);

        //then
        assertThat(isTrue).isTrue();
        assertThat(isFalse).isFalse();
    }

    @Test
    public void isPermutation2() throws Exception{
        //given
        String str1 = "taboobat";
        String str2 = "taboazobat";

        boolean isTrue = problems.isPermutation2(str1.toCharArray());
        boolean isFalse = problems.isPermutation2(str2.toCharArray());

        assertThat(isTrue).isTrue();
        assertThat(isFalse).isFalse();


        //when

        //then
    }

    @Test
    public void isOnetime() throws Exception{
        //given
        String str1 = "pale";
        String str2 = "ple";
        String str3 = "pales";
        String str4 = "bale";
        String str5 = "bake";

        //when
        boolean isTrue = problems.isOneTime(str1.toCharArray(), str2.toCharArray());
        boolean isTrue2 = problems.isOneTime(str1.toCharArray(), str3.toCharArray());
        boolean isTrue3 = problems.isOneTime(str1.toCharArray(), str4.toCharArray());
        boolean isFalse = problems.isOneTime(str1.toCharArray(), str5.toCharArray());

        //then

        assertThat(isTrue).isTrue();
        assertThat(isTrue2).isTrue();
        assertThat(isTrue3).isTrue();
        assertThat(isFalse).isFalse();
    }



}