// 创建root用户（如果环境变量未生效）
db = db.getSiblingDB("admin");
db.createUser({
  user: "admin",
  pwd: "admin123",
  roles: [
    { role: "root", db: "admin" }
  ]
});

// 创建springbootdb数据库的用户
db = db.getSiblingDB("springbootdb");
db.createUser({
  user: "admin",
  pwd: "admin123",
  roles: [
    { role: "readWrite", db: "springbootdb" },
    { role: "dbAdmin", db: "springbootdb" }
  ]
});