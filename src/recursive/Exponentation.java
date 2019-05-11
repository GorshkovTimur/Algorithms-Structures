package recursive;

public class Exponentation {
    int source;

    public Exponentation(int source) {
        this.source = source;

    }

    public int getExponentation(int exp){
        if (source == 0){
            if (exp != 0){
                return 0;
            }
            else {
                System.out.println("Нельзя возводить 0 в нулевую степень");
            }
        }
        if (exp < 0) {
            System.out.println("Введите положительный аргумент степени");
            return -1;
        }
        else {
            if (exp == 1) {
                return source;
            }
                else if (exp==0){
                    return 1;
                }
            else  {
                source = source * getExponentation(--exp);
            }
            return source;
        }
    }
}
