package stack;

public class Main {
    public static void main(String[] args) {
        StackImpl<Integer> sImpl = new StackImpl<>(5);
        addIfNotFull(sImpl,1);
        addIfNotFull(sImpl,2);
        addIfNotFull(sImpl,3);
        addIfNotFull(sImpl,4);
        addIfNotFull(sImpl,5);
        removeIsNotEmpty(sImpl);
        removeIsNotEmpty(sImpl);



        String cheat = "IDDQD";
        StackImpl<Character> stringStack = new StackImpl<>(cheat.length());
        for (int i=0 ; i < cheat.length(); i++) {
            stringStack.push(cheat.charAt(i));
        }

        while (!stringStack.isEmpty()){
            removeIsNotEmptyString(stringStack);
        }



    }

    private static void addIfNotFull(StackImpl<Integer> st,Integer value){
        if (!st.isFull()){
            st.push(value);
        }
    }

    private static void removeIsNotEmpty(StackImpl<Integer> st){
        if (!st.isEmpty()){
            System.out.println(st.pop());
        }
    }

    private static void removeIsNotEmptyString(StackImpl<Character> st){
        if (!st.isEmpty()){
            System.out.println(st.pop());
        }
    }

}
