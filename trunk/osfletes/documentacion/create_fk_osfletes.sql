ALTER TABLE direccion
ADD FOREIGN KEY (owner) REFERENCES anunciomultiplelocalizado(id);

ALTER TABLE anunciomultiplelocalizado
ADD FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE role
ADD FOREIGN KEY (user_id) REFERENCES users(id);