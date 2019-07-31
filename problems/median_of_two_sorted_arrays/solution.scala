object Solution {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    val a = (nums1 ++ nums2).sorted
    val n = a.length

    n match {
      case 1 => a(0)
      case _ =>
        if(n%2 == 0) {
          val mid = n / 2
          (a(mid) + a(mid - 1)) / 2.0
        }
        else
          a(n/2)
    }
  }
}