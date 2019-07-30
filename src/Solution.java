import java.util.Set;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author L
 * @Date 2019/7/25 16:53
 * @Version 1.0
 **/
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s.length() == 0) {
            return false;
        }
        boolean[] result = new boolean[s.length()+1];
        result[0] = true;
        for(int i = 1 ; i <= s.length();i++) {
            for(int j = 0; j < i;j++) {
                if(result[j] && dict.contains(s.substring(j,i)) ) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[s.length()];
    }
}
