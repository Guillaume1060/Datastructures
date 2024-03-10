package stack;

/*public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack(4);
        myStack.push(7);
        myStack.push(7);
        myStack.pop();

        myStack.getTop();
        myStack.getHeight();


        myStack.printStack();
    }
}*/

import java.util.*;

class Main {

    public static String MinWindowSubstring(String[] strArr) {
        // code goes here
        // Create a set of char of K
        ArrayList<Character> charSet = new ArrayList<>(); // must be a list
        for (char c : strArr[1].toCharArray()) {
            charSet.add(c);
        }


        // create variables
        List<String> strings = new ArrayList();
        ArrayList<Character>[] counters = new ArrayList[strArr[0].length()];
        // Initialize each set in the array
        for (int i = 0; i < counters.length; i++) {
            counters[i] = new ArrayList<>(charSet);
        }
        //System.out.println(counters[0].remove(counters[0].indexOf('j')));
        //System.out.println(counters[0].get(0));

        List<String> finalString = new ArrayList();

        // loop into N
        for (char c : strArr[0].toCharArray()) {
            System.out.println("letter="+c);
            if (charSet.contains(c)) {
                // Here I add the char to existing String and/or I create a new one
                for (int i = 0; i < strings.size(); i++) {
                    System.out.println(c+"->"+i);
                    strings.set(i, strings.get(i) + c);
                    if (counters[i].isEmpty()) {
                        finalString.add(strings.get(i));
                    } else {
                        System.out.println(counters[i].toString()+"---->"+c);
                        if (counters[i].contains(c)) {
                            counters[i].remove(counters[i].indexOf(c));
                        }
                    }
                }
                strings.add(String.valueOf(c));
            } else {
                for (int i = 0; i < strings.size(); i++) {
                    strings.set(i, strings.get(i) + c);
                }
            }
        }

        // below I return the smallest string of tha array/list created ?
        String shortestString = finalString.get(0); // Supposons que le premier string est le plus court initialement
        System.out.println(finalString.toString());

        for (int i = 1; i < finalString.size(); i++) {
            //System.out.println(finalString.get(i));
            String currentString = finalString.get(i);
            if (currentString.length() < shortestString.length()) {
                shortestString = currentString;
            }
        }

        return shortestString;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(MinWindowSubstring(new String[] {"ahffaksfajeeubsne", "jefaa"}));
    }

}