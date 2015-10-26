

object WordStat extends App{
  import scala.io.Source
  import scala.collection.mutable.LinkedHashMap
  val source = Source.fromFile("resource/a.txt")
  val hm = LinkedHashMap[String,Int]()
  
//filter non-character symbols
  val fileString = source.mkString.replaceAll("\n", " ");
  val tokens = fileString.split(" ")
        .map (_.trim())
        .map(_.toLowerCase())
        .map(word => word.filter(Character.isLetter(_)))
        .sorted

  for (i <- 0 to tokens.length - 1) {
    val str = tokens(i)
    if (str.length() != 0) {
      if (!hm.contains(str)) {
        hm.put(str,1)
      } else {
        var temp = hm(str)
        temp += 1
        hm.put(str, temp)
      }
    }
  }
  val mapIter = hm.iterator
  while(mapIter.hasNext){
    println(mapIter.next)
  }
}