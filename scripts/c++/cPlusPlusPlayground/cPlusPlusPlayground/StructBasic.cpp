#include "stdafx.h"
#include "StructBasic.h"
#include <iostream>
#include <string> 
using namespace std;

StructBasic::StructBasic() {}

StructBasic::~StructBasic() {}

void StructBasic::doWork() {

	struct Employee{
		int nAge;
	};

	Employee diego;
	diego.nAge = 29;

	cout << "\n Size: " << sizeof(diego) << " age: " << diego.nAge;

}

void StructBasic::doWorkArrays() {
	int anArray[5];
	anArray[0] = 10;
	anArray[1] = 20;
	anArray[2] = 30;
	anArray[3] = 40;
	anArray[4] = 50;

	cout << "\n size array 5 " << sizeof(anArray);
	cout << "\n array[4] = " << anArray[4];
}

void StructBasic::doWorkStrings() {

	char name[] = "\n Diego Pacheco";
	cout << name;

	cout << "Enter your full name: ";
	string lastName;
	cin >> lastName;
	cout << lastName;
}


void StructBasic::doWorkWithReferences() {
	
	int x = 10;
	int &y = x;

	cout << "\nX == " << x;
	cout << "\nX == " << y;

	y = 20;

	cout << "\nX == " << x;
	cout << "\nX == " << y;

}