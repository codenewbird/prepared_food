### 本地数据库创建脚本
```sql
CREATE DATABASE preparedFood;

use preparedFood;


CREATE TABLE storageRecord(
    batch VARCHAR(128),
    hashkey VARCHAR(255)
);

CREATE TABLE productRecord(
    batch VARCHAR(128) PRIMARY KEY,
    rawMaterial_hash VARCHAR(128),
    ingredient_hash VARCHAR(128),
    nutrition_hash VARCHAR(128),
    baseInfo_hash VARCHAR(128),
    productionLine_hash VARCHAR(128)
);

INSERT INTO productRecord values("123",
"L/2iXmOMcLYivkIWcNn17uAYXut2l38lvQfWyFh8E5M=",
"GNlRC4BW3gCiiIqGHkaPxQpm7xduwsZcInBk/y3VHUg=",
"pbozHCZ6+mddRZaMzDkVwOmp+pWtvlWg/hDzEVmmYug=",
"tYQJFZNAdrFYzg4WH66ZET+bFuwoVMsQ7kIhedVjAxM=",
"qy8ma/YLvgQDvX3K1nChdvZ3hX//u5/5v0rpqI+vy9o=");

INSERT INTO storageRecord values
("123","FVwQGeBVa69P/qXyHfenHqb4UxHhl+nRSZrpNGtBkps="),
("123","jC9Yf50s0jkFf31X6ZoQdCEOSWm+QaUMQJRaZ7MP1tY="),
("123","G4UgmGt/5bJb096CMVAALuun+ymZWQmu3ljupWCy8TA="),
("123","RG3uCETEydtggpXjeWPMfXc7nQanKYyE+2jUyVh+Es4=");

```
第二次迭代
```
CREATE DATABASE preparedFood2;

use preparedFood2;

CREATE TABLE baseInfo(
    identificationCode VARCHAR(50) PRIMARY KEY,
    name VARCHAR(50),
    shelfLife DATE,
    manufacturer VARCHAR(50),
    description VARCHAR(128)
);

CREATE TABLE ingredient(
    identificationCode VARCHAR(50),
    detail VARCHAR(255),
    FOREIGN KEY(identificationCode) REFERENCES baseInfo(identificationCode)
);

CREATE TABLE rawMaterial(
    identificationCode VARCHAR(50),
    detail VARCHAR(255),
    FOREIGN KEY(identificationCode) REFERENCES baseInfo(identificationCode)
);

CREATE TABLE nutrition(
    identificationCode VARCHAR(50),
    detail VARCHAR(255),
    FOREIGN KEY(identificationCode) REFERENCES baseInfo(identificationCode)
);

CREATE TABLE procedure2(
    identificationCode VARCHAR(50),
    rank INT,
    description VARCHAR(255),
    monitorPointId VARCHAR(50),
    FOREIGN KEY(identificationCode) REFERENCES baseInfo(identificationCode)
);
```
