build:
		gcc -g buggy-app.c -o buggy-app

run:
		./buggy-app

install:
	  touch /tmp/buggy-app.log
		sudo touch /etc/init/buggy-app.conf
		sudo sh -c "cat service.conf > /etc/init/buggy-app.conf"
		init-checkconf /etc/init/buggy-app.conf
		sudo initctl start buggy-app

status:
		cat /tmp/buggy-app.log
		sudo initctl status buggy-app
		ps aux | grep buggy-app

restart:
		sudo initctl restart buggy-app

tail:
		clear
		tail -f /tmp/buggy-app.log

remove:
		sudo initctl stop buggy-app
		sudo rm -rf /etc/init/buggy-app.conf

clean:
		rm -rf buggy-app
		rm -rf /tmp/buggy-app.log
