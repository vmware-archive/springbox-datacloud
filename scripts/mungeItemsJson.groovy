mapping = [:]

new File('genres.mongo2').eachLine { line ->
  def tokens = line.tokenize(',')
  mapping[tokens[1]] = tokens[0]
}

print ("[")

def movies = new StringBuilder()

new File('u.item').eachLine { line ->
 
 movies << "{"
 
 def tokens = line.tokenize('|')

 movies << '"mlId":'
 movies << tokens[0]
 movies << ','

 movies << '"title":"'
 movies << tokens[1]
 movies << '",'

def genres = new StringBuilder()

movies << '"genres":['
//{ "$oid": "<id>" }

 (5..tokens.size()-1).each { index ->
  if (tokens[index] == "1") {
    genres << '{"$ref":"genre","$id":{"$oid":"'
    genres << mapping[(index-5).toString()]
    genres << '"}},'
  }
 }

 movies << genres.toString().substring(0,genres.size()-1)

 movies << "],"
 movies << '"class":"'
 movies << "io.pivotal.cf.demo.springbox.models.Movie"
 movies << '"},'


}
 print movies.toString().substring(0,movies.size()-1)
 println ("]")
