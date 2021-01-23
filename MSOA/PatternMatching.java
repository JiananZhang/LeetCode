/*
Programming challenge description:
Given a pattern as the first argument and a string of blobs split by | show the number
of times the pattern is present in each blob and the total number of matches.

Input:
The input consists of the pattern (“bc” in the example) which is separated by a semicolon
followed by a list of blobs (“bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32” in the example).
Example input: bc;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32

Output:
The output should consist of the number of occurrences of the pattern per blob (separated by |).
Additionally, the final entry should be the summation of all the occurrences (also separated by |).
 */
package MSOA;

public class PatternMatching {

    public String patterMatching(String input){
        if(input == null || input.length() == 0) return "";
        String[] inputs = input.split(";");
        String pattern = inputs[0];
        String[] blobs = inputs[1].split("\\|");
        StringBuilder sb = new StringBuilder();
        int res = 0;
        for(String blob : blobs){
            int count = 0;
            if(pattern != null && pattern.length() > 0){
                count += helper(pattern, blob);
            }
            res += count;
            sb.append(count).append("|");
        }

        sb.append(res);
        return sb.toString();
    }

    public int helper(String pattern, String blob){
        int count = 0, index = 0;
        while(index != -1){
            index = blob.indexOf(pattern, index);
            if(index != -1){
                index += pattern.length();
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PatternMatching s = new PatternMatching();
        System.out.println(s.patterMatching("bc;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32"));
        System.out.println(s.patterMatching("b;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32"));
        System.out.println(s.patterMatching(";bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32"));
    }
}
