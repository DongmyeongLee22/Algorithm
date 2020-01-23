package javainterview.chapter7;

public class Palindrome {

public boolean isPalindrome(String s){
    String toCheck = s.toLowerCase();
    int left = 0;
    int right = toCheck.length() - 1;

    while(left <= right){
        while(left < toCheck.length() - 1 && Character.isLetter(toCheck.charAt(left))) left++;
        while(right > 0 && Character.isLetter(toCheck.charAt(right))) right--;

        if(toCheck.charAt(left) != toCheck.charAt(right)) return false;

        left++;
        right--;
    }

    return true;
}

public boolean isPalidromeWithReverse(String s){
    return s.equals(reverse(s));
}

private String reverse(String s){
    StringBuilder builder = new StringBuilder(s.length());
    for(int i = s.length() -1 ; i >= 0; i--){
        builder.append(s.charAt(i));
    }

    return builder.toString();
}
}
