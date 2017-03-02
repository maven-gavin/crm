#!/bin/bash
echo [INFO]  init schema/data.
echo [INFO] confirm has created db.

cd `dirname $0`
cd ../crm-admin

echo [INFO] init schema...
mvn db:schema

echo [INFO] init data....
mvn db:data

