#pragma once

#ifndef Centavos_H
#define Centavos_H

class Centavos{
private:
	Centavos();
	int m_nCents;
public:
	Centavos(int n);
	~Centavos();
	void doWork();
	int getValor();
	// Add Cents + Cents
	friend Centavos operator+(const Centavos &c1, const Centavos &c2);
};

#endif