insert into users (id) values (1);

-- Latest 20
select trx.id, trx.name, trx.description, trx.amount, trx.attachment from trx join pocket p on trx.pocket_id = p.id where p.wallet_id = 5 limit 20;


-- Total
select sum(trx.amount) from trx join pocket p on trx.pocket_id = p.id where p.wallet_id = 5;
-- Income
select sum(trx.amount) from trx join pocket p on trx.pocket_id = p.id where p.wallet_id = 5 and trx.amount > 0;
-- Expense
select sum(trx.amount) from trx join pocket p on trx.pocket_id = p.id where p.wallet_id = 5 and trx.amount < 0;
-- Num of pockets
select count(wallet_id) from pocket where wallet_id = 3;

-- Into one
SELECT
    (SELECT SUM(trx.amount)
     FROM trx
              JOIN pocket p ON trx.pocket_id = p.id
     WHERE p.wallet_id = 5) AS Total,

    (SELECT SUM(trx.amount)
     FROM trx
              JOIN pocket p ON trx.pocket_id = p.id
     WHERE p.wallet_id = 5 AND trx.amount > 0) AS Income,

    (SELECT SUM(trx.amount)
     FROM trx
              JOIN pocket p ON trx.pocket_id = p.id
     WHERE p.wallet_id = 5 AND trx.amount < 0) AS Expense,

    (SELECT COUNT(wallet_id)
     FROM pocket
     WHERE wallet_id = 5) AS NumOfPockets;

