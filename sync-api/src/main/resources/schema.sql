CREATE TABLE IF NOT EXISTS items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    description TEXT,
    puntuacion INT NOT NULL,
    favoritos BOOLEAN,
    imagen_doc VARCHAR(200),
    imagen_per VARCHAR(200),
    categoria VARCHAR(100) NOT NULL
);
