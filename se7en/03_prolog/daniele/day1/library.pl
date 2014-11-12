% Books in the library. Can be extended with other details
book(readyPlayerOne).
book(it).
book(theDarkTower).
book(salemsLot).
book(cleanCode).
book(cleanCoder).

% Authors of the books. Can be extended with other details
author(ernestCline).
author(stephenKing).
author(uncleBob).

% Association between authors and books
wrote(ernestCline, readyPlayerOne).
wrote(stephenKing, it).
wrote(stephenKing, theDarkTower).
wrote(stephenKing, salemsLot).
wrote(uncleBob, cleanCode).
wrote(uncleBob, cleanCoder).

% Find all the books written by an author
wrote(stephenKing, Book).
