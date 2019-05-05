package recursive;

public class Exponentation {
    int source;

    public Exponentation(int source) {
        this.source = source;

    }

    public int getExponentation(int exp){
        if (exp<0) {
            System.out.println("Введите положительный аргумент степени");
            return -1;
        }
        else {
            if (exp == 1) {
                return source;
            } else {
                source = source * getExponentation(--exp);
            }
            return source;
        }
    }
}
