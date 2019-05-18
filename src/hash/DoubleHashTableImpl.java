package hash;

public class DoubleHashTableImpl extends HashTableImpl {

    private static final int DOUBLE_HASH_CONST = 5;

    public DoubleHashTableImpl(int maxSize) {
        super(maxSize);
    }

    private int hashFuncDouble(int key){
        return DOUBLE_HASH_CONST - (key % DOUBLE_HASH_CONST);
    }

    @Override
    protected int getStep(int key) {
        return hashFuncDouble(key);
    }
}
