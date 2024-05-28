package atlassian;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
 * Output: "ACB"
 * Explanation:
 * Team A was ranked first place by 5 voters. No other team was voted as first place, so team A is the first team.
 * Team B was ranked second by 2 voters and ranked third by 3 voters.
 * Team C was ranked second by 3 voters and ranked third by 2 voters.
 * As most of the voters ranked C second, team C is the second team, and team B is the third.
 */
public class TeamsRakingSystem {
    public String rankTeams(String[] votes) {

        // max three positions
//        for(String vote: votes){
//           for(int i = 0; i< vote.length();i++){
//               Character team = vote.charAt(i);
//               votesByTeam.merge(team, i, Integer::sum);
//             //  votesByTeam.merge(team, i, (a,b) -> a+b);
//           }
//        }

        Map<Character, TeamPosition> votesByTeam1 = new HashMap<>();
        for(String vote: votes){
            int length = vote.length();
            for(int i = 0; i< vote.length();i++){
                Character team = vote.charAt(i);
                TeamPosition currentPosition = votesByTeam1.computeIfAbsent(team, k-> new TeamPosition(team, length));
                currentPosition.add(i);
            }
        }

        return votesByTeam1.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(kv -> String.valueOf(kv.getKey())).collect(Collectors.joining());
    }


    public static class TeamPosition implements Comparable<TeamPosition> {
        Integer[] positions;
        Character team;

        public TeamPosition(Character team, int count) {
            positions = new Integer[count];
            this.team = team;
        }

        public TeamPosition add(int position){
            Integer currentCount = positions[position];
            positions[position] = currentCount == null ? 1 : positions[position]+1;
            return this;
        }


        @Override
        public int compareTo(TeamPosition tp) {
           for(int i = 0; i< positions.length ;i++){
            if(positions[i] == null && tp.positions[i] != null){
                return 1;
            }

           if(positions[i] != null && tp.positions[i] == null){
               return -1;
           }

            if(positions[i] != null && tp.positions[i] != null && positions[i] > tp.positions[i]){
                return -1;
            }

            if(positions[i] != null && tp.positions[i] != null  && positions[i] < tp.positions[i]){
                   return 1;
            }
           }
           return tp.team - team;
        }
    }


    public static void main(String args[]){
        TeamsRakingSystem system = new TeamsRakingSystem();
        String[] votes1 = {"ABC","ACB","ABC","ACB","ACB"};

        String[] votes = {"WXYZ","XYZW"};

        System.out.println(system.rankTeams(votes));

    }
}
