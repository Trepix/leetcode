class Solution {       
    
    private int wsize;

    private int solutionSize;

    static class Words {
        private final Map<String, Integer> words;
        private int wordsCount = 0;
        boolean overUsedWord = false;

        private Words(Map<String, Integer> words, int wordsCount) {
            this.words = words;
            this.wordsCount = wordsCount;
        }

        Words(String[] words) {
            this.words = new HashMap<>();
            for (String word : words) {
                increment(word);
            }
        }

        public boolean contains(String word) {
            return words.containsKey(word);
        }

        private void increment(String word) {
            int count = words.getOrDefault(word, 0);
            words.put(word, ++count);
            ++wordsCount;
            if (count == 0) overUsedWord = false;
        }

        private void decrement(String word) {
            int count = words.get(word);
            words.put(word, --count);
            --wordsCount;
            if (count < 0) overUsedWord = true;
        }


        public Words clone() {
            return new Words(new HashMap<>(words), wordsCount);
        }

        private boolean existOverUsedWord() {
            return overUsedWord;
        }

        public boolean areAllUsed() {
            return wordsCount == 0 && !overUsedWord;
        }
    }



    public List<Integer> findSubstring(String text, String[] w) {
        wsize = w[0].length();
        solutionSize = wsize * w.length;

        Words words = new Words(w);
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < wsize; i++) {
            positions.addAll(windowIteration(i, text, words));
        }
        return positions;
    }

    public List<Integer> windowIteration(int left, String text, Words originalWords) {
        Words words = originalWords.clone();
        ArrayList<Integer> positions = new ArrayList<>();

        for (int right = left; right <= text.length() - wsize; right += wsize) {
            String word = text.substring(right, right + wsize);
            if (!words.contains(word)) {
                words = originalWords.clone();
                left = right + wsize;
            } else {
                while (right - left == solutionSize || words.existOverUsedWord()) {
                    String leftWord = text.substring(left, left + wsize);
                    words.increment(leftWord);
                    left += wsize;
                }
                words.decrement(word);
                if (words.areAllUsed()) positions.add(left);
            }
        }
        return positions;
    }

}