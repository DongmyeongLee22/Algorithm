package design.strategy;

public class GameCharacter {

    private Weapon weapon;

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void attack() {
        //델리 게이트
        if (weapon == null)
            System.out.println("맨손 공격");
        else
            weapon.attack();

    }
}
