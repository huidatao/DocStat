

object charStat extends App{
  import scala.io.Source
  import scala.collection.mutable.LinkedHashMap
  val source = Source.fromFile("resource/a.txt")
  val hm = LinkedHashMap[Char,Int]()       
  val iter = source.buffered
  
  val fileString = source.mkString.replaceAll("\n", " ");
  val tokens = fileString.split(" ")
        .map (_.trim())
        .map(_.toLowerCase())
        .map(word => word.filter(Character.isLetter(_)))
        .sorted
  
  var str = tokens(0)
  for(i <- 0 to tokens.length -1){
    str = str + tokens(i)

  }
  
  val charArray = str.toList
  val sortedArray = charArray.sorted
  for(i <- 0 to sortedArray.length - 1){
    val char = sortedArray(i)
     if(!hm.contains(char)) {hm.put(char, 1)}
    else {
      var temp = hm(char)
      temp = temp + 1
      hm.put(char, temp)
    }
  }

  
  //Tranverse the hashmap and output caculated result
  val mapIter = hm.iterator
  while(mapIter.hasNext){
    print(mapIter.next)
  }
}