DROP TABLE items;

CREATE TABLE IF NOT EXISTS items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idUser INT,
    titulo VARCHAR(255) NOT NULL,
    description TEXT,
    puntuacion INT NOT NULL,
    favoritos BOOLEAN,
    imagen_doc VARCHAR(200),
    imagen_per VARCHAR(200),
    categoria VARCHAR(100) NOT NULL,
    onCreated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    onUpdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
