#include "stdafx.h"
#include <iostream>
using namespace std;

#include "StdCBasic.h"

StdCBasic::StdCBasic() {
};

StdCBasic::~StdCBasic() {
};

void StdCBasic::doWork() {

	double in;
	double result = 5 + 5;

	cout << "Digite um numero ";
	cin >> in;

	if (in == result){
		cout << result;
	} else {
		cout << "Not the same";
	}

}

void StdCBasic::doWorkSwicth() {

	int x = 1;
	switch (x){
		case 1: cout << "Eh 1 switch";
		break;
		case 2: cout << "Eh 2 switch";
		break;
		default:
			cout << "Eh ??? switch";
	}
}

void StdCBasic::doWorkWhile() {
	int i = 10;
	while (i >= 1){
		cout << "\n" << " 2 X " << i << " = " << (2 * i);
		i = i--;
	}
}

void StdCBasic::doWorkFor() {
	for (int i = 0; i < 10; i++){
		cout << "\n" << i;
	}
}

