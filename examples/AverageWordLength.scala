// Example: Use accumulators to calculate the average length of all words in a data set

val myfile = "file:/sparkdev/data/frostroad.txt"

val totalWords = sc.accumulator(0)
val totalLetters = sc.accumulator(0.0)

val words = sc.textFile(myfile).flatMap(_.split("\\W"))
words.foreach(word => {
   totalWords += 1
   totalLetters += word.length
})
  
println( "Average word length: " + totalLetters.value/totalWords.value)
