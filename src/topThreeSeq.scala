

object topThreeSeq extends App{
  import scala.io.Source
  import scala.collection.mutable.LinkedHashMap
  val source = Source.fromFile("resource/doc.txt")
  val hm = LinkedHashMap[String,Int]()
  
  //过滤，删去file中的符号
  val fileString = source.mkString.replaceAll("\n", " ");
  val tokens = fileString.split(" ")
        .map (_.trim())
        .map(_.toLowerCase())
        .map(word => word.filter(Character.isLetter(_)))
        
  for (i <- 1 to tokens.length - 3) {
    var str = tokens(i)
    var j = i + 1
    var count = 1
    while (count < 3 && j < tokens.length - 1) {
      if (tokens(j).length() != 0) {
        str = str + " " + tokens(j + 1)
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
  
  val mapIter = hm.iterator
  while(mapIter.hasNext){
    println(mapIter.next)
  }
  
}