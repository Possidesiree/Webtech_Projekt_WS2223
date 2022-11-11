CREATE TABLE PERSON
(
    ID      IDENTITY PRIMARY KEY,
    NAME    VARCHAR(255) NOT NULL,
    ADRESSE VARCHAR(255) NOT NULL,
    EMAIL   VARCHAR(255) NOT NULL,
    ROLLE   VARCHAR(255) NOT NULL
);

CREATE TABLE TERMIN
(
    ID             IDENTITY PRIMARY KEY,
    BUCHUNGS_ZEIT  TIMESTAMP,
    LEISTUNG       VARCHAR(255),
    kunden_id      BIGINT,
    mitarbeiter_id BIGINT
);

ALTER TABLE TERMIN
    ADD FOREIGN KEY (kunden_id) REFERENCES PERSON (ID);
ALTER TABLE TERMIN
    ADD FOREIGN KEY (mitarbeiter_id) REFERENCES PERSON (ID);

-- Beispiel Kundendaten
INSERT INTO PERSON (NAME, ADRESSE, EMAIL, ROLLE)
VALUES ('Desiree Possi', 'Sewanstr. 890, 13908 Berlin', 'desipossi@mail.com', 'KUNDE');
INSERT INTO PERSON (NAME, ADRESSE, EMAIL, ROLLE)
VALUES ('Jasmine Rice', 'Coppi. 05, 10365 Berlin', 'jasmine.rice@mail.com', 'KUNDE');
INSERT INTO PERSON (NAME, ADRESSE, EMAIL, ROLLE)
VALUES ('Patricia Peuleu', 'polstr. 20, 12308 Berlin', 'pat.peuleu@mail.com', 'KUNDE');
INSERT INTO PERSON (NAME, ADRESSE, EMAIL, ROLLE)
VALUES ('Kervin Kemayo', 'bergstr. 34, 17689 Berlin', 'kerv.kemayo@mail.com', 'KUNDE');

-- Beispiel Mitarbeiterdaten
INSERT INTO PERSON (NAME, ADRESSE, EMAIL, ROLLE)
VALUES ('Tin Pollmann', 'hermanstr. 23, 16758 Berlin', 'bellefriseur@mail.com', 'MITARBEITER');
INSERT INTO PERSON (NAME, ADRESSE, EMAIL, ROLLE)
VALUES ('Lola Müller', 'hermanstr. 23, 16758 Berlin', 'bellefriseur@mail.com', 'MITARBEITER');
INSERT INTO PERSON (NAME, ADRESSE, EMAIL, ROLLE)
VALUES ('Roland Reiz', 'hermanstr. 23, 16758 Berlin', 'bellefriseur@mail.com', 'MITARBEITER');
INSERT INTO PERSON (NAME, ADRESSE, EMAIL, ROLLE)
VALUES ('Moritz Curtain', 'hermanstr. 23, 16758 Berlin', 'bellefriseur@mail.com', 'MITARBEITER');
