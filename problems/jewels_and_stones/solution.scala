object Solution {
    def numJewelsInStones(J: String, S: String): Int = {
        var count:Int = 0
        for(character <- S){
            if(J.indexOf(character) >= 0) count +=1
        }
        count
    }
}