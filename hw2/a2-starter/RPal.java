import java.util.*;

public class RPal {
    // store all the known answers, so we don't have to compute them again
    private Map<Integer, List<List<Integer>>> storageAllRPals;

    // a constructor: creates the above storage and puts in answers
    // for our base cases of n = 0 and n = 1.
    public RPal() {
        storageAllRPals = new HashMap<>();
        storageAllRPals.put(0, Arrays.asList(Arrays.asList()));
        storageAllRPals.put(1, Arrays.asList(Arrays.asList(1)));
    }

    // Specification: return a list of integer lists of all recursively
    // palindromic sequences that sum to n.
    //
    // NOTE: When you implement this and want recursively-palindromic
    // sequences of k < n, you should not call yourself. Instead, you
    // will call allRPals(k). The difference is that computeAllRPals
    // will compute the sequences every time whereas allRPals will *not*
    // compute the answer again unless it hasn't been computed before.
    private List<List<Integer>> computeAllRPals(int n) {
        List<List<Integer>> result = new ArrayList<>();

        int half = n / 2;
        List<List<Integer>> halfRPals = allRPals(half);

        for (List<Integer> seq : halfRPals) {
            List<Integer> newSeq = new ArrayList<>(seq);

            if (n % 2 == 1) {
                newSeq.add(1); // middle element for odd n
            }

            // add reverse of seq
            for (int i = seq.size() - 1; i >= 0; i--) {
                newSeq.add(seq.get(i));
            }

            result.add(newSeq);
        }

        return result;
    }

    public List<List<Integer>> allRPals(int n) {
        List<List<Integer>> answer = storageAllRPals.get(n);
        if (answer == null) {
            answer = computeAllRPals(n);
            storageAllRPals.put(n, answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        RPal rPal = new RPal();

        System.out.println(rPal.allRPals(7));
    }
}
