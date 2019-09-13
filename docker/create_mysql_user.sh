#!/bin/bash

mkdir -p /var/run/mysqld
chown mysql:mysql /var/run/mysqld

mysqld -u mysql > /dev/null 2>&1 &

RET=1
while [[ RET -ne 0 ]]; do
    sleep 5
    mysql -uroot -e "status" > /dev/null 2>&1
    RET=$?
done

mysql -uroot -e "CREATE USER IF NOT EXISTS'admin'@'%' IDENTIFIED BY 'wdqWR7j^#6hy43D@'"
mysql -uroot -e "GRANT ALL PRIVILEGES ON *.* TO 'admin'@'%' WITH GRANT OPTION"

if [ -f /mysql-setup.sh ] ; then
  . /mysql-setup.sh
fi

echo "=> Done!"

mysqladmin -uroot shutdown

