from box import Box

movie_data = {
  "movies": {
    "Spaceballs": {
      "imdb stars": 7.1,
      "rating": "PG",
      "length": 96,
      "director": "Mel Brooks",
      "stars": [{"name": "Mel Brooks", "imdb": "nm0000316", "role": "President Skroob"},
                {"name": "John Candy","imdb": "nm0001006", "role": "Barf"},
                {"name": "Rick Moranis", "imdb": "nm0001548", "role": "Dark Helmet"}
      ]
    },
    "Robin Hood: Men in Tights": {
      "imdb stars": 6.7,
      "rating": "PG-13",
      "length": 104,
      "director": "Mel Brooks",
      "stars": [
                {"name": "Cary Elwes", "imdb": "nm0000144", "role": "Robin Hood"},
                {"name": "Richard Lewis", "imdb": "nm0507659", "role": "Prince John"},
                {"name": "Roger Rees", "imdb": "nm0715953", "role": "Sheriff of Rottingham"},
                {"name": "Amy Yasbeck", "imdb": "nm0001865", "role": "Marian"}
      ]
    }
  }
}

movie_box = Box(movie_data)

print movie_box.movies.Robin_Hood_Men_in_Tights.imdb_stars
# 6.7

print movie_box.movies.Spaceballs.stars[0].name
# 'Mel Brooks'

# All new dict and lists added to a Box or BoxList object are converted
movie_box.movies.Spaceballs.stars.append({"name": "Bill Pullman", "imdb": "nm0000597", "role": "Lone Starr"})
print movie_box.movies.Spaceballs.stars[-1].role
# 'Lone Starr'
