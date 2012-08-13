"""
fleetdb.py - Python interface to FleetDB (http://fleetdb.org/)
 
Library Maintainer:  
    Matt Culbreth
    mattculbreth@gmail.com
    http://github.com/mattc58/fleetdb-python 
#####################################################################
 
This work is distributed under an MIT License: 
http://www.opensource.org/licenses/mit-license.php
 
The MIT License
 
Copyright (c) 2010 Matt Culbreth (http://mattculbreth.com)
 
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
 
The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.
 
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 
#####################################################################
 
Hello, this is an open source Python library that serves as an interface to FleetDB.
    
USAGE:
 
    import fleetdb
    
    db = fleetdb.FleetDBClient("localhost", 3400)
    companies = db.select("companies")
    print companies
    db.insert("companies", [ { 'id' : 1, 'name' : 'Yield Idea'}, { 'id' : 2, 'name' : 'GitHub'} ])
    companies = db.select("companies")
    print companies
    
"""
import socket
import json

class FleetDBClient(object):
    '''
    This class serves as a connection to a FleetDB instance
    '''
    
    # the valid commands to FleetDB
    valid_commands = ["ping", "insert", "select", "count", "delete",
        "create-index", "drop-index", "multi-read", "multi-write",
        "checked-write", "explain", "list-collections", 
        "list-indexes", "compact"]
    PACKET_SIZE = 2048
        
    def __init__(self, host, port, auto_connect=True):
        '''
        The constructor, which will automatically connect to FleetDB unless
        requested not to
        '''
        super(FleetDBClient, self).__init__()
        self._host = host
        self._port = port
        self._socket = None
        
        if auto_connect:
            self.connect()
            
    def connect(self):
        '''
        Connect to FleetDB
        '''
        if self._socket:
            self._socket.close()
        self._socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self._socket.connect((self._host, self._port))
        
    def _test_socket(self):
        '''
        Test that the socket is there and connected
        '''
        assert self._socket, "Not connected to FleetDB, please call connect()"
        
    def _send_command(self, command):
        '''
        Send a command to FleetDB
        '''
        self._test_socket()
        
        # send the command
        doc = "%s\r\n" % json.dumps(command)
        length = self._socket.send(doc)
        assert length == len(doc), "Did not send complete document to FleetDB"
        
        # get the response
        response = ""
        while True:
            data = self._socket.recv(self.PACKET_SIZE)
            if not data:
                break
            response += data
            if len(data) < self.PACKET_SIZE:
                break
                
        # check for success
        response = json.loads(response)
        assert self._check_success(response), "Error: %s" % (response[1] if response and len(response) > 0 else "with command")
        return response
        
    def _check_success(self, response):
        '''
        Check that a message back from FleetDB is showing success
        '''
        return isinstance(response, list) and len(response) > 0 and response[0] == 0
        
    def query(self, command, *options):
        '''
        Send a user-specified query to the database.
        command = a valid fleetdb command
        options = any other data required for command
        '''
        assert command in self.valid_commands, \
            "The %s command is not in the list of valid commands: %s" % (command, self.valid_commands)
        msg = [command]
        msg.extend(options)
        
        response = self._send_command(msg)
        return response[1]
        
    def ping(self):
        '''
        Send the ping command to FleetDB and return True / False if it's 
        responding
        '''
        response = self.query("ping")
        return response == "pong"
        
    def insert(self, collection_name, data):
        '''
        Insert data into the specified collection.
        Returns how many records were inserted.
        '''
        # make sure the data is a dict or a list
        if isinstance(data, list):
            assert False not in [isinstance(record, dict) for record in data], "Each record in a list should be a dict"
        assert isinstance(data, dict) or isinstance(data, list), \
            "Data needs to be a dict for 1 record or a list of dictionaries for multiple"
        
        return self.query("insert", collection_name, data)
        
    def _select(self, command, collection_name, find_options=None):
        '''
        Query the database for the given collection_name and optional find_options
        '''
        msg = [collection_name]
        if find_options:
            msg.append(find_options)

        return self.query(command, *msg)

    def select(self, collection_name, find_options=None):
        '''
        Query the database for the given collection_name and optional find_options
        '''
        return self._select("select", collection_name, find_options)
        
    def count(self, collection_name, find_options=None):
        '''
        Return the number of records in the given collection, with optional find_options
        '''
        if find_options:
            assert "only" not in find_options.keys(), "count() does not support the only option"
        return self._select("count", collection_name, find_options)
 
