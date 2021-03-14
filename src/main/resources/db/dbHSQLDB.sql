DROP TABLE IF EXISTS Client;

CREATE TABLE Client (
    id bigint NOT NULL AUTO_INCREMENT,
    FIO VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(30) NOT NULL,
    numberPassport VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Credit (
   id bigint NOT NULL AUTO_INCREMENT,
   CreditLimit FLOAT NOT NULL,
   InterestRate FLOAT NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE CreditOffer (
   id bigint NOT NULL AUTO_INCREMENT,
   idClient bigint NOT NULL,
   idCredit bigint NOT NULL,
   LoanAmount FLOAT NOT NULL,
   PRIMARY KEY (id),
   FOREIGN KEY (idClient) REFERENCES Client(id),
   FOREIGN KEY (idCredit) REFERENCES Credit(id)
  );

CREATE TABLE PaymentSchedule (
   id bigint NOT NULL AUTO_INCREMENT,
   idCreditOffer bigint NOT NULL,
   PaymentDate DATETIME NOT NULL,
   PaymentAmount FLOAT NOT NULL,
   AmountBody FLOAT NOT NULL,
   AmountPercent FLOAT NOT NULL,
   PRIMARY KEY (id),
   FOREIGN KEY (idCreditOffer) REFERENCES CreditOffer(id)
);

INSERT INTO CLIENT VALUES (1, 'Кириллов Кирилл Кириллович','8900433211', 'example1@gmail.com','1212 244414');
INSERT INTO CLIENT VALUES (2, 'Иванов Иван Иванович','8900435454', 'example2@gmail.com','1452 424578');
INSERT INTO CLIENT VALUES (3, 'Гришко Татьяна Валерьевна','8900433489', 'example3@gmail.com','7755 436576');
INSERT INTO CLIENT VALUES (4, 'Мич Анастасия Олеговна','8900433231', 'exampl4e@gmail.com','4422 554433');
INSERT INTO CLIENT VALUES (5, 'Стич Иван владимирович','8905433211', 'examp5le@gmail.com','9988 121212');
INSERT INTO CLIENT VALUES (6, 'Тестов Тест Тестович','8900788811', 'exampl6e@gmail.com','1258 294856');

INSERT INTO Credit VALUES (1,100000,10.3);
INSERT INTO Credit VALUES (2,150000,19.2);
INSERT INTO Credit VALUES (3,200000,21.3);
INSERT INTO Credit VALUES (4,50000,35.6);
INSERT INTO Credit VALUES (5,450000,12.6);

