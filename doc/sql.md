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
    rawMaterial_hash VARCHAR(255),
    ingredient_hash VARCHAR(255),
    nutrition_hash VARCHAR(255),
    baseInfo_hash VARCHAR(255)
);

INSERT INTO productRecord values("123",
"L/2iXmOMcLYivkIWcNn17uAYXut2l38lvQfWyFh8E5M=",
"GNlRC4BW3gCiiIqGHkaPxQpm7xduwsZcInBk/y3VHUg=",
"pbozHCZ6+mddRZaMzDkVwOmp+pWtvlWg/hDzEVmmYug=",
"tYQJFZNAdrFYzg4WH66ZET+bFuwoVMsQ7kIhedVjAxM=");

INSERT INTO storageRecord values
("123","FVwQGeBVa69P/qXyHfenHqb4UxHhl+nRSZrpNGtBkps="),
("123","jC9Yf50s0jkFf31X6ZoQdCEOSWm+QaUMQJRaZ7MP1tY="),
("123","G4UgmGt/5bJb096CMVAALuun+ymZWQmu3ljupWCy8TA="),
("123","RG3uCETEydtggpXjeWPMfXc7nQanKYyE+2jUyVh+Es4=");

```


