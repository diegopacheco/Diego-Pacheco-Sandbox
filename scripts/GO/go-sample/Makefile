SOURCEDIR=.
SOURCES := $(shell find $(SOURCEDIR) -name '*.go')

BINARY=bin/hello

VERSION=1.0.0
BUILD_TIME=`date +%FT%T%z`

LDFLAGS=-ldflags ""

.DEFAULT_GOAL: $(BINARY)

$(BINARY): $(SOURCES)
	go build ${LDFLAGS} -o ${BINARY} src/github.com/myapp/main.go
