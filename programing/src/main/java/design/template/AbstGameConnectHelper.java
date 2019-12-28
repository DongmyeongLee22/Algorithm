package design.template;

public abstract class AbstGameConnectHelper {

    protected abstract String doSecurity(String string);

    protected abstract boolean authentication(String id, String password);

    protected abstract int authorization(String userName);

    protected abstract String connection(String info);

    //템플릿 메소드
    public String requestConnection(String encodedInfo){

        //보안과정 -> 암호화 된 문자열을 복호화
        String decodedInfo = doSecurity(encodedInfo);

        //반환 된 것을 통해 아이디, 암호를 할당한다.
        String id = "aaa";
        String password = "bbb";
        boolean authentication = authentication(id,password);

        if(!authentication){
            throw new Error("아이디 암호 불일치");
        }
        //위의 정보로 이름을 받아 온다 치자.
        String userName = "userName";
        int authorization = authorization(userName);

        switch (authorization){
            case 0:
                System.out.println("유료 회원");
                break;
            case 1:
                System.out.println("무료 회원");
                break;
        }

        return connection(encodedInfo);
    }
}
