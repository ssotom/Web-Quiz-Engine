# Web Quiz Engine
In the Internet, you can often find sites where you need to answer some questions. It can be educational sites, sites with psychological tests, job search services, or just entertaining sites like web quests. The common thing for them is the ability to answer questions (or quizzes) and then see some results. In this project, I developed a multi-users web service for creating and solving quizzes.

**Dependencies:**

- spring-boot-starter-data-web
- spring-boot-starter-data-jpa

**DB:** H2

Navigate to http://localhost:8889/

### API
**`[GET] api/quizzes`** :

**Body response:**
```json
[
 {
   "id": 1,
   "title": "Coffee drinks",
   "text": "Select only coffee drinks.",
   "options": ["Americano","Tea","Cappuccino","Sprite"]
 }
]
```

**`[GET] api/quizzes/{id}`** :

**Body response:**
```json
{
  "id": 1,
  "title": "Coffee drinks",
  "text": "Select only coffee drinks.",
  "options": ["Americano","Tea","Cappuccino","Sprite"]
}
```

**`[POST] api/quizzes`**

**Body request:**
```json
{
  "title": "Coffee drinks",
  "text": "Select only coffee drinks.",
  "options": ["Americano","Tea","Cappuccino","Sprite"],
  "answer": [0,2]
}
```

**Body response:**
```json
{
  "id": 1,
  "title": "Coffee drinks",
  "text": "Select only coffee drinks.",
  "options": ["Americano","Tea","Cappuccino","Sprite"]
}
```

**`[POST] api/quizzes/{id}/solve`**

**Body request:**
```json
{
 "answer": [0,2]
}
```

**Body response:**
```json
{
 "success":true,
 "feedback":"Congratulations, you're right!"
}
```

 This project is a part of the Java Developer track of [JetBrains Academy](https://www.jetbrains.com/academy/)

 Project from: https://hyperskill.org/projects/42
 
 My profile: https://hyperskill.org/profile/36829794
