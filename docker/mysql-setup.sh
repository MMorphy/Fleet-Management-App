#!/bin/bash

echo "Importing data"

mysql -uroot < /schema.sql
mysql -uroot < /data.sql
