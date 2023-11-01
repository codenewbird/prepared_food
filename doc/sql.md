### 本地数据库创建脚本
```sql
CREATE DATABASE preparedFood;

use preparedFood;


CREATE TABLE storageRecord(
    batch VARCHAR(128) PRIMARY KEY,
    hashkey VARCHAR(255)
);

CREATE TABLE productRecord(
    batch VARCHAR(128) PRIMARY KEY,
    rawMaterial_hash VARCHAR(255),
    ingredient_hash VARCHAR(255),
    nutrition_hash VARCHAR(255)
);

INSERT INTO productRecord values("123","TfIibINd4eOZ8DzNpGnm91g1JVch0Int1Mm4GMJhvSA=","IpQjVJOwiixI1vLd+tMDspStLCq3BmvpLA+Glnxs3FU=","Zm9FB6XrA9UdG58k1kcsyYklgTSmdUoy44dhwOJ1KCw=")

```

