package programmers.lv2;

public class SkillTree {
    //"CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            char[] treeChars = skill_tree.toCharArray();
            int index = 0;
            boolean flag = true;

            for (char treeChar : treeChars) {
                if(index < skill.indexOf(treeChar)){
                    flag = false;
                    break;
                }

                if (index == skill.indexOf(treeChar)){
                    index++;
                }
            }

            if (flag) answer++;
        }

        return answer;
    }

    public int solution2(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            boolean noCount = skill.indexOf(skill_tree.replaceAll("[^" + skill + "]", "")) == 0;
            answer += noCount ? 0 : 1;
        }

        return answer;
    }

}
