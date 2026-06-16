ALTER TABLE users
    RENAME COLUMN datacriacao TO data_criacao;

ALTER TABLE users
    ALTER COLUMN data_criacao
        SET DEFAULT CURRENT_TIMESTAMP;