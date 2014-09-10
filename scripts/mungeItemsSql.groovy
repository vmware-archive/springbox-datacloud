def idCounter = 1000

new File('u.item').eachLine { line ->
 def tokens = line.tokenize('|')
 
 print("insert into movies(id,title,ml_id,number_in_stock) values (${idCounter},")

 print("'${tokens[1].replaceAll(/'/,"''")}',")
 print("'${tokens[0]}',")
 println("10);")

 (5..tokens.size()-1).each { index ->
  if (tokens[index] == "1") {
    def genreId = 1000+index-4
    println("insert into movies_genres(movie_id, genre_id) values (${idCounter},${genreId});")
  }
 }

 idCounter++

 }

