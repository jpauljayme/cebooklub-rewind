CREATE TABLE IF NOT EXISTS tbl_book(
    id                  INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    title               VARCHAR(100) NOT NULL,
    author              VARCHAR(40) NOT NULL,
    body                TEXT NOT NULL,
    image_path          VARCHAR(150),
    date_read           DATE NOT NULL,
    t_date_created        DATE NOT NULL,
    t_date_updated        DATE NOT NULL
);