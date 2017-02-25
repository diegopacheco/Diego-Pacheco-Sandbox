build:
		mkdir dist/ 2> /dev/null || true
		gcc -g src/simple.c -o dist/simple

debug:
		gdb dist/simple -tui

run:
		dist/simple

clean:
		rm -rf dist/
