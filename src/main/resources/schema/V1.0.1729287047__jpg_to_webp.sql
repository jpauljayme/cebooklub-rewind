UPDATE tbl_book
SET image_path = REGEXP_REPLACE(image_path, '\.jpg$', '.webp', 'g')
WHERE image_path LIKE '%.jpg';