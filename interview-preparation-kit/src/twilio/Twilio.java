package twilio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class Twilio {

    public static ArrayList<String> out;

    public static class Node {
        Character value;
        HashMap<Character, Node> children;
        boolean endOfPrefix;
        String part;

        public Node(Character value, boolean endOfPrefix, String part) {
            this.value = value;
            this.endOfPrefix = endOfPrefix;
            children = new HashMap<>();
            this.part = part;
        }
    }

    public static void find(Node node, String number, String best) {
        if (node.endOfPrefix) {
            best = node.part;
        }

        char digit = number.charAt(0);

        if (node.children.containsKey(digit)) {
            find(node.children.get(digit), number.substring(1), best);
        } else {
            System.out.println(best);
            out.add(best);
        }
    }

    public static void pushToTree(Node node, String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            node.endOfPrefix = true;
            return;
        }

        char digit = prefix.charAt(0);

        if (node.children.containsKey(digit)) {
            pushToTree(node.children.get(digit), prefix.substring(1));
        } else {
            Node newNode = new Node(digit, false, node.part + digit);
            node.children.put(digit, newNode);
            pushToTree(newNode, prefix.substring(1));
        }
    }

    public static List<String> match(List<String> prefixes, List<String> numbers) {
        out = new ArrayList<>();
        Node root = new Node('+', false, "+");

        for (String prefix : prefixes) {
            pushToTree(root, prefix.substring(1));
        }

        for (String number : numbers) {
            find(root, number.substring(1), "");
        }

        return out;
    }

}