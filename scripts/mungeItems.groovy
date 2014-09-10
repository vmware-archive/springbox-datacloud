mapping = [:]

new File('genres.mongo').eachLine { line ->
  def tokens = line.tokenize(',')
  mapping[tokens[1]] = tokens[0]
}

println("mlId\ttitle\tgenres\tclass")

new File('u.item').eachLine { line ->
 def tokens = line.tokenize('|')

 print("${tokens[0]}\t")
 print("${tokens[1]}\t")
 print("[")

def genres = new StringBuilder()

 (5..tokens.size()-1).each { index ->
  if (tokens[index] == "1") {
    genres << "${mapping[(index-5).toString()]},"
  }
 }

 print genres.toString().substring(0,genres.size()-1)

 print("]")
 print("\tio.pivotal.cf.demo.springbox.models.Movie")

 println()
}
