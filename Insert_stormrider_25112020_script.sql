use stormrider_25112020;

DELETE FROM subcategory WHERE sub_category_id < 10;
INSERT INTO subcategory VALUES
(1),
(2),
(3); 

DELETE FROM category WHERE category_id < 10;
INSERT INTO category VALUES
(1),
(2),
(3);

/*
DELETE FROM app_language WHERE code = 'EN';
DELETE FROM app_language WHERE code = 'IS';
INSERT INTO app_language VALUES 
-- code , language
('EN', 'English'),
('IS', 'Icelandic');
*/

DELETE FROM variable_type WHERE variable_type_id < 10;
INSERT INTO variable_type VALUES
-- id , var_lang_id
(1),
(2), 
(3), 
(4); 

DELETE FROM variable WHERE variable_id < 20;
INSERT INTO variable VALUES 
-- id , type_id
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 2),
(6, 2),
(7, 2),
(8, 2),
(9, 3),
(10, 4);

-- -------------------------------------------------- FOREIGN KEY CHECKS - SET TO 0
SET FOREIGN_KEY_CHECKS=0; -- to disable them
DELETE FROM variable_type_language WHERE variable_type_language_id < 20;
INSERT INTO variable_type_language VALUES 
-- id , code , name , comment - var_type_id
(1, 'EN', 	'var_type1_name_english',   	'var_type1_comment_english', 	1),
(2, 'IS', 	'var_type1_name_icelandic', 	'var_type1_comment_icelandic', 	1),
(3, 'EN', 	'var_type2_name_english',   	'var_type2_comment_english', 	2),
(4, 'IS', 	'var_type2_name_icelandic', 	'var_type2_comment_icelandic', 	2),
(5, 'IS', 	'var_type3_name_icelandic', 	'var_type3_comment_icelandic', 	3),
(6, 'IS', 	'var_type4_name_icelandic', 	'var_type4_comment_icelandic', 	4);
/*
(7, 'IS', 	'var_type5_name_icelandic', 	'var_type5_comment_icelandic', 	5),
(8, 'IS', 	'var_type6_name_icelandic', 	'var_type6_comment_icelandic', 	6),
(9, 'IS', 	'var_type7_name_icelandic', 	'var_type7_comment_icelandic', 	7),
(10, 'IS', 	'var_type8_name_icelandic', 	'var_type8_comment_icelandic', 	8),
(10, 'IS', 	'var_type9_name_icelandic', 	'var_type9_comment_icelandic', 	9),
(10, 'IS', 	'var_type10_name_icelandic', 	'var_type10_comment_icelandic', 10);
*/

DELETE FROM product_variable_language WHERE product_variable_language_id < 20;
INSERT INTO product_variable_language VALUES 
-- id , code , name , comment - var_id
(1, 'EN', 'product_variable_name1', 'product_variable_comment1', 1),
(2, 'EN', 'product_variable_name2', 'product_variable_comment2', 2),
(3, 'EN', 'product_variable_name3', 'product_variable_comment3', 3),
(4, 'EN', 'product_variable_name4', 'product_variable_comment4', 4),
(5, 'EN', 'product_variable_name5', 'product_variable_comment5', 5),
(6, 'EN', 'product_variable_name6', 'product_variable_comment6', 6),
(7, 'EN', 'product_variable_name7', 'product_variable_comment7', 7),
(8, 'EN', 'product_variable_name8', 'product_variable_comment8', 8),
(9, 'EN', 'product_variable_name9', 'product_variable_comment9', 9),
(10, 'EN', 'product_variable_name10', 'product_variable_comment10', 10);
/*
(1, 'EN', 'product_variable_name10', 'product_variable_comment1', 1),
(1, 'EN', 'product_variable_name11', 'product_variable_comment1', 1),
(1, 'EN', 'product_variable_name12', 'product_variable_comment1', 1),
(1, 'EN', 'product_variable_name13', 'product_variable_comment1', 1),
(1, 'EN', 'product_variable_name14', 'product_variable_comment1', 1),
(1, 'EN', 'product_variable_name15', 'product_variable_comment1', 1);
*/


DELETE FROM product WHERE product_id < 20;
INSERT INTO product VALUES
-- id , inventory, p_group , lastupdated
(1, 5, 1, '2020-10-11'),
(2, 5, 1, '2020-10-11'),
(3, 5, 1, '2020-10-11'),
(4, 5, 1, '2020-10-11'),
(5, 10, 2, '2020-10-13'),
(6, 10, 2, '2020-10-13'),
(7, 10, 2, '2020-10-13'),
(8, 100, 2, '2020-12-12'),
(9, 12, 2, '2020-01-13'),
(10, 1, 2, '2020-02-13');


DELETE FROM product_has_variable WHERE product_has_variable_id < 10;
INSERT INTO product_has_variable VALUES
-- id , product_id , variable_id
(1, 1, 1),
(2, 1, 2),
(3, 2, 3),
(4, 2, 4),
(5, 3, 5),
(6, 3, 6),
(7, 4, 7),
(8, 4, 8),
(9, 5, 9),
(10, 5, 10),
(11, 6, 1),
(12, 6, 2),
(13, 17, 3),
(14, 18, 4);




DELETE FROM product_group WHERE product_group_id < 10;
INSERT INTO product_group VALUES
(1, 2000, 400),
(2, 4000, 800);
SET FOREIGN_KEY_CHECKS=1; -- to re-enable them
-- -------------------------------------------------- FOREIGN KEY CHECKS - SET TO 1


DELETE FROM product_image WHERE product_image_id < 10;
INSERT INTO product_image VALUES
(1, 1, 'http//PathToImageIsHereA1', 'nameOfImage1'),
(2, 1, 'http//PathToImageIsHereA2', 'nameOfImage2'),
(3, 1, 'http//PathToImageIsHereA3', 'nameOfImage3'),
(4, 1, 'http//PathToImageIsHereA4', 'nameOfImage4'),
(5, 2, 'http//PathToImageIsHereB1', 'nameOfImage5'),
(6, 2, 'http//PathToImageIsHereB2', 'nameOfImage6');
