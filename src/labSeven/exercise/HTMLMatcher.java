package labSeven.exercise;

import java.util.Stack;

public class HTMLMatcher {

    public static boolean isHTMLMatched(String[] tags) {
        Stack<String> buffer = new Stack<>();

        for (String tag : tags) {

            // 1. Process Opening Tag: <tagname> or <tagname attribute="value" ...>
            if (tag.startsWith("<") && !tag.startsWith("</")) {

                // Extract the clean tag name, ignoring attributes.
                // The actual tag name is the part from index 1 up to the first space or the closing '>'.
                String cleanTag;
                int firstSpace = tag.indexOf(' ');

                if (firstSpace != -1) {
                    // Attributes exist: Extract the name up to the first space.
                    cleanTag = tag.substring(1, firstSpace);
                } else {
                    // No attributes: Extract the name up to the closing '>'.
                    cleanTag = tag.substring(1, tag.length() - 1);
                }

                // Push the clean tag name onto the stack
                buffer.push(cleanTag);

            } // 2. Process Closing Tag: </tagname>
            else if (tag.startsWith("</")) {

                if (buffer.isEmpty()) {
                    // Mismatched: Closing tag with no matching opening tag
                    return false;
                }

                // Extract the tag name from the closing tag (from index 2 up to '>')
                String closingTag = tag.substring(2, tag.length() - 1);

                // Pop the last opening tag from the stack
                String openingTag = buffer.pop();

                // Compare the popped tag name with the current closing tag name
                if (!openingTag.equals(closingTag)) {
                    // Mismatched: Tags do not correspond
                    return false;
                }
            }
            // Ignore non-tag elements or comments if they are present in the array.
        }

        // 3. Final Check: The stack must be empty
        // If the stack is empty, every opening tag had a corresponding closing tag.
        return buffer.isEmpty();
    }

    public static void main(String[] args) {
        // Test case 1: Standard tags (Should be TRUE)
        String[] test1 = {"<html>", "<body>", "</body>", "</html>"};
        System.out.println("Test 1 (Standard): " + isHTMLMatched(test1));

        // Test case 2: Tags with attributes (Should be TRUE)
        String[] test2 = {"<table border=\"1\" cellpadding=\"5\">", "<tr>", "</tr>", "</table>"};
        System.out.println("Test 2 (With Attributes): " + isHTMLMatched(test2));

        // Test case 3: Mismatched tags (Should be FALSE)
        String[] test3 = {"<p>", "<div>", "</p>", "</div>"};
        System.out.println("Test 3 (Mismatched): " + isHTMLMatched(test3));

        // Test case 4: Unclosed tags (Should be FALSE)
        String[] test4 = {"<a>", "<b>"};
        System.out.println("Test 4 (Unclosed): " + isHTMLMatched(test4));

        // Test case 5: Empty attributes (Should be TRUE)
        String[] test5 = {"<div id>", "</div>"};
        System.out.println("Test 5 (Empty Attributes): " + isHTMLMatched(test5));
    }
}
