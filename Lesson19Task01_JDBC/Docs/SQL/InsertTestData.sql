
--- INSERT Test DATA To Tables DB Shop ----

INSERT INTO public."Users" 
VALUES 
(DEFAULT, 'EVG','e2e4','3412', 1),
(DEFAULT, 'Alex','bestormozov','8909',2),
(DEFAULT, 'Sergey','serg','50505',2),
(DEFAULT, 'Tom','ttt','12345',3),
(DEFAULT, 'Petr','trash','54321',4)
;


INSERT INTO public."Product" 
VALUES 
(DEFAULT, 'Compute',50000,'Personal compute FULL SET 2020 year'),
(DEFAULT, 'Acustic',10000,'Acustic universal microlab solo2'),
(DEFAULT, 'HDD',5000,'Westen Digital'),
(DEFAULT, 'CPU',22000,'INTEL PENTIUM Core I5 '),
(DEFAULT, 'VideoCard',41000,'Nvidia GTX 3060')
;


INSERT INTO public."Orders" 
VALUES 
(DEFAULT, 1, 0, 10000, 1 ),
(DEFAULT, 2, 1, 5000, 0 ),
(DEFAULT, 3, 0, 50000, 1 )
;


