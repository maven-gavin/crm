#!/bin/bash
echo [INFO] 开始自动化部署后台管理系统。。。。。
cd `dirname $0`
cd ..
echo [INFO] 当前目录是工程根目录：$(pwd)

mvn clean install -pl . -Dmaven.test.skip=true

echo [INFO] Install crm-common ...
cd crm-common
mvn clean install -pl . -Dmaven.test.skip=true
cd ..

echo [INFO] Install crm-core ...
cd crm-core
mvn clean install -pl . -Dmaven.test.skip=true
cd ..

echo [INFO] Install crm-client ...
cd crm-client
mvn clean install -pl . -Dmaven.test.skip=true
cd ..


