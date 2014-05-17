// cPlusPlusPlayground.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "CppLinq\cpplinq.hpp"
#include <iostream>
using namespace std;

// https://cpplinq.codeplex.com/wikipage?title=LINQ%20for%20C%2b%2b%20-%20getting%20started&referringTitle=Home
int computes_a_sum() {
	using namespace cpplinq;
	int ints[] = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 4 };

	auto result = from_array(ints)
		>> where([](int i) {return i % 2 == 0; })  // Keep only even numbers
		>> sum()                               // Sum remaining numbers
		;
	return result;
}

int main(){
	// Linq for c++
	std::cout << "Linq C++ => " << computes_a_sum();

	// IFs, While, For
	StdCBasic_H::StdCBasic basic;
	basic.doWork();
	basic.doWorkSwicth();
	basic.doWorkWhile();
	basic.doWorkFor();

	// Structs, Classes, Contructors
	StructBasic_H::StructBasic structbasic;
	structbasic.doWork();
	structbasic.doWorkArrays();
	structbasic.doWorkStrings();
	structbasic.doWorkWithReferences();

	// + override
	Centavos_H::Centavos centavos(0);
	centavos.doWork();

	//Threads
	Threads_H::ThreadFun tf;
	tf.doWork();

	return 0;
}
