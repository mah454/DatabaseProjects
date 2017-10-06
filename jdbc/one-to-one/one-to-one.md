## One-to-One relationship :

* Create table persons :
```oracle
CREATE TABLE PERSONS (
  ID     NUMBER,
  NAME   VARCHAR2(20),
  FAMILY VARCHAR2(20)
);
```

* Create table cars : 

```oracle
CREATE TABLE CARS (
  ID   NUMBER,
  NAME VARCHAR2(20),
  FK_PERSON NUMBER,
  FOREIGN KEY (FK_PERSON) REFERENCES PERSONS(ID) ON DELETE CASCADE 
);
```