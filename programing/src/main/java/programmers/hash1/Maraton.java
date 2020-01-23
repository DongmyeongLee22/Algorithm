package programmers.hash1;

import java.util.HashMap;
import java.util.Map;

public class Maraton {

    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();

        String answer = "";

        for(String man : completion){
            map.put(man, map.getOrDefault(man, 0) + 1);
        }


        for(String man : participant){
            if(!map.containsKey(man)){
                answer = man;
                break;
            }else{
                int value = map.get(man) - 1;

                if(value == -2){
                    answer = man;
                    break;
                }

                map.put(man, value);
            }
        }

        return answer;
    }
}
