DELIMITER ;;
CREATE PROCEDURE book_init()

BEGIN
    DECLARE i INT DEFAULT 0;
    WHILE i < 4000
        DO
            insert book (f_title, f_background_img, f_big_text, f_genre, f_date_lock)
                value (CONCAT('Title', uuid_short()), 'book.jpeg', repeat('bigText ss ', 10000), 'DOCUMENTARY', default);
            SET i = i + 1;
END WHILE;
END;;
DELIMITER ;

CREATE PROCEDURE user_init()
BEGIN
    DECLARE i INT DEFAULT 0;
    WHILE i < 1000
        DO
            insert users (f_active, f_age, f_email, f_filename, f_info, f_password, f_role, f_sex, f_telegram,
                          f_username, f_date_lock)
                value (true, (FLOOR(RAND() * (30 - 20 + 1)) + 20), CONCAT('user', uuid_short(), '@mail.ru'),
                       'user.jpeg', REPEAT('Info__', 30), 'QWDSDjkdsfj32asd3', 'USER', 'MAN', default,
                       CONCAT('user', uuid_short()), default);
            SET i = i + 1;
END WHILE;
END;;
DELIMITER ;

CREATE PROCEDURE comment_init()
BEGIN
    DECLARE i INT DEFAULT 10;
    WHILE i < 1000
        DO
            insert comment (f_color, f_text, fk_book_id, fk_user_id)
                value ('RED', REPEAT('comment_txt', 40), i, i);
            SET i = i + 1;
END WHILE;
END;;
DELIMITER ;

CREATE PROCEDURE user_book_added_init()
BEGIN
    DECLARE i INT DEFAULT 10;
    WHILE i < 1000
        DO
            insert users_book_added values (i, i), (i, (i + 1));
            SET i = i + 1;
END WHILE;
END;;
DELIMITER ;

CREATE PROCEDURE user_book_favorite_init()
BEGIN
    DECLARE i INT DEFAULT 10;
    WHILE i < 1000
        DO
            insert user_book_favorite values (i, i), (i, (i + 1));
            SET i = i + 1;
END WHILE;
END;;
DELIMITER ;

CALL book_init();
CALL user_init();
CALL user_book_added_init();
CALL user_book_favorite_init();
CALL comment_init();