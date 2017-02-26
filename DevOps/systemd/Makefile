build:
		gcc -g buggy-app.c -o buggy-app

run:
		./buggy-app

install:
	  sudo touch /tmp/buggy-app.log
		sudo touch /etc/systemd/system/buggy-app.service
		sudo sh -c "cat service.conf > /etc/systemd/system/buggy-app.service"
		systemctl start buggy-app.service
		systemctl daemon-reload
		systemctl status buggy-app.service

status:
		cat /tmp/buggy-app.log
		systemctl status buggy-app.service
		ps aux | grep buggy-app

restart:
				systemctl restart buggy-app.service

tail:
			 clear
			 tail -f /tmp/buggy-app.log

remove:
		systemctl stop buggy-app.service
		sudo rm -rf /etc/systemd/system/buggy-app.service

clean:
		rm -rf buggy-app
		rm -rf /tmp/buggy-app.log

tasks:
		cat help.txt
