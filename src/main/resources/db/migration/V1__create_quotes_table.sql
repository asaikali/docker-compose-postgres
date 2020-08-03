CREATE TABLE quotes
(
    id     INTEGER PRIMARY KEY,
    quote  VARCHAR(1024),
    author VARCHAR(256)
);

INSERT INTO quotes (id, quote, author)
VALUES (1, 'Never, never, never give up', 'Winston Churchill');

INSERT INTO quotes (id, quote, author)
VALUES (2, 'While there''s life, there''s hope', 'Marcus Tullius Cicero');

INSERT INTO quotes (id, quote, author)
VALUES (3, 'Failure is success in progress', 'Anonymous');

INSERT INTO quotes (id, quote, author)
VALUES (4, 'Success demands singleness of purpose', 'Vincent Lombardi');

INSERT INTO quotes (id, quote, author)
VALUES (5, 'The shortest answer is doing', 'Lord Herbert');
