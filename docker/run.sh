#!/bin/bash

VOLUME_HOME="/var/lib/mysql"

if [[ ! -d $VOLUME_HOME/mysql ]]; then
    mysqld --initialize-insecure --user=mysql > /dev/null 2>&1
    /create_mysql_user.sh
else
    echo "=> Using an existing volume of MySQL"
fi

exec supervisord -n