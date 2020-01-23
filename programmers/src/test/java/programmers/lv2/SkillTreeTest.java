package programmers.lv2;

import org.junit.Test;

public class SkillTreeTest {

    @Test
    public void as() throws Exception {

        SkillTree skillTree = new SkillTree();
        int cbd = skillTree.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});

        System.out.println("BAD".replaceAll("[^CBD]", ""));

        System.out.println("CBD".indexOf("BCD"));
        System.out.println("CBD".indexOf("CBD"));
        System.out.println("CBD".indexOf("BD"));
        System.out.println("CBD".indexOf("CB"));

    }


}