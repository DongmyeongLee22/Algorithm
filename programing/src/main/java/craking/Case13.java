package craking;

public class Case13 {

    void replaceSpace(char [] chars, int n) {

        int i, index = 0 ;
        int spaceCount =0;

        for(i = 0 ; i < n; i++) {
            if (chars[i] == ' ')
                spaceCount++;
        }

        index = n + spaceCount*2;

        for(i = n-1; i >=0; i --){
            if(chars[i] == ' '){
                chars[index-1] = '0';
                chars[index-2] = '2';
                chars[index-3] = '%';
                index -= 3;
            }else{
                chars[index-1] = chars[i];
                index--;
            }
        }

        for(char c :chars)
            System.out.print(c);
    }

    public static void main(String[] args) {
        Case13 case13 = new Case13();
        char [] chars = new char[20];
        chars[0] = 'M';
        chars[1] = 'r';
        chars[2] = ' ';
        chars[3] = 'J';
        chars[4] = 'o';
        chars[5] = 'h';
        chars[6] = 'n';
        chars[7] = ' ';
        chars[8] = 'S';
        chars[9] = 'm';
        chars[10] = 'i';
        chars[11] = 't';
        chars[12] = 'h';

        case13.replaceSpace(chars,13);

    }
}
