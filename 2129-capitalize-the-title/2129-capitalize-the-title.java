class Solution {
    public String capitalizeTitle(String title) {
        title = title + ' ';
        String result = "";
        int len = title.length();
        int j = 0;
        for(int i=0; i<len; i++) {
            if(title.charAt(i) == ' ') {
                String sub = capitalized(title.substring(j, i));
                result = result + sub + ' ';
                j = i+1;
            }
        }
        return result.trim();
    }

    public String capitalized(String sub) {
        int len = sub.length();
        if(len < 3) {
            return sub.toLowerCase();
        }
        else {
             return sub.substring(0, 1).toUpperCase() + sub.substring(1).toLowerCase();
        }
    }
}