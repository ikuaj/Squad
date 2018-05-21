public class Hero {
    private String mName;
    private int mAge;
    private String mPower;
    private String mWeakness;
    private String mSquad;

    public Hero(String name, int age, String power, String weakness, String squad) {
        mName = name;
        mAge = age;
        mPower = power;
        mWeakness = weakness;
        mSquad = squad;
    }

    public String getName() {
        return mName;
    }

    public int getAge() {
        return mAge;
    }

    public String getPower() {
        return mPower;
    }

    public String getWeakness() {
        return mWeakness;
    }

    public String getSquad() {
        return mSquad;
    }
}