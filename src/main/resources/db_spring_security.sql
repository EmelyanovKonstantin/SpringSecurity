-- Table users
CREATE TABLE  users (
   id INT NOT  NULL   IDENTITY(1,1) PRIMARY  KEY,
   username VARCHAR (255) NOT NULL,
   password VARCHAR (255) NOT NULL
)

-- Table role
CREATE  TABLE  roles (
    id INT NOT NULL  IDENTITY(1,1) PRIMARY  KEY,
    name VARCHAR (100) NOT NULL
)

-- Table mapping
CREATE  TABLE  user_roles(
    user_id INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES  users (id),
    FOREIGN KEY (role_id) REFERENCES  roles (id),

    UNIQUE (user_id, role_id)
)

-- Insert data

INSERT INTO users (username, password) VALUES ('root', 'root' );
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT  INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT  INTO user_roles VALUES (1,2);

