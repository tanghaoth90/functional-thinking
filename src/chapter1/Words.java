package chapter1;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Words {
    private Set<String> NON_WORDS = new HashSet<>() {{
        add("the"); add("and"); add("of"); add("to"); add("a");
        add("i"); add("it"); add("in"); add("or"); add("is");
        add("d"); add("s"); add("as"); add("so"); add("but");
        add("be");
    }};

    private Map<String, Integer> wordFreq(String words) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        Matcher m = Pattern.compile("\\w+").matcher(words);
        while (m.find()) {
            String word = m.group().toLowerCase();
            if (! NON_WORDS.contains(word)) {
                wordMap.merge(word, 1, Integer::sum);
            }
        }
        return wordMap;
    }

    public static void main(String[] args) {
        String text = "Friends, delegates, and distinguished guests: I stand before you tonight honored by your support; proud of the extraordinary progress we have made together over the last four years; and brimming with confidence in the bright future we will build for America over the NEXT four years!";
        Map<String, Integer> wordFreq = new Words().wordFreq(text);
        for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
