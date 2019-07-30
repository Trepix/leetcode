import scala.annotation.tailrec

object Solution {
  def lengthOfLongestSubstring(s: String): Int = {
      lengthOfLongestSubstring(0, s, 0, Map(), 0)
  }
  @tailrec
  private def lengthOfLongestSubstring(startIndex:Int, remaining: String, lastIndex: Int, positions: Map[Char, Int], longestSequence: Int): Int = {
    if (remaining.length == lastIndex) Math.max(longestSequence, lastIndex - startIndex)
    else {
      val char = remaining.charAt(lastIndex)

      if (positions.contains(char)) {
        if (positions(char) >= startIndex) lengthOfLongestSubstring(positions(char) + 1, remaining, lastIndex + 1, positions + (char -> lastIndex) , Math.max(longestSequence, lastIndex - startIndex))
        else lengthOfLongestSubstring(startIndex, remaining, lastIndex + 1, positions + (char -> lastIndex), longestSequence)
      }
      else {
        lengthOfLongestSubstring(startIndex, remaining, lastIndex + 1, positions + (char -> lastIndex), longestSequence)
      }
    }
  }
}