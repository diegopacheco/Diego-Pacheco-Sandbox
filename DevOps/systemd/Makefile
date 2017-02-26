build:
		gcc -g buggy-app.c -o buggy-app

run:
		./buggy-app

install:
		sudo touch /etc/systemd/system/buggy-app.service
		sudo sh -c "cat service.conf > /etc/systemd/system/buggy-app.service"
		systemctl start buggy-app.service
		systemctl status buggy-app.service

status:
		cat /tmp/buggy-app.log
		systemctl status buggy-app.service

remove:
		systemctl stop buggy-app.service
		sudo rm -rf /etc/systemd/system/buggy-app.service

clean:
		rm -rf buggy-app
		rm -rf /tmp/buggy-app.log
		
