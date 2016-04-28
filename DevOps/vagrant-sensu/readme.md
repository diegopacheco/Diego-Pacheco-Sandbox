How It works
============

Sensu Server: 10.10.99.60 - Server, RabbitMQ, Uchiwa <BR>
Sensu Client: 10.10.99.50 - Client                   <BR>  

```bash
vagrant up
```

You need make sure Client bootsup before the server. If Uchiwa does not show data. Do this: <BR>

```bash
vagrant ssh sensu-server
sudo /etc/init.d/sensu-server restart
sudo /etc/init.d/uchiwa restart
```

Goto: http://10.10.99.60:3000/

