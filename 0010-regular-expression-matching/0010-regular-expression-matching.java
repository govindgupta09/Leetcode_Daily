class Solution {

    public boolean solve(String s, String p) {

        // Base case
        if (p.length() == 0) {
            return s.length() == 0;
        }

        boolean first_char_matched = false;

        if (s.length() > 0 &&
            (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
            first_char_matched = true;
        }

        // Check if second character is '*'
        if (p.length() >= 2 && p.charAt(1) == '*') {

            // Not take: Ignore current character and '*'
            boolean not_take = solve(s, p.substring(2));

            // Take: Match current character and continue
            boolean take = first_char_matched &&
                           solve(s.substring(1), p);

            return not_take || take;
        }

        // Normal character matching
        return first_char_matched &&
               solve(s.substring(1), p.substring(1));
    }

    public boolean isMatch(String s, String p) {
        return solve(s, p);
    }
}