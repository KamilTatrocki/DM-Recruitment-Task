
INSERT INTO categories (name) VALUES
                                  ('Pielęgnacja włosów'),
                                  ('Pielęgnacja twarzy'),
                                  ('Makijaż'),
                                  ('Higiena jamy ustnej'),
                                  ('Pielęgnacja ciała'),
                                  ('Perfumy i zapachy');


INSERT INTO products (name_product, category_id) VALUES
                                                     ('Szampon Pantene',               1),
                                                     ('Odżywka Garnier',               1),
                                                     ('Maska',                         1),
                                                     ('Krem',                          2),
                                                     ('Płyn micelarny',                2),
                                                     ('Serum L’Oréal',                 2),
                                                     ('Podkład',                       3),
                                                     ('Mascara',                       3),
                                                     ('Pomadka',                       3),
                                                     ('Pasta Colgate',                 4),
                                                     ('Szczoteczka Oral-B',            4),
                                                     ('Nitka Dentystyczna',            4),
                                                     ('Balsam',                        5),
                                                     ('Żel pod prysznic Dove',         5),
                                                     ('Szampon do włosów',             5),
                                                     ('Perfumy Calvin Klein Euphoria', 6),
                                                     ('Woda toaletowa Adidas Fruity',  6),
                                                     ('Perfumy Chanel',                6);


INSERT INTO shelves (description) VALUES
                                      ('Półka A1'),
                                      ('Półka A2'),
                                      ('Półka B1'),
                                      ('Półka B2');


INSERT INTO items (expiration_date, product_id) VALUES
                                                    ('2024-06-10', 1),
                                                    ('2024-06-20', 2),
                                                    ('2024-07-05', 3),
                                                    ('2025-07-15', 4),
                                                    ('2025-08-01', 5),
                                                    ('2025-05-20', 6),
                                                    ('2025-05-10', 7),
                                                    ('2025-05-25', 8),
                                                    ('2025-05-05', 9),
                                                    ('2025-05-20',10),
                                                    ('2025-11-15',11),
                                                    ('2025-11-30',12),
                                                    ('2025-12-15',13),
                                                    ('2026-01-10',14),
                                                    ('2026-02-15',15);


INSERT INTO location_of_items (ITEM_ID, SHELF_ID) VALUES
                                                      (1, 1),  (2, 2),  (3, 3),  (4, 4),
                                                      (5, 1),  (6, 2),  (7, 3),  (8, 4),
                                                      (9, 1), (10, 2), (11, 3), (12, 4),
                                                      (13, 1), (14, 2), (15, 3);


INSERT INTO users (username, password, is_admin) VALUES
                                                     ('admin', 'admin', TRUE),
                                                     ('user1', 'user1', FALSE),
                                                     ('user2', 'user2', FALSE);


INSERT INTO tasks (description, shelf_from_id, shelf_to_id, product_id) VALUES
                                                                            ('Przenieś Szampon Pantene z Półka A1 do Półka B2', 1, 4, 1),
                                                                            ('Przenieś Krem z Półka B1 do Półka A2',           3, 2, 4),
                                                                            ('Przenieś Pasta Colgate z Półka A2 do Półka B1',   2, 3,10),
                                                                            ('Przenieś Odżywka Garnier z Półka A2 do Półka B2', 2, 4, 2),
                                                                            ('Przenieś Maska z Półka B1 do Półka A1',           3, 1, 3),
                                                                            ('Przenieś Serum L’Oréal z Półka B2 do Półka A2',   4, 2, 6),
                                                                            ('Przenieś Mascara z Półka B2 do Półka A1',         4, 1, 8),
                                                                            ('Przenieś Pomadka z Półka A1 do Półka B1',         1, 3, 9),
                                                                            ('Przenieś Nitka z Półka B1 do Półka A2', 3, 2,12),
                                                                            ('Przenieś Balsam z Półka A1 do Półka B2',          1, 4,13),
                                                                            ('Przenieś Żel z Półka A2 do Półka B1', 2, 3,14),
                                                                            ('Przenieś Woda Półka B2 do Półka A2', 4, 2,17),
                                                                            ('UNIKATOWE KTÓRE NIKT NIE MA (test assgning to user)', 2, 3,14);


INSERT INTO assigned_task (IDTASK, IDUSER, ISDONE) VALUES
                                                          (1, 2, FALSE),
                                                          (2, 3, FALSE),
                                                          (3, 2, FALSE),
                                                          (4, 2, FALSE),
                                                          (5, 3, FALSE),
                                                          (6, 2, FALSE),
                                                          (7, 3, FALSE),
                                                          (8, 2, FALSE),
                                                          (9, 3, FALSE),
                                                          (10, 2, FALSE),
                                                          (11, 3, FALSE),
                                                          (12, 2, FALSE),
                                                          (11, 3, FALSE);
