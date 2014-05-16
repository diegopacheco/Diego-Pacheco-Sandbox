#include "stdafx.h"
#include "ThreadFun.h"
#include <stdio.h>
#include <iostream>
#include <thread>

using namespace std;

void functionThreaded() {
	std::cout << "\nHellow World Thread\n" << std::endl;
}

void ThreadFun::doWork() {
	std::thread t1(functionThreaded);
	t1.join();
}