

object topThreeSeq extends App{
  import scala.io.Source
  import scala.collection.mutable.LinkedHashMap
  import scala.collection.mutable.HashMap
  val source = Source.fromFile("resource/doc.txt")
  val hm = LinkedHashMap[String,Int]()
  
  //过滤，删去file中的符号
  val fileString = source.mkString.replaceAll("\n", " ");
  val tokens = fileString.split(" ")
        .map (_.trim())
        .map(_.toLowerCase())
        .map(word => word.filter(Character.isLetter(_)))

  for (i <- 0 to tokens.length - 3) {
    if (tokens(i).length() != 0) {
      var str = tokens(i)
      var j = i + 1
      var count = 1
      while (count < 3 && j < tokens.length - 1) {
        if (tokens(j).length() != 0) {
          str = str + " " + tokens(j)
          count = count + 1
          j = j + 1
        } else {
          j = j + 1
        }
      }
      if (!hm.contains(str)) {
        hm.put(str, 1)
      } else {
        var temp = hm(str)
        temp += 1
        hm.put(str, temp)
      }
    }
  }
  val newhm = LinkedHashMap.empty ++ hm.toIndexedSeq.sortBy(kv => (-kv._2, kv._1))
  
  val mapIter = newhm.iterator
  var topthree = 0
  while(mapIter.hasNext && topthree < 3){
    println(mapIter.next)
    topthree += 1
  }
  
}