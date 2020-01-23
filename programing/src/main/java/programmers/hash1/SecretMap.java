package programmers.hash1;

public class SecretMap {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String [n];

        for(int i = 0 ; i < n; i++){

            StringBuilder builder = new StringBuilder();

            int orResult = arr1[i] | arr2[i];
            int flag = 1 << 4;

            for(int j = 0 ; j < n; j++){
                if((orResult & flag) == 0){
                    builder.append(" ");
                }else{
                    builder.append("#");
                }
                flag >>= 1;
            }
            answer[i] = builder.toString();

        }
        return answer;
    }
}
