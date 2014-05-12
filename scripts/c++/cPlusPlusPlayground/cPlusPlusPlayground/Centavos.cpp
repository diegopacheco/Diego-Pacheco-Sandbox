#include "stdafx.h"
#include "Centavos.h"
#include <iostream>
using namespace std;

Centavos::Centavos(int n){
	m_nCents = n;
}

Centavos::~Centavos() {}

int Centavos::getValor() {
	return m_nCents;
}

// Add Cents + Cents
Centavos operator+(const Centavos &c1, const Centavos &c2) {
	return Centavos(c1.m_nCents + c2.m_nCents);
};

void Centavos::doWork() {
	
	Centavos cent1 = Centavos(10);
	Centavos cent2 = Centavos(3);

	Centavos cent3 = cent1 + cent2;
	cout << "\n Centavos + override: " << cent3.getValor();
	
};


