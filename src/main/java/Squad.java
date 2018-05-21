public class Squad {
    private String mName;
    private int mSize;
    private String mPurpose;

    public Squad(String name, int size, String purpose) {
        mName = name;
        mSize = size;
        mPurpose = purpose;
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
}