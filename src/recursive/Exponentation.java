package recursive;

public class Exponentation {
    int source;

    public Exponentation(int source) {
        this.source = source;

    }

    public int getExponentation(int exp){
        if (exp == 1) {
            return source;
        }
        else {
            source = source*getExponentation(--exp);
        }
        return source;
    }
}
