SOURCEDIR=.
SOURCES := $(shell find $(SOURCEDIR) -name '*.go')

BINARY=bin/hello
APP_NAME=hello
PACKAGE="github.com/myapp"

VERSION=1.0.0
BUILD_TIME=`date +%FT%T%z`

LDFLAGS=-ldflags ""

.DEFAULT_GOAL: $(BINARY)

$(BINARY): $(SOURCES)
	go build ${LDFLAGS} -o ${BINARY} src/github.com/myapp/main.go

install: 
	go build ${LDFLAGS} -o ${BINARY} src/github.com/myapp/main.go

run: clean install
	@echo "--> running application..."
	@./bin/$(APP_NAME)

test:
	@echo "--> testing..."
	@go test -v $(PACKAGE)/...

clean:
	@echo "--> cleaning..."
	@go clean || (echo "Unable to clean project" && exit 1)
	@rm -rf bin/$(BINARY_NAME) 2> /dev/null
	@echo "Clean OK"

