#!/bin/bash
echo [INFO] DROP数据库
echo [INFO] 请确认数据库编码为utf-8
echo [INFO] 请确认修改了 crm／crm-admin／pom.xml中
echo [INFO] connection.admin.url
echo [INFO] connection.username
echo [INFO] password

cd `dirname $0`
cd ../crm-admin

echo [INFO] 开始DROP建数据库。。。。。
mvn db:drop
cd ../bin
