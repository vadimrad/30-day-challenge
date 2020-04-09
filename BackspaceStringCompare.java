/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

*/

class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();

        process(s);
        process(t);

        return isEqual(s, t);
    }

    private void process(char[] s) {
        int letter = 0, current = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '#') {
                while (letter >= 0 && s[letter] == '1') {
                    letter--;
                }

                s[current] = '1';
                if (letter >= 0) {
                    s[letter] = '1';
                    letter--;
                } else {
                    s[0] = '1';
                }
                current++;
            } else {
                letter = current;
                current++;
            }
        }
    }
    
    private boolean isEqual(char[] s, char[] t) {
        int[] mask = new int[26];
        for (char c : s) {
            if (c != '1') {
                mask[c - 'a']++;
            }
        }
        for (char c : t) {
            if (c != '1') {
                mask[c - 'a']--;
            }
        }
        for (int i : mask) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
