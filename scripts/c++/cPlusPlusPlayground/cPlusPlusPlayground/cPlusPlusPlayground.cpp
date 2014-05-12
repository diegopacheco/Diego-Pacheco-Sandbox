// cPlusPlusPlayground.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

int main(){
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

	Centavos_H::Centavos centavos(0);
	centavos.doWork();

	return 0;
}
