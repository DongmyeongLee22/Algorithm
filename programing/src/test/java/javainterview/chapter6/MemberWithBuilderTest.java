package javainterview.chapter6;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberWithBuilderTest {

@Test
public void buildSuccess() throws Exception{
    //given
    MemberWithBuilder.Builder builder = new MemberWithBuilder.Builder();
    String name = "james";
    String email = "asdq@email.com";
    int age = 10;

    //when
    MemberWithBuilder james = builder.withName(name)
            .withEmail(email)
            .withAge(age)
            .build();

    //then

    assertThat(james.getAge()).isEqualTo(age);
    assertThat(james.getName()).isEqualTo(name);
    assertThat(james.getEmail()).isEqualTo(email);
}

@Test(expected = IllegalArgumentException.class)
public void buidlWithException() throws Exception{

    MemberWithBuilder.Builder builder = new MemberWithBuilder.Builder();
    String name = "james";
    String email = "asdq@email.com";

    MemberWithBuilder james = builder.withName(name)
            .withEmail(email)
            .build();

}


}