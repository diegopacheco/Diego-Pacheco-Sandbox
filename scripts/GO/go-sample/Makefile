SOURCEDIR=.
SOURCES := $(shell find $(SOURCEDIR) -name '*.go')
BINARY=bin/hello
APP_NAME=hello
PACKAGE="github.com/myapp"
VERSION=1.0.0
BUILD_TIME=`date +%FT%T%z`
LDFLAGS=-ldflags ""

default: help

install: $(SOURCES) ## install: build the binary
	go build ${LDFLAGS} -o ${BINARY} src/github.com/myapp/main.go

run: clean install ## run: clean, install and run the program
	@echo "--> running application..."
	@./bin/$(APP_NAME)

test: ## test: run the tests
	@echo "--> testing..."
	@go test -v $(PACKAGE)/...

clean: ## clean: delete the binary
	@echo "--> cleaning..."
	@go clean || (echo "Unable to clean project" && exit 1)
	@rm -rf bin/$(BINARY_NAME) 2> /dev/null
	@echo "Clean OK"

help: ## help: list all commands
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'
