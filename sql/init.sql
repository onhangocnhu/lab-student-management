CREATE TABLE students (id varchar(255) not null, age integer not null, email varchar(255), name varchar(255), primary key (id));

INSERT INTO students (id, name, email, age) VALUES 
    ('1', 'Nguyen Van A', 'vana@example.com', 20),
    ('2', 'Tran Thi B', 'thib@example.com', 21),
    ('3', 'Le Van C', 'vanc@example.com', 22),
    ('4', 'Pham Thi D', 'thid@example.com', 19),
    ('5', 'Hoang Van E', 'vane@example.com', 23),
    ('6', 'Ngo Thi F', 'thif@example.com', 20),
    ('7', 'Vu Van G', 'vang@example.com', 21),
    ('8', 'Do Thi H', 'thih@example.com', 22),
    ('9', 'Bui Van I', 'vani@example.com', 18),
    ('10', 'Dang Thi K', 'thik@example.com', 24),
    ('11', 'Trinh Van L', 'vanl@example.com', 20),
    ('12', 'Mai Thi M', 'thim@example.com', 21)
ON CONFLICT (id) DO NOTHING;
