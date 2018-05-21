import java.util.*;

public class Squad {
    private String mName;
    private int mSize;
    private String mPurpose;
    private static List<Squad> instances = new ArrayList<Squad>();
    private int mId;
    private List<Hero> heroes;

    public Squad(String name, int size, String purpose) {
        mName = name;
        mSize = size;
        mPurpose = purpose;
        instances.add(this);
        mId = instances.size();
        heroes = new ArrayList<Hero>();
    }

    public String getName() {
        return mName;
    }

    public int getSize() {
        return mSize;
    }

    public String getPurpose() {
        return mPurpose;
    }

    public static List<Squad> all() {
        return instances;
    }

    public static Squad find(int id){
        return instances.get(id - 1);
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public int getId() {
        return mId;
    }

    public void addHero(Hero newHero) {
        heroes.add(newHero);
    }
}