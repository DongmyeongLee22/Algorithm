### NULL 처리
```sql
// 
SELECT ANIMAL_TYPE
    ,case when name is null then "No name" else name end "NAME"
    , SEX_UPON_INTAKE from ANIMAL_INS order by animal_id;
```

```sql
// DATETIME에서 DATE로 형변환 문제
SELECT animal_id, name, date_format(datetime, '%Y-%m-%d') as "날짜" 
    FROM animal_ins
    ORDER BY animal_id;
```