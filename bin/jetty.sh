#!/bin/bash
echo [INFO] 启动Web应用程序
echo [INFO] jetty starting

cd `dirname $0`
cd ../crm-admin

mvn clean jetty:run -Dmaven.test.skip=true



