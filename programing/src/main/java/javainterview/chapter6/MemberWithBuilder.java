package javainterview.chapter6;

public class MemberWithBuilder {

    private String name;
    private String email;
    private Integer age;

    public MemberWithBuilder(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public static class Builder{
        private String name;
        private String email;
        private Integer age;

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withAge(int age){
            this.age = age;
            return this;
        }
        public Builder withEmail(String email){
            this.email = email;
            return this;
        }

        public MemberWithBuilder build(){
            if (name != null && email != null && age != null){
                return new MemberWithBuilder(name, email, age);
            }

            throw new IllegalArgumentException("필드의 모든 값을 넣어주세요");
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }
}
