CREATE USER 'springuser'@'localhost' identified by 'ThePassword';

GRANT ALL ON MarketPlaceDB.* TO 'springuser'@'localhost';

CREATE USER 'parsers'@'localhost' identified by 'ThePassword';

GRANT ALL ON MarketPlaceDB.* TO 'parsers'@'localhost';


