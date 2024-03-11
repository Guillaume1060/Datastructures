package coderByteExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

class Main {

    public static String TreeConstructor(String[] strArr) {
        // code goes here
        Map<Integer, Integer> parents = new HashMap<>(); // value, number of child (0,1 or 2). if > not BST
        Map<Integer, Integer> child = new HashMap<>(); // value, number of parents (must be 1). if > not BST

        for (String s : strArr) {
            String[] pair = s.replaceAll("[()]", "").split(",");
            int keyParent = parseInt(pair[1]);
            int keyChild = parseInt(pair[0]);
            int newValueParents = parents.getOrDefault(keyParent, 0) + 1;
            int newValueChild = child.getOrDefault(keyChild, 0) + 1;
            parents.put(keyParent, newValueParents);
            child.put(keyChild, newValueChild);
            if (newValueParents > 2) return "false";
            if (newValueChild > 1) return "false";
        }
        return "true";
    }

    public static void main(String[] args) {
        // keep this function call here
        String[] shouldBeFalse =  new String[] {"(1,2)", "(3,2)", "(2,12)", "(5,2)"};
        String[] shouldBeTrue = new String[]{"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"};
        System.out.print(TreeConstructor(shouldBeTrue));
        System.out.print(TreeConstructor(shouldBeFalse));
    }

}