CREATE TABLE `authors`(
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `SURNAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `publishers` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `books` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(150) DEFAULT NULL,
  `YEAR` int(4) DEFAULT NULL,
  `PUBLISHERID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `books_publishers_ID_fk` (`PUBLISHERID`),
  CONSTRAINT `books_publishers_ID_fk` FOREIGN KEY (`PUBLISHERID`) REFERENCES `publishers` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `genre` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `book_author` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `BOOKID` int(10) unsigned NOT NULL,
  `AUTHORID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `book_author_authors_ID_fk` (`AUTHORID`),
  KEY `book_author_books_ID_fk` (`BOOKID`),
  CONSTRAINT `book_author_authors_ID_fk` FOREIGN KEY (`AUTHORID`) REFERENCES `authors` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `book_author_books_ID_fk` FOREIGN KEY (`BOOKID`) REFERENCES `books` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `book_genre` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `GENREID` int(10) unsigned NOT NULL,
  `BOOKID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `book_genre_genre_ID_fk` (`GENREID`),
  KEY `book_genre_books_ID_fk` (`BOOKID`),
  CONSTRAINT `book_genre_books_ID_fk` FOREIGN KEY (`BOOKID`) REFERENCES `books` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `book_genre_genre_ID_fk` FOREIGN KEY (`GENREID`) REFERENCES `genre` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8
