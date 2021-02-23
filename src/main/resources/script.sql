CREATE TABLE IF NOT EXISTS users (
  user_name VARCHAR(255) NULL,
  login VARCHAR(255) NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS books_list (
  book_name VARCHAR(255) NOT NULL PRIMARY KEY ,
  author VARCHAR(255) NULL,
  is_occupied boolean null,
  return_date VARCHAR(255) null,
  ownerName VARCHAR(255) NULL
  );

CREATE TABLE IF NOT EXISTS authorized_data (
  login VARCHAR(255) PRIMARY KEY references users(login) ,
  password VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS books_genres_lib (
  book_name VARCHAR(255) REFERENCES books_list(book_name),
  genre VARCHAR(255) not null
);